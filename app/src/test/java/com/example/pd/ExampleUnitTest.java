package com.example.pd;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.pd.Model.Doner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Ignore
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getJela(){
        String expected = "Dhaka";
        Doner doner = new Doner("Xenon", "Dhaka", "o+", "Tangail", "Male", 23);
        String actual = doner.getJela();
        assertEquals(expected,actual);
    }


    @Test
    public void getName(){
        String expected = "Xenon";
        Doner doner = new Doner("Xenon", "Dhaka", "o+", "Tangail", "Male", 23);
        String actual = doner.getName();
        assertEquals(expected,actual);
    }


    @Test
    public void getBg(){
        String expected = "o+";
        Doner doner = new Doner("Xenon", "Dhaka", "o+", "Tangail", "Male", 23);
        String actual = doner.getBg();
        assertEquals(expected,actual);
    }


    @Test
    public void getUpojela(){
        String expected = "Tangail";
        Doner doner = new Doner("Xenon", "Dhaka", "o+", "Tangail", "Male", 23);
        String actual = doner.getUpojela();
        assertEquals(expected,actual);
    }

    @Test
    public void getNumber(){
        int expected = 23;
        Doner doner = new Doner("Xenon", "Dhaka", "o+", "Tangail", "Male", 23);
        int actual = doner.getNumber();
        assertEquals(expected,actual);
    }

}