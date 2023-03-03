package com.superheroes.controller;

import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.service.SuperHeroeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SuperHeroeControllerTest {

    @Mock
    private SuperHeroeService superHeroeService;

    @InjectMocks
    private SuperHeroeController superHeroeController;

    SuperHeroeDTO request = SuperHeroeDTO.builder().id(1L).name("SpiderMan").build();

    @Test
    public void test_crearSuperHeroeOK() throws Exception {
        when(superHeroeService.create(request)).thenReturn(request.getId());
        assertThat(superHeroeController.create(request)).isEqualTo(request.getId());
    }
}
