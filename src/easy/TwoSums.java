package easy;

import java.util.HashSet;
import java.util.Set;

public class TwoSums {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> wastedSet = new HashSet<>();
        for (int x = 0 ; x<nums.length ; x++) {
            if (wastedSet.contains(x)) {
                continue;
            }
            for (int y = 0 ; y<nums.length ; y++) {
                if (x == y) {
                    continue;
                }
                if (nums[x] + nums[y] == target) {
                    return new int[]{x,y};
                }
            }
            wastedSet.add(x);
        }
        return new int[0];
    }
}
