package com.github.guiguat.wordlist;

public class Permutation{
    private String prefix = "";
    private String str = "";
    private static Permutation instance;
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
        if (length == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < length; i++)
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, length));
        }
    }
}