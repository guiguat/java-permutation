package com.github.guiguat.wordlist;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Permutation.of("ABC").build();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.printf("\nExecuted in: %.2f seconds\n",duration/1e9);

        long startTimeParallel = System.nanoTime();
        Permutation.of("ABC").buildParallel(4);
        long endTimeParallel = System.nanoTime();
        long durationParallel = (endTimeParallel - startTimeParallel);
        System.out.printf("\nExecuted in: %.2f seconds in parallel\n",durationParallel/1e9);
    }
}
