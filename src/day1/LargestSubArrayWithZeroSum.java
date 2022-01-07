package day1;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {

    static int maxLen(int arr[], int n){
        int prefixSum=0;
        int maxLength=0;
        Map<Integer, Integer> memo=new HashMap<>();
        memo.put(0,-1);
        for (int right=0; right<n; right++){
            prefixSum+=arr[right];
            if (memo.containsKey(prefixSum)){
                maxLength=Math.max(maxLength, right-memo.get(prefixSum));
            }
            else memo.put(prefixSum, right);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{15,-2,2,-8,1,7,10,23},8));
    }
}
