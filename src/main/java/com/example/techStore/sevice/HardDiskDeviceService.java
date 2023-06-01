package com.example.techStore.sevice;

import com.example.techStore.dto.HardDiscDeviceDTO;
import com.example.techStore.entity.HardDiskDevice;
import com.example.techStore.reository.HardDiskDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HardDiskDeviceService {

    private final HardDiskDeviceRepository diskRepository;

    public HardDiskDevice save(final HardDiskDevice hardDiskDevice) {
        return diskRepository.save(hardDiskDevice);
    }

    public List<HardDiskDevice> findAll() {
        return diskRepository.findAll();
    }

    public HardDiskDevice getById(final int id) {
        return diskRepository.getReferenceById(id);
    }

    public HardDiskDevice update(final HardDiscDeviceDTO hardDiskDeviceDTO) {
        final var hardDiskDevice = diskRepository.getReferenceById(hardDiskDeviceDTO.getId());
        hardDiskDevice.setQuantity(hardDiskDeviceDTO.getQuantity());
        hardDiskDevice.setSerialNumber(hardDiskDeviceDTO.getSerialNumber());
        hardDiskDevice.setPrice(hardDiskDeviceDTO.getPrice());
        hardDiskDevice.setCapacity(hardDiskDeviceDTO.getCapacity());
        return diskRepository.save(hardDiskDevice);
    }
}
