package com.example.techStore.dto;

import com.example.techStore.entity.Monitor;
import com.example.techStore.enums.MonitorScreenSize;
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
public class MonitorDTO extends Product {

    private MonitorScreenSize screenSize;

    public static MonitorDTO of(final Monitor monitor) {
        final var dto = new MonitorDTO();
        dto.setId(monitor.getId());
        dto.setQuantity(monitor.getQuantity());
        dto.setPrice(monitor.getPrice());
        dto.setSerialNumber(monitor.getSerialNumber());
        dto.setScreenSize(monitor.getScreenSize());
        return dto;
    }
}
