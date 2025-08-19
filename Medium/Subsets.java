package BitManipulation.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // Total subsets = 2^n
        int total = 1 << n;  // same as 2^n

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // Check if i-th bit is set in mask
                //If bit = 1 → include that element in subset.
                //If bit = 0 → skip that element.
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}

/*
 * We’ll take nums = [1, 2, 3] → indices = 0, 1, 2.

Mask (binary) = subset selector

Bit at index i = include/exclude nums[i]

We check using (mask & (1 << i))

Example 1: mask = 010 (decimal 2)
Index (i)	nums[i]	1 << i	mask & (1<<i)	Bit set?	Included?
0	1	001	010 & 001 = 000	No	❌
1	2	010	010 & 010 = 010	Yes	✅ (2)
2	3	100	010 & 100 = 000	No	❌

👉 Subset = [2]

Example 2: mask = 011 (decimal 3)
Index (i)	nums[i]	1 << i	mask & (1<<i)	Bit set?	Included?
0	1	001	011 & 001 = 001	Yes	✅ (1)
1	2	010	011 & 010 = 010	Yes	✅ (2)
2	3	100	011 & 100 = 000	No	❌

👉 Subset = [1, 2]

Example 3: mask = 101 (decimal 5)
Index (i)	nums[i]	1 << i	mask & (1<<i)	Bit set?	Included?
0	1	001	101 & 001 = 001	Yes	✅ (1)
1	2	010	101 & 010 = 000	No	❌
2	3	100	101 & 100 = 100	Yes	✅ (3)

👉 Subset = [1, 3]
 */