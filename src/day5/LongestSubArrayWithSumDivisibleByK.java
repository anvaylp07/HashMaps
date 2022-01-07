package day5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumDivisibleByK {
    //gfg
    public static int getLengthOfLongestSubArray(int arr[], int n, int k){
        int maxLength=0;
        Map<Integer, Integer> memo=new HashMap<>();
        memo.put(0,-1);
        int left=0;
        int remainder;
        int prefixSum=0;
        for (int right=0; right<n; right++){
            prefixSum+=arr[right];
            remainder=((prefixSum%k)+k)%k;
            if (memo.containsKey(remainder))
                maxLength=Math.max(maxLength, right-memo.get(remainder));
            else memo.put(remainder, right);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int []arr=new int[]{-2, 2, -5, 12, -11, -1, 7};

        System.out.println(getLengthOfLongestSubArray(arr, arr.length, 3));
    }
}
