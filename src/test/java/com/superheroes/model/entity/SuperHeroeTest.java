package com.superheroes.model.entity;

import org.junit.jupiter.api.Test;

import static com.superheroes.util.TestUtil.dto;
import static com.superheroes.util.TestUtil.entity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SuperHeroeTest {
    @Test
    public void testEntityOK() {
        SuperHeroe superHeroe = new SuperHeroe();
        superHeroe.setId(1L);
        superHeroe.setName("SpiderMan");

        assertNotNull(new SuperHeroe());
        assertNotNull(superHeroe.toString());
        assertTrue(superHeroe.canEqual(entity));
        assertNotNull(superHeroe.hashCode());
        assertTrue(superHeroe.equals(entity));
        assertNotNull(superHeroe.toString());
        assertThat(superHeroe.getId()).isEqualTo(1L);
        assertThat(superHeroe.getName()).isEqualTo("SpiderMan");
    }
}