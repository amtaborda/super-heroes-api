package com.superheroes.controller;


import com.superheroes.annotation.LogExecutionTime;
import com.superheroes.exception.SuperHeroeException;
import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.service.SuperHeroeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@link SuperHeroeController} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@RestController
@RequestMapping("super-heroes")
public class SuperHeroeController {

    @Autowired
    private SuperHeroeService superHeroeService;

    @LogExecutionTime
    @GetMapping
    public List<SuperHeroeDTO> findAll() throws SuperHeroeException {
        return superHeroeService.findAll();
    }

    @LogExecutionTime
    @GetMapping(path = "/{id}")
    public SuperHeroeDTO findById(@PathVariable("id") Long id) throws SuperHeroeException {
        return superHeroeService.findById(id);
    }

    @LogExecutionTime
    @GetMapping(path = "/names/{paramName}")
    public List<SuperHeroeDTO> findByParamName(@PathVariable("paramName") String paramName) throws SuperHeroeException {
        return superHeroeService.findByParamName(paramName);
    }

    @LogExecutionTime
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuperHeroeDTO create(@RequestBody @Valid SuperHeroeDTO superHeroeDTO) throws SuperHeroeException {
        return superHeroeService.create(superHeroeDTO);
    }

    @LogExecutionTime
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuperHeroeDTO update(@PathVariable("id") Long id, @RequestBody SuperHeroeDTO superHeroeDTO)
            throws SuperHeroeException {
        return superHeroeService.update(id, superHeroeDTO);
    }

    @LogExecutionTime
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) throws SuperHeroeException {
        superHeroeService.deleteById(id);
    }
}
