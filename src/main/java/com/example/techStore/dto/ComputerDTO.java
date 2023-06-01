package com.example.techStore.dto;

import com.example.techStore.entity.Computer;
import com.example.techStore.enums.ComputerFormFactor;
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
public class ComputerDTO extends Product{

    private ComputerFormFactor formFactor;

    public static ComputerDTO of(final Computer computer) {
        final var dto = new ComputerDTO();
        dto.setId(computer.getId());
        dto.setQuantity(computer.getQuantity());
        dto.setPrice(computer.getPrice());
        dto.setSerialNumber(computer.getSerialNumber());
        dto.setFormFactor(computer.getFormFactor());
        return dto;
    }
}
