package com.github.volzock.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@FieldDefaults(level = PRIVATE)
public class TimeForTwoTasksModel {
    long standardParallelCpuTime;
    long multiCpuTime;
    long singleCpuTime;
    long arraySize;

    @Override
    public String toString() {
        return String.format("Array sizes - %d, single-thread sort - %d, my multi-threading sort - %d," +
                        " standard-parallel sort - %d",
                arraySize,
                singleCpuTime,
                multiCpuTime,
                standardParallelCpuTime);
    }
}
