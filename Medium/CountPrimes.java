package BitManipulation.Medium;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 1)
            return 0;

        boolean[] notPrime = new boolean[n];
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                //This removes repetiton
                if ((long)i * i < n)          // avoid overflow
                for (int j = i * i; j < n; j += i)
                    notPrime[j] = true;
            }
        }
        return count;
    }
}