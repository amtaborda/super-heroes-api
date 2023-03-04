package com.superheroes.util;

import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.model.entity.SuperHeroe;

import java.util.Collections;
import java.util.List;

public class TestUtil {
    public static final SuperHeroeDTO dto = SuperHeroeDTO.builder().id(1L).name("SpiderMan").build();
    public static final SuperHeroe entity = SuperHeroe.builder().id(1L).name("SpiderMan").build();

    public static final SuperHeroe emptyEntity = SuperHeroe.builder().build();

    public static final List<SuperHeroeDTO> dtoList = Collections.singletonList(dto);

    public static final List<SuperHeroe> entityList = Collections.singletonList(entity);

    public static final String paramName = "man";
}
