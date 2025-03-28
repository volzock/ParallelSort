package com.github.volzock.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@FieldDefaults(level = PRIVATE)
public class TimeForTwoTasksModel {
    long multiCpuTime;
    long singleCpuTime;
    long arraySize;

    @Override
    public String toString() {
        return String.format("Array sizez - %d, single-thread sort - %d, multi-threading sort - %d",
                arraySize,
                multiCpuTime,
                singleCpuTime);
    }
}
