package BitManipulation.Medium;

// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int x = start ^ goal;         // XOR → where bits differ
//         return Integer.bitCount(x);   // count differing bits
//     }
// }

public class MinBitsFlip {
    public int minBitsFlip(int start, int goal) {
        int x = start ^ goal; 
        int count = 0; 
        while(x > 0){ 
            count += x & 1; 
            x >>= 1; 
        } 
        return count;
    }
}


/*
 * Example: start = 10, goal = 7

👉 First, write them in binary (assuming 4 bits for clarity):

start = 10 → (1010)

goal = 7 → (0111)

Step 1: XOR
int x = start ^ goal;


XOR compares bits: 1 if different, 0 if same.

1010 ^ 0111 = 1101 (which is 13 in decimal).
So x = 13.

Step 2: Count set bits in x
int count = 0;
while (x > 0) {
    count += x & 1;
    x >>= 1;
}

Iteration 1:

x = 13 (1101)

x & 1 = 1 → add 1 → count = 1

Right shift: x = 1101 >> 1 = 110 (6)

Iteration 2:

x = 6 (110)

x & 1 = 0 → add 0 → count = 1

Right shift: x = 110 >> 1 = 11 (3)

Iteration 3:

x = 3 (11)

x & 1 = 1 → add 1 → count = 2

Right shift: x = 11 >> 1 = 1

Iteration 4:

x = 1 (1)

x & 1 = 1 → add 1 → count = 3

Right shift: x = 1 >> 1 = 0

Loop ends.

Step 3: Return
return count;   // 3

✅ Final Answer

It takes 3 bit flips to convert 10 (1010) into 7 (0111).
 */