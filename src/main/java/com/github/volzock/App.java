package com.github.volzock;

import com.github.volzock.models.TimeForTwoTasksModel;
import com.github.volzock.sort.MergeSort;

import java.util.List;

import static com.github.volzock.utils.Utils.randomArray;
import static com.github.volzock.utils.Utils.timeToWorkInMillis;

public class App {
    public static void main(String[] args) {
        final var sizes = List.of(1_000_000, 10_000_000, 100_000_000);

        for (var size : sizes) {
            System.out.println(getTimeForTwoTasksModel(size));
        }
    }

    public static TimeForTwoTasksModel getTimeForTwoTasksModel(int arraySize) {
        final var arrayForMultiple = randomArray(arraySize);
        int[] arrayForSingle = new int[arraySize];
        System.arraycopy(arrayForMultiple, 0, arrayForSingle, 0, arrayForMultiple.length);

        final var singleCpuTime = timeToWorkInMillis(() -> MergeSort.sort(arrayForSingle));
        final var multiCpuTime = timeToWorkInMillis(() -> MergeSort.sort(arrayForMultiple));

        return TimeForTwoTasksModel.builder()
                .singleCpuTime(singleCpuTime)
                .multiCpuTime(multiCpuTime)
                .arraySize(arraySize)
                .build();
    }
}
