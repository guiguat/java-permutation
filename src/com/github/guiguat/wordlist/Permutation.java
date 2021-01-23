package com.github.guiguat.wordlist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Permutation{
    private String prefix = "";
    private String str = "";
    private static Permutation instance;
    private ExecutorService executor;
    private Permutation(){}
    public static Permutation of(String str){
        if(instance == null){
            instance = new Permutation();
        }
        instance.str = str;
        return instance;
    }
    public Permutation withPrefix(String prefix){
        this.prefix = prefix;
        return this;
    }
    public void build(){
        permute(this.prefix, this.str);
    }
    private void permute(String prefix, String str){
        int length = str.length();
        if (length == 0) System.out.print(prefix);
        else {
            for (int i = 0; i < length; i++)
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, length));
        }
    }

    private void permuteParallel(String prefix, String str){
        int length = str.length();
        if (length == 0) System.out.print(prefix);
        else {
            for (int i = 0; i < length; i++) {
                int finalI = i;
                this.executor.submit(() -> permute(prefix + str.charAt(finalI), str.substring(0, finalI) + str.substring(finalI +1, length)));
            }
        }
    }


    public void buildParallel(int nThreads) {
        executor = Executors.newFixedThreadPool(nThreads);
        permuteParallel(this.prefix, this.str);
        this.executor.shutdown();
        while(true){
            if(this.executor.isTerminated()) return;
        }
    }
}