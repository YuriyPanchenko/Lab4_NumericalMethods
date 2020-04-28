package com.company;

public class Service {
    public static double getF(double x){
        return (Math.pow(x, 3) - 10 - Math.sqrt(x-2));
    }
    public static double getdF(double x){
        return (3*x*x - 1/(2*Math.sqrt(x-2)));
    }
    public static double getddF(double x){
        return (6*x + 1/(4*Math.pow(x-2, 3/2)));
    }

    public static double getSolution(double a, double b, double e){
        if(a > b){
            double t = b;
            b = a;
            a = t;
        }
        if(b < 2){
            System.out.println("We can't calculate because sqrt(x-2) must be bigger than zero");
            return -1;
        }
        if(a < 2){
            a = 2;
        }
        if(Service.getF(a)*Service.getF(b) > 0){
            System.out.println("Solution doesn't exist in this interval");
            return -1;
        }
        double currentSolution;
        double tmp;
        int i = 0;
        if(getF(a)*getddF(a) > 0) currentSolution = a;
        else currentSolution = b;
        tmp = currentSolution - getF(currentSolution)/getdF(currentSolution);
        do{
            currentSolution = tmp;
            tmp = currentSolution - getF(currentSolution)/getdF(currentSolution);
            System.out.println("x[n]= " + currentSolution + ", x[n+1]= " + tmp + ", iteration number " + i + ";");
            i++;
        }while (Math.abs(tmp - currentSolution) > e);

        return tmp;

    }
}
