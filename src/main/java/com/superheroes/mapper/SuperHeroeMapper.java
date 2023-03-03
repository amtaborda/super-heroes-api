package com.superheroes.mapper;

import com.superheroes.controller.SuperHeroeController;
import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.model.entity.SuperHeroe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * {@link SuperHeroeMapper} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@Mapper(componentModel = "spring")
public interface SuperHeroeMapper {

    SuperHeroeMapper INSTANCE = Mappers.getMapper(SuperHeroeMapper.class);

    /**
     * Entity to DTO method
     */
    SuperHeroeDTO toDto(SuperHeroe entity);

    /**
     * DTO to Entity method
     */
    SuperHeroe toEntity(SuperHeroeDTO dto);

    List<SuperHeroeDTO> toDtoList(List<SuperHeroe> entityList);
}
