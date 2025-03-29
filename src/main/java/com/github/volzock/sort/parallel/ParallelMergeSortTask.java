package com.github.volzock.sort.parallel;

import com.github.volzock.models.SortTaskInformation;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

import static com.github.volzock.sort.MergeSort.merge;
import static com.github.volzock.sort.MergeSort.sort;

@RequiredArgsConstructor
public class ParallelMergeSortTask extends RecursiveAction {
    private static final int THRESHOLD = 100000;

    private final int[] array;
    private final SortTaskInformation left;
    private final SortTaskInformation right;

    protected void compute() {
        if (left.length() + right.length() <= THRESHOLD) {
            sort(array, left, right);
            return;
        }

        final var tasksList = new ArrayList<ParallelMergeSortTask>();

        if (left.length() > 1) {
            final var leftHalflength = left.length() / 2;
            final var leftLeft = new SortTaskInformation(left.startPosition(), leftHalflength);
            final var leftRight = new SortTaskInformation(left.startPosition() + leftHalflength,
                    left.length() - leftHalflength);

            final var leftTask = new ParallelMergeSortTask(array, leftLeft, leftRight);
            tasksList.add(leftTask);
        }

        if (right.length() > 1) {
            final var rightHalflength = right.length() / 2;
            final var rightLeft = new SortTaskInformation(right.startPosition(), rightHalflength);
            final var rightRight = new SortTaskInformation(right.startPosition() + rightHalflength,
                    right.length() - rightHalflength);
            final var rightTask = new ParallelMergeSortTask(array, rightLeft, rightRight);
            tasksList.add(rightTask);
        }

        invokeAll(tasksList);
        merge(array, left, right);
    }
}
