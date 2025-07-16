package ec.edu.ups.poo;

import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {

    public long getFibonacci(long n){
        if(n <= 1){
            return n;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
    public long getFibonacciPD(long n){
        Map<Long, Long> caching = new HashMap<>();
        if(n <= 1){
            return n;
        }
        if (caching.containsKey(n)) {
            return caching.get(n);
        } else{
            long fib = getFibonacci(n);
            caching.put(n, fib);
        }
        return caching.get(n);
    }
    public long getFibonacciPDHelper(long n, Map<Long, Long> caching) {
        if (n <= 1) {
            return n;
        }
        if (caching.containsKey(n)) {
            return caching.get(n);
        } else {
            long fib = getFibonacciPDHelper(n - 1, caching) + getFibonacciPDHelper(n - 2, caching);
            caching.put(n, fib);
        }
        return caching.get(n);
    }
}
