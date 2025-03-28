package com.github.volzock.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;

public class Utils {
    private Utils() {}

    public static long timeToWorkInMillis(Action action) {
        Instant start = Instant.now();
        action.perform();
        Instant finish = Instant.now();
        return Duration.between(start, finish).toMillis();
    }

    public static int[] randomArray(long size) {
        final var random = new Random();
        random.setSeed(0);

        return IntStream.generate(() -> random.nextInt(100)).limit(size).toArray();
    }
}
