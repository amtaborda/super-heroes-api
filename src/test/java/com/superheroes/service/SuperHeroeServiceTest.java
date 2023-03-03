package com.superheroes.service;

import com.superheroes.exception.BusinessException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SuperHeroeServiceTest {

    @InjectMocks
    private SuperHeroeService superHeroeService;

    @Mock
    private SuperHeroeRepository superHeroeRepository;

    @Mock
    private SuperHeroeMapper superHeroeMapper;

    SuperHeroeDTO dto = SuperHeroeDTO.builder().id(1L).name("SpiderMan").build();

    SuperHeroe entity = SuperHeroe.builder().id(1L).name("SpiderMan").build();

    @Test
    void test_createSuperHeroeOK() throws BusinessException {
        when(superHeroeMapper.toEntity(Mockito.any())).thenReturn(entity);
        when(superHeroeRepository.save(Mockito.any())).thenReturn(entity);

        Long superHeroeId = superHeroeService.create(dto);
        assertNotNull(superHeroeId);
        assertThat(superHeroeId).isEqualTo(entity.getId());
    }
}