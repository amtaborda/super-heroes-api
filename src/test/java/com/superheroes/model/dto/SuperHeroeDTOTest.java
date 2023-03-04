package com.superheroes.model.dto;

import org.junit.jupiter.api.Test;

import static com.superheroes.util.TestUtil.dto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SuperHeroeDTOTest {

    @Test
    public void testDtoOK() {
        SuperHeroeDTO superHeroeDTO = new SuperHeroeDTO();
        superHeroeDTO.setId(1L);
        superHeroeDTO.setName("SpiderMan");

        assertNotNull(new SuperHeroeDTO());
        assertNotNull(superHeroeDTO.toString());
        assertTrue(superHeroeDTO.canEqual(dto));
        assertNotNull(superHeroeDTO.hashCode());
        assertTrue(superHeroeDTO.equals(dto));
        assertNotNull(superHeroeDTO.toString());
        assertThat(superHeroeDTO.getId()).isEqualTo(1L);
        assertThat(superHeroeDTO.getName()).isEqualTo("SpiderMan");
    }
}