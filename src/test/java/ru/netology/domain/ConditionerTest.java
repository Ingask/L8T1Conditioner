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



    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Temperature from min',30,9,10,9",
                    "'Temperature from max',30,30,30,9",
                    "'Temperature from 15',30,15,16,9",
            }
    )

public void increaseCurrentTemperature(String name, int max, int currentTemp, int expected, int min){
    Conditioner conditioner = new Conditioner();
    conditioner.setMaxTemperature(max);
    conditioner.setMinTemperature(min);
    conditioner.setCurrentTemperature(currentTemp);
    conditioner.increaseCurrentTemperature();
    int actual = conditioner.getCurrentTemperature();
    assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Temperature from min',9,9,9,30",
                    "'Temperature from 15',9,15,14,30",
                    "'Temperature from max',9,30,29,30",
            }
    )

    public void decreaseCurrentTemperature(String name, int min, int currentTemp, int expected, int max){
        Conditioner conditioner = new Conditioner();
        conditioner.setMinTemperature(min);
        conditioner.setMaxTemperature(max);
        conditioner.setCurrentTemperature(currentTemp);
        conditioner.decreaseCurrentTemperature();
        int actual = conditioner.getCurrentTemperature();
        assertEquals(expected, actual);
    }
}

