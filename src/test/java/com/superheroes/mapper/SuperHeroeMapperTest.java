package com.superheroes.mapper;

import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.model.entity.SuperHeroe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.superheroes.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class SuperHeroeMapperTest {

    private SuperHeroeMapper mapper = SuperHeroeMapper.INSTANCE;

    @Test
    public void toDtoTest() {
        SuperHeroeDTO response = mapper.toDto(entity);

        assertNotNull(response);
        assertEquals(response.getId(), entity.getId());
        assertEquals(response.getName(), entity.getName());
    }

    @Test
    public void toEntityTest() {
        SuperHeroe response = mapper.toEntity(dto);

        assertNotNull(response);
        assertEquals(response.getId(), dto.getId());
        assertEquals(response.getName(), dto.getName());
    }

    @Test
    public void toDtoListTest() {
        List<SuperHeroeDTO> response = mapper.toDtoList(entityList);

        assertNotNull(response);
        assertEquals(response.get(0).getId(), entityList.get(0).getId());
        assertEquals(response.get(0).getName(), entityList.get(0).getName());
    }

    @Test
    public void toDtoTestNull() {
        SuperHeroeDTO response = mapper.toDto(null);
        assertNull(response);
    }

    @Test
    public void toEntityTestNull() {
        SuperHeroe response = mapper.toEntity(null);
        assertNull(response);
    }

    @Test
    public void toDtoListTestNull() {
        List<SuperHeroeDTO> response = mapper.toDtoList(null);
        assertNull(response);
    }
}