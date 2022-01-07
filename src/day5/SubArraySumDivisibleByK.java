package day5;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {
    //leetcode
    public static int subarraysDivByK(int[] nums, int k) {
        int subArrayCount=0;
        Map<Integer, Integer> memo=new HashMap<>();
        memo.put(0,1);//(remainder, count)
        int n=nums.length;
        int remainder;
        int prefixSum=0;
        for (int right=0; right<n; right++){
            prefixSum+=nums[right];
            remainder=((prefixSum%k)+k)%k;
            if (memo.containsKey(remainder))
                subArrayCount+=memo.get(remainder);
            memo.put(remainder, memo.getOrDefault(remainder, 0)+1);
        }
        return subArrayCount;
    }
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
