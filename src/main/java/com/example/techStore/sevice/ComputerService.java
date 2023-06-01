package com.example.techStore.sevice;

import com.example.techStore.dto.ComputerDTO;
import com.example.techStore.entity.Computer;
import com.example.techStore.reository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public Computer save(final Computer computer) {
        return computerRepository.save(computer);
    }

    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    public Computer getById(int id) {
        return computerRepository.getReferenceById(id);
    }

    public Computer update(final ComputerDTO computerDTO) {
        final var computer = computerRepository.getReferenceById(computerDTO.getId());
        computer.setQuantity(computerDTO.getQuantity());
        computer.setSerialNumber(computerDTO.getSerialNumber());
        computer.setPrice(computerDTO.getPrice());
        computer.setFormFactor(computerDTO.getFormFactor());
        return computerRepository.save(computer);
    }
}
