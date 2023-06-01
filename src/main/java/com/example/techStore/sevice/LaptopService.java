package com.example.techStore.sevice;

import com.example.techStore.dto.LaptopDTO;
import com.example.techStore.entity.Laptop;
import com.example.techStore.reository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public Laptop save(final Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    public Laptop getById(final int id) {
        return laptopRepository.getReferenceById(id);
    }

    public Laptop update(final LaptopDTO laptopDTO) {
        final var laptop = laptopRepository.getReferenceById(laptopDTO.getId());
        laptop.setQuantity(laptopDTO.getQuantity());
        laptop.setSerialNumber(laptopDTO.getSerialNumber());
        laptop.setPrice(laptopDTO.getPrice());
        laptop.setScreenSize(laptopDTO.getScreenSize());
        return laptopRepository.save(laptop);
    }
}
