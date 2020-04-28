package com.company;

public class Main {

    public static void main(String[] args) {
	double x = Service.getSolution(-3, 5, 1e-10);
        System.out.println("X = " + x);
    }
}
