package com.github.guiguat.wordlist;

public class Main {

    public static void main(String[] args) {
        long startTimeParallel = System.nanoTime();
        Permutation.of("ABC").buildParallel(4);
        long endTimeParallel = System.nanoTime();
        long durationParallel = (endTimeParallel - startTimeParallel);
        System.out.printf("Executed in: %.2f seconds%n",durationParallel/1e9);
    }
}
