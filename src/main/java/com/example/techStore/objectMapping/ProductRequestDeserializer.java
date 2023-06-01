package com.example.techStore.objectMapping;

import com.example.techStore.dto.ComputerDTO;
import com.example.techStore.dto.HardDiscDeviceDTO;
import com.example.techStore.dto.LaptopDTO;
import com.example.techStore.dto.MonitorDTO;
import com.example.techStore.dto.Product;
import com.example.techStore.dto.ProductRequest;
import com.example.techStore.enums.ProductType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ProductRequestDeserializer extends StdDeserializer<ProductRequest> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ProductRequestDeserializer() {
        this(null);
    }

    public ProductRequestDeserializer(final Class<?> vc) {
        super(vc);
    }

    @Override
    public ProductRequest deserialize(
        final JsonParser jsonParser,
        final DeserializationContext deserializationContext
    ) throws IOException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        final var type = ProductType.valueOf(node.get("type").asText());
        final var productJson = node.get("product").toString();

        final Product product;

        switch (type) {
            case COMPUTER:         product = objectMapper.readValue(productJson, ComputerDTO.class); break;
            case LAPTOP:           product = objectMapper.readValue(productJson, LaptopDTO.class); break;
            case HARD_DISK_DEVICE: product = objectMapper.readValue(productJson, HardDiscDeviceDTO.class); break;
            case MONITOR :         product = objectMapper.readValue(productJson, MonitorDTO.class); break;
            default : throw new IllegalStateException("product type not implemented yet");
        }

        return ProductRequest.builder()
            .product(product)
            .type(type)
            .build();
    }
}
