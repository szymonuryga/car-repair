package com.example.carrepair.model.client;

import com.example.carrepair.model.client.dto.ClientDto;
import com.example.carrepair.model.client.dto.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    ClientMapper clientMapper = new ClientMapper();

    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<String> findALlNationalId() {
        return clientRepository.findAll()
                .stream()
                .map(Client::getNationalId)
                .collect(Collectors.toList());
    }


    public Optional<ClientDto> findById(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientDto save(ClientDto client) {
        Optional<Client> clientByNationalId = clientRepository.findClientByNationalId(client.getNationalId());
        clientByNationalId.ifPresent(a -> {
            throw new DuplicateNationalIdException();
        });
        return mapAndSave(client);
    }

    public ClientDto update(ClientDto client) {
        Optional<Client> clientByNationalId = clientRepository.findClientByNationalId(client.getNationalId());
        clientByNationalId.ifPresent(a -> {
            if (!a.getId().equals(client.getId()))
                throw new DuplicateNationalIdException();
        });
        return mapAndSave(client);
    }

    private ClientDto mapAndSave(ClientDto client) {
        Client clientEntity = clientMapper.toEntity(client);
        Client savedClient = clientRepository.save(clientEntity);
        return clientMapper.toDto(savedClient);
    }
}
