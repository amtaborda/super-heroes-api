package com.superheroes;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

class SuperheroesApplicationTest {

    @Test
    void testApplication() {
        SuperheroesApplication.main(new String[]{
                "--spring.main.web-environment=false",
        });
    }

    @Test
    public void testConstructorIsPublic() {
        try {
            Constructor<SuperheroesApplication> constructor = SuperheroesApplication.class.getDeclaredConstructor();
            constructor.newInstance();
            assertFalse(Modifier.isPrivate(constructor.getModifiers()));
        } catch (NoSuchMethodException ex) {
            fail("NoSuchMethodException: " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            fail("IllegalAccessException: " + ex.getMessage());
        } catch (InstantiationException ex) {
            fail("InstantiationException: " + ex.getMessage());
        } catch (InvocationTargetException ex) {
            fail("InvocationTargetException: " + ex.getMessage());
        }
    }
}