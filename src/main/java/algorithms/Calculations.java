package algorithms;

public class Calculations {

    public static long factorial(int n) {
        if (n > 1) {
            return n * factorial(--n);
        } else {
            return 1;
        }
    }

    //Calculates tailing zeroes of n!
    public static long zeros(int n) {
        long kMax = Math.round((Math.log10(n) / Math.log10(5)));
        long res = 0;
        for (int k = 1; k <= kMax; ++k) {
            res += n / Math.pow(5, k);
        }
        return res;
    }

    public static int[] fibonacciSeq(int qty) {

        int res[] = new int[qty];

        int curr = 1;
        int prev = 0;
        for(int i = 0; i < qty; ++i) {
            res[i] = curr;
            curr = prev + res[i];
            prev = res[i];
        }

        return res;
    }

}
