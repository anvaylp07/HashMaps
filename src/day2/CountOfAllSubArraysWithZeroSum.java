package day2;

import java.util.HashMap;
import java.util.Map;

public class CountOfAllSubArraysWithZeroSum {
    //gfg
    private static int getCountOfSubArraysWithZeroSum(int arr[]){
        Map<Integer, Integer> memo=new HashMap<>();
        int n=arr.length;
        int prefixSum=0;
        int subArrayCount=0;
        memo.put(0,1);
        for (int i=0;i<n;i++){
            prefixSum+=arr[i];
            if (memo.containsKey(prefixSum))
                subArrayCount+=memo.get(prefixSum);
            memo.put(prefixSum, memo.getOrDefault(prefixSum,0)+1);
        }
        return subArrayCount;
    }
    public static void main(String[] args) {
        System.out.println(getCountOfSubArraysWithZeroSum(new int[]{6,-1,-3,4,-2,2,4,6,-12,-7}));
    }
}
