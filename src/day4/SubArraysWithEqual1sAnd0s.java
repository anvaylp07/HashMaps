package day4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubArraysWithEqual1sAnd0s {
    //similar to zero sum sub array, geeks of geeks
    //day 2 CountOfAllSubArraysWithZeroSum
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // add your code here
        int subArrayCount=0;
        Map<Integer, Integer> memo=new HashMap<>();
        memo.put(0,1);
        int prefixSum=0;
        for (int right=0; right<n; right++){
            int add=arr[right];
            if (add==0)
                add=-1;
            prefixSum+=add;
            if (memo.containsKey(prefixSum))
                subArrayCount+=memo.get(prefixSum);
            memo.put(prefixSum, memo.getOrDefault(prefixSum,0)+1);
        }
        return subArrayCount;
    }
    public static void main(String[] args) {
        int a[]=new int[]{1,0,0,1,0,1,1};
        System.out.print(countSubarrWithEqualZeroAndOne(a, a.length));
    }
}
