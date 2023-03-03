package com.superheroes.model.entity;


import com.superheroes.model.dto.SuperHeroeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * {@link SuperHeroe} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "super-heroes")
public class SuperHeroe implements Serializable {

    /**
     * superheroe id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * superheroe name
     */
    @Column
    private String name;
}
