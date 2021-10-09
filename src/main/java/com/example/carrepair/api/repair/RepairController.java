package com.example.carrepair.api.repair;

import com.example.carrepair.model.car.dto.CarDto;
import com.example.carrepair.model.category.dto.CategoryDto;
import com.example.carrepair.model.client.dto.ClientDto;
import com.example.carrepair.model.mechanic.dto.MechanicDto;
import com.example.carrepair.model.repair.RepairService;
import com.example.carrepair.model.repair.dto.RepairDto;
import com.example.carrepair.model.repair.exception.InvalidAssignmentException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/repairs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RepairController {

    private final RepairService repairService;

    @GetMapping
    public List<RepairDto> getAll(){
        return repairService.findAll();
    }

    @GetMapping("/client")
    public ClientDto getTheMostFrequentlyClient(){
        return repairService.findTheMostFrequentlyClient();
    }

    @GetMapping("/car")
    public CarDto getTheMostFrequentlyCar(){
        return repairService.findTheMostFrequentlyCar();
    }

    @GetMapping("/category")
    public CategoryDto getTheMostFrequentlyCategory(){
        return repairService.findTheMostFrequentlyCategory();
    }

    @GetMapping("/mechanic")
    public MechanicDto getTheMostFrequentlyMechanic(){
        return repairService.findTheMostFrequentlyMechanic();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairDto> findById(@PathVariable Long id){
        return repairService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepairDto createRepair(@RequestBody RepairDto repair){
        RepairDto savedRepair;
        try {
            savedRepair = repairService.createRepair(repair);
        }catch (InvalidAssignmentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return savedRepair;
    }

    @PostMapping("/{id}/end")
    @ResponseStatus(HttpStatus.CREATED)
    public LocalDateTime finishRepair(@PathVariable Long id){
        return repairService.finishRepair(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public double assignPrice(@PathVariable Long id, @RequestParam double price ){
        return repairService.assignPrice(id,price);
    }
}
