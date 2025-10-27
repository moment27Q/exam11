package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.tecsup.petclinic.dtos.TypeDTO;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Type;
import com.tecsup.petclinic.exceptions.TypeNotFoundException;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
public class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @Test
    public void testUpdateType() {

        TypeDTO typeDTO = TypeDTO.builder()
                .name("cat")
                .description("Small domestic animal")
                .active(true)
                .sizeCategory("small")
                .averageLifespan(15)
                .careLevel("low")
                .build();

        TypeDTO createdType = this.typeService.create(typeDTO);

        String UPDATED_NAME = "big cat";
        String UPDATED_DESCRIPTION = "Large feline";
        Boolean UPDATED_ACTIVE = false;
        String UPDATED_SIZE_CATEGORY = "medium";
        Integer UPDATED_AVERAGE_LIFESPAN = 20;
        String UPDATED_CARE_LEVEL = "high";

        createdType.setName(UPDATED_NAME);
        createdType.setDescription(UPDATED_DESCRIPTION);
        createdType.setActive(UPDATED_ACTIVE);
        createdType.setSizeCategory(UPDATED_SIZE_CATEGORY);
        createdType.setAverageLifespan(UPDATED_AVERAGE_LIFESPAN);
        createdType.setCareLevel(UPDATED_CARE_LEVEL);

        TypeDTO updatedType = this.typeService.update(createdType);

        assertEquals(UPDATED_NAME, updatedType.getName());
        assertEquals(UPDATED_DESCRIPTION, updatedType.getDescription());
        assertEquals(UPDATED_ACTIVE, updatedType.getActive());
        assertEquals(UPDATED_SIZE_CATEGORY, updatedType.getSizeCategory());
        assertEquals(UPDATED_AVERAGE_LIFESPAN, updatedType.getAverageLifespan());
        assertEquals(UPDATED_CARE_LEVEL, updatedType.getCareLevel());

        System.out.println("✓ Prueba actualizar tipo exitosa");
    }

    }

