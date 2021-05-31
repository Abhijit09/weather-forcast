package com.sapient.demo.weatherforcast.service;

public class DSPractice {

    public static void main(String[] args) {

        int[] ar = new int[]{ 1,2,3,4,5,6,7,8,9,10 };

        System.out.println("Hello " + ar[9]);

        int[] copy = ar.clone();

        System.out.println(ar == copy);

        System.out.println(ar[0] == copy[0]);
    }
}