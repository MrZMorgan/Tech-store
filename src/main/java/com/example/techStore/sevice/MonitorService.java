package com.example.techStore.sevice;

import com.example.techStore.dto.MonitorDTO;
import com.example.techStore.entity.Monitor;
import com.example.techStore.reository.MonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public Monitor save(final Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public List<Monitor> findAll() {
        return monitorRepository.findAll();
    }

    public Monitor getById(final int id) {
        return monitorRepository.getReferenceById(id);
    }

    public Monitor update(final MonitorDTO monitorDTO) {
        final var monitor = monitorRepository.getReferenceById(monitorDTO.getId());
        monitor.setQuantity(monitorDTO.getQuantity());
        monitor.setSerialNumber(monitorDTO.getSerialNumber());
        monitor.setPrice(monitorDTO.getPrice());
        monitor.setScreenSize(monitorDTO.getScreenSize());
        return monitorRepository.save(monitor);
    }
}
