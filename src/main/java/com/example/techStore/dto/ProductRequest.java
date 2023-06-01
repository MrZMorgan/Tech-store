package com.example.techStore.dto;

import com.example.techStore.enums.ProductType;
import com.example.techStore.objectMapping.ProductRequestDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@JsonDeserialize(using = ProductRequestDeserializer.class)
public class ProductRequest {

    private ProductType type;
    private Product product;
}
