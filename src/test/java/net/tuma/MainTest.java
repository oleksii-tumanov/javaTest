package net.tuma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    int[] smallArray;
    int[] smallArray2;
    int[] largeArray;
    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
        smallArray = new int[]{2, 1};
        largeArray = IntStream.concat(IntStream.range(800, 10000000), IntStream.range(0, 800)).toArray();
    }

    @Test
    void findElemNull() {
        assertEquals(-1, main.findElem(null, 2));
    }

    @Test
    void findElemNotFound() {
        assertEquals(-1, main.findElem(smallArray, -1));
        assertEquals(-1, main.findElem(smallArray, 0));
        assertEquals(-1, main.findElem(smallArray, 10));
    }

    @Test
    void findElem() {
        assertEquals(0, main.findElem(new int[]{1}, 1));

        assertEquals(1, main.findElem(smallArray, 1));
        assertEquals(0, main.findElem(smallArray, 2));

        assertEquals(largeArray.length - 800 + 1, main.findElem(largeArray, 1));
        assertEquals(0, main.findElem(largeArray, 800));
        assertEquals(1, main.findElem(largeArray, 801));
    }
}