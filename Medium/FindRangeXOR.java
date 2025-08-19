package BitManipulation.Medium;

// class Solution {
//     private int xorTillN(int n) {
//         if (n % 4 == 0) return n;
//         if (n % 4 == 1) return 1;
//         if (n % 4 == 2) return n + 1;
//         return 0; // n % 4 == 3
//     }

//     public int findRangeXOR(int l, int r) {
//         return xorTillN(r) ^ xorTillN(l - 1);
//     }
// }

public class FindRangeXOR {
    public int findRangeXOR(int l, int r) {
        int result = 0;
        for(int i = l; i <= r; i++){
            result ^= i;
        }
        return result;
    }
}

/*
 * Check SS
 */