package ru.unn.agile.PrimeNumber.Model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PrimeNumberTest {

    @Test
    public void canCreateClassWithRange() {
        Integer left = 1;
        Integer right = 2;
        PrimeNumber limitTest = new PrimeNumber(left, right);

        Integer leftOut = limitTest.getLeftLim();
        Integer rightOut = limitTest.getRightLim();

        assertEquals(left, leftOut);
        assertEquals(right, rightOut);
    }

    @Test
    public void canFindSimpleOnePrimeSimpleSearch() {
        Integer left = 1;
        Integer right = 1;
        PrimeNumber searchOne = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(1);

        searchOne.findPrimeNumberFromRangeSimpleSearch();
        List<Integer> resPrime = searchOne.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindSimpleTwoPrimeSimpleSearch() {
        Integer left = 1;
        Integer right = 2;
        PrimeNumber searchTwo = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(1);
        prime.add(2);

        searchTwo.findPrimeNumberFromRangeSimpleSearch();
        List<Integer> resPrime = searchTwo.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindTwoPrimeComplexRangeSimpleSearch() {
        Integer left = 4;
        Integer right = 8;
        PrimeNumber searchOne = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(5);
        prime.add(7);

        searchOne.findPrimeNumberFromRangeSimpleSearch();
        List<Integer> resPrime = searchOne.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindWithSwapLimitRangeSimpleSearch() {
        Integer left = 11;
        Integer right = 7;
        PrimeNumber search = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(7);
        prime.add(11);

        search.findPrimeNumberFromRangeSimpleSearch();
        List<Integer> resPrime = search.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindWithLeftLimitNoNaturalNumSimpleSearch() {
        Integer left = -3;
        Integer right = 4;
        PrimeNumber search = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(1);
        prime.add(2);
        prime.add(3);

        search.findPrimeNumberFromRangeSimpleSearch();
        List<Integer> resPrime = search.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindWithLimitNoNaturalNumSimpleSearch() {
        Integer left = -3;
        Integer right = -10;
        PrimeNumber search = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();

        search.findPrimeNumberFromRangeSimpleSearch();
        List<Integer> resPrime = search.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindSimpleOnePrimeEratosthenes() {
        Integer left = 1;
        Integer right = 1;
        PrimeNumber searchOne = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(1);

        searchOne.findPrimeNumberFromRangeEratosthenes();
        List<Integer> resPrime = searchOne.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindSimpleTwoPrimeEratosthenes() {
        Integer left = 1;
        Integer right = 2;
        PrimeNumber searchTwo = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(1);
        prime.add(2);

        searchTwo.findPrimeNumberFromRangeEratosthenes();
        List<Integer> resPrime = searchTwo.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindTwoPrimeComplexRangeEratosthenes() {
        Integer left = 7;
        Integer right = 11;
        PrimeNumber searchOne = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(7);
        prime.add(11);

        searchOne.findPrimeNumberFromRangeEratosthenes();
        List<Integer> resPrime = searchOne.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindWithSwapLimitRangeEratosthenes() {
        Integer left = 5;
        Integer right = 3;
        PrimeNumber search = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(3);
        prime.add(5);

        search.findPrimeNumberFromRangeEratosthenes();
        List<Integer> resPrime = search.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindWithLeftLimitNoNaturalNumEratosthenes() {
        Integer left = -2;
        Integer right = 2;
        PrimeNumber search = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(1);
        prime.add(2);

        search.findPrimeNumberFromRangeEratosthenes();
        List<Integer> resPrime = search.getPrimeList();

        assertEquals(prime, resPrime);
    }

    @Test
    public void canFindWithLimitNoNaturalNumEratosthenes() {
        Integer left = -5;
        Integer right = -8;
        PrimeNumber search = new PrimeNumber(left, right);
        List<Integer> prime = new ArrayList<Integer>();

        search.findPrimeNumberFromRangeEratosthenes();
        List<Integer> resPrime = search.getPrimeList();

        assertEquals(prime, resPrime);
    }
}
