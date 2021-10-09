package com.example.carrepair.model.mechanic;

import com.example.carrepair.model.category.Category;
import com.example.carrepair.model.mechanic.dto.MechanicDto;
import com.example.carrepair.model.mechanic.dto.MechanicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MechanicService {

    private final MechanicRepository mechanicRepository;
    MechanicMapper mechanicMapper = new MechanicMapper();

    public List<MechanicDto> findAll(){
        return mechanicRepository.findAll()
                .stream()
                .map(mechanicMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<String> findALlEmails() {
        return mechanicRepository.findAll()
                .stream()
                .map(Mechanic::getEmail)
                .collect(Collectors.toList());
    }


    public Optional<MechanicDto> findById(Long id){
        return mechanicRepository.findById(id).map(mechanicMapper::toDto);
    }

    public void removeMechanic(Long id){
        mechanicRepository.deleteById(id);
    }

    public MechanicDto save(MechanicDto mechanic){
        Optional<Mechanic> clientByEmail = mechanicRepository.findByEmail(mechanic.getEmail());
        clientByEmail.ifPresent(a ->{
            throw new DuplicateEmailException();
        });
        return mapAndSave(mechanic);
    }

    private MechanicDto mapAndSave(MechanicDto mechanic) {
        Mechanic mechanicEntity = mechanicMapper.toEntity(mechanic);
        Mechanic savedMechanic = mechanicRepository.save(mechanicEntity);
        return mechanicMapper.toDto(savedMechanic);
    }
}
