package com.superheroes.controller;

import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.service.SuperHeroeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.superheroes.util.TestUtil.*;
import static com.superheroes.util.TestUtil.entity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SuperHeroeControllerTest {

    @Mock
    private SuperHeroeService superHeroeService;

    @InjectMocks
    private SuperHeroeController superHeroeController;

    @Test
    public void test_crearSuperHeroeOK() throws Exception {
        when(superHeroeService.create(dto)).thenReturn(dto);
        assertThat(superHeroeController.create(dto).getId()).isEqualTo(dto.getId());
    }

    @Test
    public void test_updateSuperHeroeOK() throws Exception {
        when(superHeroeService.update(dto.getId(), dto)).thenReturn(dto);

        SuperHeroeDTO response = superHeroeController.update(dto.getId(), dto);
        assertThat(response.getId()).isEqualTo(dto.getId());
        assertThat(response.getName()).isEqualToIgnoringCase(dto.getName());
    }

    @Test
    public void test_findAllSuperHeroeOK() throws Exception {
        when(superHeroeService.findAll()).thenReturn(dtoList);

        List<SuperHeroeDTO> response = superHeroeController.findAll();
        assertThat(response.get(0).getId()).isEqualTo(dto.getId());
        assertThat(response.get(0).getName()).isEqualToIgnoringCase(dto.getName());
    }

    @Test
    public void test_findByIdSuperHeroeOK() throws Exception {
        when(superHeroeService.findById(dto.getId())).thenReturn(dto);

        SuperHeroeDTO response = superHeroeController.findById(dto.getId());
        assertThat(response.getId()).isEqualTo(dto.getId());
        assertThat(response.getName()).isEqualToIgnoringCase(dto.getName());
    }

    @Test
    public void test_deleteByIdSuperHeroeOK() throws Exception {
        superHeroeController.delete(dto.getId());
        verify(superHeroeService, times(1)).deleteById(entity.getId());
    }

    @Test
    public void test_findByParamNameSuperHeroeOK() throws Exception {
        when(superHeroeService.findByParamName(any())).thenReturn(dtoList);

        List<SuperHeroeDTO> response = superHeroeController.findByParamName(paramName);
        assertThat(response.get(0).getId()).isEqualTo(dto.getId());
        assertThat(response.get(0).getName()).isEqualToIgnoringCase(dto.getName());
    }
}
