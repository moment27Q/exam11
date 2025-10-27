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
    public void testCreateType() {
        String TYPE_NAME = "fish";
        String DESCRIPTION = "Aquatic animal";
        Boolean ACTIVE = true;
        String SIZE_CATEGORY = "small";
        Integer AVERAGE_LIFESPAN = 5;
        String CARE_LEVEL = "medium";

        TypeDTO typeDTO = TypeDTO.builder()
                .name(TYPE_NAME)
                .description(DESCRIPTION)
                .active(ACTIVE)
                .sizeCategory(SIZE_CATEGORY)
                .averageLifespan(AVERAGE_LIFESPAN)
                .careLevel(CARE_LEVEL)
                .build();

        TypeDTO newTypeDTO = this.typeService.create(typeDTO);

        System.out.println("Tipo creado: " + newTypeDTO.getName());

        assertNotNull(newTypeDTO.getId());
        assertEquals(TYPE_NAME, newTypeDTO.getName());
        assertEquals(DESCRIPTION, newTypeDTO.getDescription());
        assertEquals(ACTIVE, newTypeDTO.getActive());
        System.out.println(" Prueba crear tipo exitosa");
    }
    
 @Test
    public void testFindTypeById() {

        String TYPE_NAME = "cat";
        String DESCRIPTION = "Domestic feline";
        Boolean ACTIVE = true;
        String SIZE_CATEGORY = "medium";
        Integer AVERAGE_LIFESPAN = 12;
        String CARE_LEVEL = "easy";

        TypeDTO typeDTO = TypeDTO.builder()
                .name(TYPE_NAME)
                .description(DESCRIPTION)
                .active(ACTIVE)
                .sizeCategory(SIZE_CATEGORY)
                .averageLifespan(AVERAGE_LIFESPAN)
                .careLevel(CARE_LEVEL)
                .build();

        TypeDTO createdType = this.typeService.create(typeDTO);

        try {
            TypeDTO foundType = this.typeService.findById(createdType.getId());

            assertNotNull(foundType);
            assertEquals(createdType.getId(), foundType.getId());
            assertEquals(TYPE_NAME, foundType.getName());
            System.out.println("✓ Prueba buscar tipo exitosa");

        } catch (TypeNotFoundException e) {
            fail("El tipo no fue encontrado: " + e.getMessage());
        }
    }




}
