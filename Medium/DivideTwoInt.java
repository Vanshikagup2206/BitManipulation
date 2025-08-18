package BitManipulation.Medium;

public class DivideTwoInt {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long divid = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);

        int result = 0;
        for(int i = 31; i >= 0; i--){
            if((divid >> i) >= div){
                divid -= (div << i);
                result += (1 << i);
            }
        }
        return negative ? -result : result;
    }
}

/*
 * Initial Setup

dividend = 10, divisor = 3

Overflow check: not triggered

negative = (10 < 0) ^ (3 < 0) = false ^ false = false → result will be positive

divid = Math.abs((long)10) = 10

div = Math.abs((long)3) = 3

result = 0

🔁 Loop (i = 31 → 0)

i = 31 … 3
(divid >> i) = 10 / 2^i.
For i >= 3, this is ≤ 1, so never >= 3.
→ Skip, nothing happens.

i = 2
(divid >> 2) = 10 / 4 = 2 → 2 >= 3? ❌ No.
Nothing changes.

i = 1
(divid >> 1) = 10 / 2 = 5 → 5 >= 3? ✅ Yes.

Subtract: divid -= (div << 1) → 10 - (3 * 2) = 10 - 6 = 4

Update result: result += (1 << 1) → 0 + 2 = 2

i = 0
(divid >> 0) = 4 / 1 = 4 → 4 >= 3? ✅ Yes.

Subtract: divid -= (div << 0) → 4 - 3 = 1

Update result: result += (1 << 0) → 2 + 1 = 3

🔚 End of Loop

result = 3

divid = 1 (this is the remainder, ignored for quotient)

negative = false → return +3

✅ Final Answer = 3
Which matches integer division 10 ÷ 3 = 3 (fraction truncated).
 */