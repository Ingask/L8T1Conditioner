package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionerTest {

    @Test
    public void shouldGetAndSet(){
        Conditioner conditioner = new Conditioner();
        String expected = "Валли";
        assertNull(conditioner.getName());
        conditioner.setName(expected);
        assertEquals(expected, conditioner.getName());
    }

    @Test
    public void checkTemperature(){
        Conditioner conditioner = new Conditioner();
        assertEquals(0, conditioner.getCurrentTemperature());
        conditioner.setCurrentTemperature(20);
        assertEquals(20, conditioner.getCurrentTemperature());

    }

    @Test
public void increaseCurrentTemperature(){
    Conditioner conditioner = new Conditioner();
    conditioner.setCurrentTemperature(12);
    conditioner.increaseCurrentTemperature();
    assertEquals(conditioner.getMaxTemperature(), conditioner.getCurrentTemperature());
    }

    @Test
    public void decreaseCurrentTemperature(){
        Conditioner conditioner = new Conditioner();
        conditioner.setCurrentTemperature(21);
        conditioner.setMinTemperature(7);
        conditioner.decreaseCurrentTemperature();
        assertEquals(conditioner.getMinTemperature(), conditioner.getCurrentTemperature());
    }
}

