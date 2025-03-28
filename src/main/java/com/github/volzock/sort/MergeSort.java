package com.github.volzock.sort;

import com.github.volzock.models.SortTaskInformation;
import lombok.NonNull;

public class MergeSort {
    private MergeSort(){}

    public static void sort(@NonNull int[] arr) {
        final var left = new SortTaskInformation(0, arr.length);
        final var right = new SortTaskInformation(arr.length, 0);

        sort(arr, left, right);
    }

    public static void sort(@NonNull int[] arr,
                            @NonNull final SortTaskInformation left,
                            @NonNull final SortTaskInformation right) {
        if (left.length() > 1) {
            final var leftHalflength = left.length() / 2;
            final var leftLeft = new SortTaskInformation(left.startPosition(), leftHalflength);
            final var leftRight = new SortTaskInformation(left.startPosition() + leftHalflength,
                    left.length() - leftHalflength);
            sort(arr, leftLeft, leftRight);
        }

        if (right.length() > 1) {
            final var rightHalflength = right.length() / 2;
            final var rightLeft = new SortTaskInformation(right.startPosition(), rightHalflength);
            final var rightRight = new SortTaskInformation(right.startPosition() + rightHalflength,
                    right.length() - rightHalflength);
            sort(arr, rightLeft, rightRight);
        }

        merge(arr, left, right);
    }

    public static void merge(@NonNull int[] arr,
                             @NonNull final SortTaskInformation left,
                             @NonNull final SortTaskInformation right) {
        int[] leftArr = new int[left.length()];
        int[] rightArr = new int[right.length()];

        if (left.length() >= 1) {
            System.arraycopy(arr, left.startPosition(), leftArr, 0, left.length());
        }
        if (right.length() >= 1) {
            System.arraycopy(arr, right.startPosition(), rightArr, 0, right.length());
        }

        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < left.length() && rightIndex < right.length()) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[left.startPosition() + leftIndex + rightIndex] = leftArr[leftIndex];
                ++leftIndex;
            } else {
                arr[left.startPosition() + leftIndex + rightIndex] = rightArr[rightIndex];
                ++rightIndex;
            }
        }

        while (leftIndex < left.length()) {
            arr[left.startPosition() + leftIndex + rightIndex] = leftArr[leftIndex];
            ++leftIndex;
        }

        while (rightIndex < right.length()) {
            arr[left.startPosition() + leftIndex + rightIndex] = rightArr[rightIndex];
            ++rightIndex;
        }
    }
}
