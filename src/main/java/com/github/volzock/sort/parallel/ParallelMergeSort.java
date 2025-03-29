package com.github.volzock.sort.parallel;

import com.github.volzock.models.SortTaskInformation;
import lombok.NonNull;

import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {

    private ParallelMergeSort() {}

    public static void sort(@NonNull int[] arr) {
        final var left = new SortTaskInformation(0, arr.length);
        final var right = new SortTaskInformation(arr.length, 0);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        try {
            pool.invoke(new ParallelMergeSortTask(arr, left, right));
        } finally {
            pool.shutdown();
        }
    }
}
