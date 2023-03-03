package com.superheroes.repository;

import com.superheroes.model.entity.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@link SuperHeroeRepository} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Long> {
    /**
     * find By Name Containing Ignore Case
     */
    List<SuperHeroe> findByNameContainingIgnoreCase(String paramName);
}
