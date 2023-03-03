package com.superheroes.service;

import com.superheroes.exception.BusinessException;
import com.superheroes.exception.NoContentException;
import com.superheroes.exception.SuperHeroeException;
import com.superheroes.mapper.SuperHeroeMapper;
import com.superheroes.model.dto.SuperHeroeDTO;
import com.superheroes.model.entity.SuperHeroe;
import com.superheroes.repository.SuperHeroeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * {@link SuperHeroeService} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@Service
public class SuperHeroeService {

    Logger logger = LoggerFactory.getLogger(SuperHeroeService.class);

    /**
     * repository
     */
    @Autowired
    private SuperHeroeRepository repository;

    /**
     * mapper
     */
    @Autowired
    private SuperHeroeMapper mapper;

    /**
     * find all superheroes
     *
     * @return a {@link  List<SuperHeroeDTO>} superheroes list
     * @throws {@link NoContentException}
     */
    public List<SuperHeroeDTO> findAll() throws NoContentException {
        List<SuperHeroe> entityList = repository.findAll();
        if (CollectionUtils.isEmpty(entityList)) {
            logger.error("Superheroes records not found...");
            throw new NoContentException();
        }
        return mapper.toDtoList(repository.findAll());
    }

    /**
     * find by id superheroe
     *
     * @param id superheroes id
     * @return a {@link  SuperHeroeDTO} response object
     * @throws {@link SuperHeroeException}
     */
    public SuperHeroeDTO findById(Long id) throws NoContentException {
        if (repository.findById(id).isEmpty()) {
            logger.error("Superheroes record with id = " + id + " not found...");
            throw new NoContentException();
        }
        return mapper.toDto(repository.findById(id).get());
    }

    /**
     * create a superheroe
     *
     * @param superHeroeDTO superheroes info
     * @return a {@link  Long} id object
     * @throws {@link SuperHeroeException}
     */
    public Long create(SuperHeroeDTO superHeroeDTO) throws BusinessException {
        try {
            SuperHeroe superHeroe = repository.save(mapper.toEntity(superHeroeDTO));
            logger.info("Superheroes record has been saved...");
            return superHeroe.getId();
        } catch (Exception exception) {
            logger.error("Error trying save superheroe record");
            throw new BusinessException();
        }
    }

    /**
     * create a superheroe
     *
     * @param id            id superheroe
     * @param superHeroeDTO superheroes info
     * @throws {@link SuperHeroeException}
     */
    public void update(Long id, SuperHeroeDTO superHeroeDTO) throws SuperHeroeException {
        if (repository.findById(id).isEmpty()) {
            logger.error("Superheroes record with id = " + id + " not found...");
            throw new NoContentException();
        }
        try {
            superHeroeDTO.setId(id);
            repository.save(mapper.toEntity(superHeroeDTO));
            logger.info("Superheroes record has been updated...");
        } catch (Exception exception) {
            logger.error("Error trying update superheroe record");
            throw new BusinessException();
        }
    }

    /**
     * delete a superheroe by id
     *
     * @param id superheroes id
     * @throws {@link SuperHeroeException}
     */
    public void deleteById(Long id) throws SuperHeroeException {
        if (repository.findById(id).isEmpty()) {
            logger.error("Superheroes record with id = " + id + " not found...");
            throw new NoContentException();
        }
        try {
            repository.deleteById(id);
        } catch (Exception exception) {
            logger.error("Error trying delete superheroe record");
            throw new BusinessException();
        }
    }

    /**
     * find all superheroes by param name
     *
     * @param paramName param name
     * @return a {@link  List<SuperHeroeDTO>} superheroes list
     * @throws {@link NoContentException}
     */
    public List<SuperHeroeDTO> findByParamName(String paramName) throws SuperHeroeException {
        List<SuperHeroe> entityList = repository.findByNameContainingIgnoreCase(paramName);
        if (CollectionUtils.isEmpty(entityList)) {
            logger.error("Superheroes records not found...");
            throw new NoContentException();
        }
        return mapper.toDtoList(repository.findAll());
    }
}
