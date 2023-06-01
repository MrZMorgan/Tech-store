package com.example.techStore.dto;

import com.example.techStore.entity.HardDiskDevice;
import com.example.techStore.enums.HardDiskDeviceCapacity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HardDiscDeviceDTO extends Product{

    private HardDiskDeviceCapacity capacity;

    public static HardDiscDeviceDTO of(final HardDiskDevice device) {
        final var dto = new HardDiscDeviceDTO();
        dto.setId(device.getId());
        dto.setQuantity(device.getQuantity());
        dto.setPrice(device.getPrice());
        dto.setSerialNumber(device.getSerialNumber());
        dto.setCapacity(device.getCapacity());
        return dto;
    }
}
