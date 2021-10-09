package com.example.carrepair.model.repair;

import com.example.carrepair.model.car.Car;
import com.example.carrepair.model.car.CarRepository;
import com.example.carrepair.model.car.dto.CarDto;
import com.example.carrepair.model.car.dto.CarMapper;
import com.example.carrepair.model.category.Category;
import com.example.carrepair.model.category.CategoryRepository;
import com.example.carrepair.model.category.dto.CategoryDto;
import com.example.carrepair.model.category.dto.CategoryMapper;
import com.example.carrepair.model.client.Client;
import com.example.carrepair.model.client.ClientRepository;
import com.example.carrepair.model.client.dto.ClientDto;
import com.example.carrepair.model.client.dto.ClientMapper;
import com.example.carrepair.model.mechanic.Mechanic;
import com.example.carrepair.model.mechanic.MechanicRepository;
import com.example.carrepair.model.mechanic.dto.MechanicDto;
import com.example.carrepair.model.mechanic.dto.MechanicMapper;
import com.example.carrepair.model.repair.dto.RepairDto;
import com.example.carrepair.model.repair.dto.RepairMapper;
import com.example.carrepair.model.repair.exception.InvalidAssignmentException;
import com.example.carrepair.model.repair.exception.RepairAlreadyFinishedException;
import com.example.carrepair.model.repair.exception.RepairNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepairService {

    private final RepairRepository repairRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;
    private final MechanicRepository mechanicRepository;
    CarMapper carMapper = new CarMapper();
    MechanicMapper mechanicMapper = new MechanicMapper();
    ClientMapper clientMapper = new ClientMapper();

    public List<RepairDto> findAll(){
        return repairRepository.findAll()
                .stream()
                .map(RepairMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<RepairDto> findById(Long id){
        return repairRepository.findById(id).map(RepairMapper::toDto);
    }

    @Transactional
    public double assignPrice(Long repairId, double price){
        Optional<Repair> repair = repairRepository.findById(repairId);
        Repair repairEntity = repair.orElseThrow(RepairNotFoundException::new);
        repairEntity.setPrice(price);
        return repairEntity.getPrice();
    }

    @Transactional
    public LocalDateTime finishRepair(Long repairId) {
        Optional<Repair> repair = repairRepository.findById(repairId);
        Repair repairEntity = repair.orElseThrow(RepairNotFoundException::new);
        if (repairEntity.getEnd() != null)
            throw new RepairAlreadyFinishedException();
        else
            repairEntity.setEnd(LocalDateTime.now());
        return repairEntity.getEnd();
    }

    public RepairDto createRepair(RepairDto repair) {
        Optional<Repair> activeRepairAndAvailableMechanic = repairRepository.findByMechanic_EmailAndEndIsNull(repair.getEmail());
        activeRepairAndAvailableMechanic.ifPresent(a -> {
            throw new InvalidAssignmentException("Given mechanic is not avaible");
        });
        Optional<Client> client = clientRepository.findClientByNationalId(repair.getNationalId());
        Optional<Car> car = carRepository.findByRegistrationNumber(repair.getRegistrationNumber());
        Optional<Category> category = categoryRepository.findByName(repair.getCategory());
        Repair repairEntity = new Repair();
        String nationalId = repair.getNationalId();
        String registrationNumber = repair.getRegistrationNumber();
        String name = repair.getCategory();
        repairEntity.setClient(client.orElseThrow(() ->
                new InvalidAssignmentException("No client with national Id:" + nationalId)
        ));
        repairEntity.setCar(car.orElseThrow(() ->
                new InvalidAssignmentException("No car with registration number: " + registrationNumber)
        ));
        repairEntity.setCategory(category.orElseThrow(() ->
                new InvalidAssignmentException("No category with given name: " + name)
        ));
        Optional<Mechanic> mechanic = mechanicRepository.findByEmail(repair.getEmail());
        repairEntity.setMechanic(mechanic.orElseThrow(()->
                new InvalidAssignmentException("No mechanic with given email"+ repair.getEmail())));
        repairEntity.setStart(LocalDateTime.now());
        return RepairMapper.toDto(repairRepository.save(repairEntity));
    }

    public ClientDto findTheMostFrequentlyClient() {
        return repairRepository.findTheMostFrequentlyClient()
                .stream()
                .findFirst()
                .map(clientMapper::toDto)
                .orElseThrow(() -> new InvalidAssignmentException("No client found"));
    }

    public CarDto findTheMostFrequentlyCar() {
        return repairRepository.findTheMostFrequentlyCar()
                .stream()
                .findFirst()
                .map(carMapper::toDto)
                .orElseThrow(() -> new InvalidAssignmentException("No car found"));
    }

    public MechanicDto findTheMostFrequentlyMechanic() {
        return repairRepository.findTheMostFrequentlyMechanic()
                .stream()
                .findFirst()
                .map(mechanicMapper::toDto)
                .orElseThrow(() -> new InvalidAssignmentException("No mechanic found"));
    }

    public CategoryDto findTheMostFrequentlyCategory() {
       return repairRepository.findTheMostFrequentlyCategory()
               .stream()
               .findFirst()
               .map(CategoryMapper::toDto)
               .orElseThrow(() -> new InvalidAssignmentException("No category found"));
    }

}
