package com.superheroes.service;

import com.superheroes.exception.BusinessException;
import com.superheroes.exception.NoContentException;
import com.superheroes.exception.SuperHeroeException;
import com.superheroes.mapper.SuperHeroeMapper;
import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.model.entity.SuperHeroe;
import com.superheroes.repository.SuperHeroeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SuperHeroeServiceTest {

    @InjectMocks
    private SuperHeroeService superHeroeService;

    @Mock
    private SuperHeroeRepository superHeroeRepository;

    @Mock
    private SuperHeroeMapper superHeroeMapper;

    private SuperHeroeDTO dto = SuperHeroeDTO.builder().id(1L).name("SpiderMan").build();

    private SuperHeroe entity = SuperHeroe.builder().id(1L).name("SpiderMan").build();

    private SuperHeroe emptyEntity = SuperHeroe.builder().build();

    private List<SuperHeroeDTO> dtoList = Collections.singletonList(dto);

    private List<SuperHeroe> entityList = Collections.singletonList(entity);

    private String paramName = "man";

    @Test
    void test_createSuperHeroeOK() throws BusinessException {
        when(superHeroeMapper.toEntity(Mockito.any())).thenReturn(entity);
        when(superHeroeMapper.toDto(Mockito.any())).thenReturn(dto);
        when(superHeroeRepository.save(Mockito.any())).thenReturn(entity);

        SuperHeroeDTO createdDto = superHeroeService.create(dto);
        assertNotNull(createdDto);
        assertThat(createdDto.getId()).isEqualTo(entity.getId());
    }

    @Test
    void test_createSuperHeroeFail() {
        given(superHeroeMapper.toEntity(null)).willAnswer(invocation -> {
            throw new Exception();
        });
        try {
            superHeroeService.create(null);
            fail();
        } catch (BusinessException ex) {
            assertTrue(ex instanceof BusinessException);
        }
    }

    @Test
    void test_updateSuperHeroeOK() throws SuperHeroeException {
        when(superHeroeMapper.toEntity(Mockito.any())).thenReturn(entity);
        when(superHeroeMapper.toDto(Mockito.any())).thenReturn(dto);
        when(superHeroeRepository.save(Mockito.any())).thenReturn(entity);
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.of(entity));

        SuperHeroeDTO createdDto = superHeroeService.update(dto.getId(), dto);
        assertNotNull(createdDto);
        assertThat(createdDto.getId()).isEqualTo(entity.getId());
    }

    @Test
    void test_updateSuperHeroeNotFoundFail() {
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        try {
            superHeroeService.update(dto.getId(), dto);
            fail();
        } catch (SuperHeroeException ex) {
            assertTrue(ex instanceof NoContentException);
        }
    }

    @Test
    void test_updateSuperHeroeFail() {
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.of(emptyEntity));
        try {
            superHeroeService.update(dto.getId(), null);
            fail();
        } catch (SuperHeroeException ex) {
            assertTrue(ex instanceof SuperHeroeException);
        }
    }

    @Test
    void test_findAllSuperHeroeOK() throws SuperHeroeException {
        when(superHeroeMapper.toDtoList(Mockito.any())).thenReturn(dtoList);
        when(superHeroeRepository.findAll()).thenReturn(entityList);

        List<SuperHeroeDTO> superHeroes = superHeroeService.findAll();
        assertNotNull(superHeroes);
        assertThat(superHeroes.get(0).getId()).isEqualTo(entity.getId());
    }

    @Test
    void test_findAllSuperHeroeNotFoundFail() {
        when(superHeroeRepository.findAll()).thenReturn(null);
        try {
            superHeroeService.findAll();
            fail();
        } catch (SuperHeroeException ex) {
            assertTrue(ex instanceof NoContentException);
        }
    }

    @Test
    void test_findByIdSuperHeroeOK() throws SuperHeroeException {
        when(superHeroeMapper.toDto(Mockito.any())).thenReturn(dto);
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.of(entity));

        SuperHeroeDTO superHeroe = superHeroeService.findById(dto.getId());
        assertNotNull(superHeroe);
        assertThat(superHeroe.getId()).isEqualTo(entity.getId());
    }

    @Test
    void test_findByIdSuperHeroeNotFoundFail() {
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        try {
            superHeroeService.findById(dto.getId());
            fail();
        } catch (SuperHeroeException ex) {
            assertTrue(ex instanceof NoContentException);
        }
    }

    @Test
    void test_deleteByIdSuperHeroeOK() throws SuperHeroeException {
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.of(entity));

        superHeroeService.deleteById(dto.getId());
        verify(superHeroeRepository, times(1)).findById(dto.getId());
        verify(superHeroeRepository, times(1)).deleteById(entity.getId());
    }

    @Test
    void test_deleteByIdSuperHeroeNotFoundFail() {
        when(superHeroeRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        try {
            superHeroeService.deleteById(dto.getId());
            fail();
        } catch (SuperHeroeException ex) {
            assertTrue(ex instanceof NoContentException);
        }
    }

    @Test
    void test_findByParamNameSuperHeroeOK() throws SuperHeroeException {
        when(superHeroeMapper.toDtoList(Mockito.any())).thenReturn(dtoList);
        when(superHeroeRepository.findByNameContainingIgnoreCase(Mockito.any()))
                .thenReturn(entityList);

        List<SuperHeroeDTO> superHeroes = superHeroeService.findByParamName(paramName);
        assertNotNull(superHeroes);
        assertThat(superHeroes.get(0).getName().toLowerCase()).contains(paramName);
    }

    @Test
    void test_findByParamNameSuperHeroeNotFoundFail() {
        when(superHeroeRepository.findByNameContainingIgnoreCase(Mockito.any()))
                .thenReturn(null);
        try {
            superHeroeService.findByParamName(paramName);
            fail();
        } catch (SuperHeroeException ex) {
            assertTrue(ex instanceof NoContentException);
        }
    }
}