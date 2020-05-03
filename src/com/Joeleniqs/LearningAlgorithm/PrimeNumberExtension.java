package com.Joeleniqs.LearningAlgorithm;

public  class PrimeNumberExtension {
    public static boolean isPrime(int n){
        if (n < 2) return false;
        for (int x = 2 ; x*x <= n ;x++){
            if(n%x == 0) return false;
        }
        return true;
    }
}
