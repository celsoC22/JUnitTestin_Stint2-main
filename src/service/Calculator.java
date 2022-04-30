package service;

public class Calculator {
    public static int add(int... values){
        int sum = 0;
        for(int index = 0; index < values.length; index++){
            sum += values[index];
        }
        return sum;
    }

    public static double add(double... values){
        int sum = 0;
        for(int index = 0; index < values.length; index++){
            sum += values[index];
        }
        return sum;
    }
}