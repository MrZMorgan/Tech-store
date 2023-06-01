package com.example.techStore.dto;

import com.example.techStore.entity.Laptop;
import com.example.techStore.enums.LaptopScreenSize;
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
public class LaptopDTO extends Product {

    private LaptopScreenSize screenSize;

    public static LaptopDTO of(final Laptop laptop) {
        final var dto = new LaptopDTO();
        dto.setId(laptop.getId());
        dto.setQuantity(laptop.getQuantity());
        dto.setPrice(laptop.getPrice());
        dto.setSerialNumber(laptop.getSerialNumber());
        dto.setScreenSize(laptop.getScreenSize());
        return dto;
    }
}
