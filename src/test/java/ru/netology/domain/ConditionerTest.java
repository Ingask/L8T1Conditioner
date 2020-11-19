package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Temperature from 10',10,11",
                    "'Temperature from 0',0,1",
                    "'Temperature from 30',30,30",
                    "'Temperature from 15',15,16",
            }
    )

public void increaseCurrentTemperature(String name, int currentTemperature, int expected){
    Conditioner conditioner = new Conditioner();
    conditioner.setMaxTemperature(30);
    conditioner.setCurrentTemperature(currentTemperature);
    conditioner.increaseCurrentTemperature();
    int actual = conditioner.getCurrentTemperature();
    assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Temperature from 9',9,9",
                    "'Temperature from 10',10,9",
                    "'Temperature from 20',20,19",
            }
    )

    public void decreaseCurrentTemperature(String name, int currentTemperature, int expected){
        Conditioner conditioner = new Conditioner();
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.setMinTemperature(9);
        conditioner.decreaseCurrentTemperature();
        int actual = conditioner.getCurrentTemperature();
        assertEquals(expected, actual);
    }
}

