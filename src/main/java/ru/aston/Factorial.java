package ru.aston;

public class Factorial {
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        /* из-за того, что в int не получается вместить число с n > 12, решил кидать exception */
        if(n > 12) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
