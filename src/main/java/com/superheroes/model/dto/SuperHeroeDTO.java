package com.superheroes.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link SuperHeroeDTO} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuperHeroeDTO {

    /**
     * superheroe id
     */
    private Long id;

    /**
     * superheroe name
     */
    @NotNull
    @NotBlank
    private String name;
}
