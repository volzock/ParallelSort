package com.github.volzock;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.github.volzock.sort.MergeSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AppTest {

    @Test
    public void emptyArray() {
        int[] arr = {};
        int[] expected = {};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void oneSizeArray() {
        int[] arr = {1};
        int[] expected = {1};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void SizeOfTwoArray() {
        int[] arr = {2, 1};
        int[] expected = {1, 2};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);

        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void SizeOfThreeArray() {
        int[] arr = {3, 2, 1};
        int[] expected = {1, 2, 3};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);

        arr = new int[]{2, 1, 3};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);

        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void SizeOfFiveArray() {
        int[] arr = {3, 5, 2, 1, 4};
        int[] expected = {1, 2, 3, 4, 5};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void SizeOfOneHundredArray() {
        int[] arr = randomArray(100);
        int[] expected = new int[100];
        System.arraycopy(arr, 0, expected, 0, arr.length);

        MergeSort.sort(arr);
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void SizeOfOneThousandArray() {
        int[] arr = randomArray(1000);
        int[] expected = new int[1000];
        System.arraycopy(arr, 0, expected, 0, arr.length);

        MergeSort.sort(arr);
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void SizeOfTenHundredArray() {
        int[] arr = randomArray(10000);
        int[] expected = new int[10000];
        System.arraycopy(arr, 0, expected, 0, arr.length);

        MergeSort.sort(arr);
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

    private int[] randomArray(int size) {
        final var random = new Random();
        random.setSeed(0);

        return IntStream.generate(() -> random.nextInt(100)).limit(size).toArray();
    }
}
