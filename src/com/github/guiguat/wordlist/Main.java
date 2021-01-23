package com.github.guiguat.wordlist;

public class Main {

    public static void main(String[] args) {
        String word = "ABCDE";

        long startTime = System.nanoTime();
        Permutation.of(word).build();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.printf("\nExecuted in: %.2f seconds\n",duration/1e9);

        long startTimeParallel = System.nanoTime();
        Permutation.of(word).buildParallel(4);
        long endTimeParallel = System.nanoTime();
        long durationParallel = (endTimeParallel - startTimeParallel);
        System.out.printf("\nExecuted in: %.2f seconds in parallel\n",durationParallel/1e9);
    }
}
