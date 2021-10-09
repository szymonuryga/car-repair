package com.example.carrepair.api.mechanic;

import com.example.carrepair.model.mechanic.MechanicService;
import com.example.carrepair.model.mechanic.dto.MechanicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mechanics")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MechanicController {

    private final MechanicService mechanicService;


    @GetMapping
    public List<MechanicDto> findAll(){
        return mechanicService.findAll();
    }

    @GetMapping("/emails")
    public List<String> findALlEmails(){
        return mechanicService.findALlEmails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechanicDto> findById(@PathVariable Long id){
        return mechanicService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MechanicDto createMechanic(@RequestBody MechanicDto mechanic) {
        return mechanicService.save(mechanic);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMechanic(@PathVariable Long id) {
        mechanicService.removeMechanic(id);
    }
}
