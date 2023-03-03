package com.superheroes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link BusinessException} class.
 *
 * @author ataborda
 * @version 0.0.1
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "error en request")
public class BusinessException extends SuperHeroeException {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = -2634207060501411224L;

    /**
     * Constructor for BusinessException.
     */
    public BusinessException() {
        super();
    }
}
