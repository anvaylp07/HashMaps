package day4;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayOf0sAnd1s {
    //Geeks for Geeks
    //convert to longes sub-array with zeo sum by considering 0 as -1
    //also return start and end index-->paytm
    //interviewer can ask sub array with equal 10, 20. So replace 10 with -1 and 20 with +1
    static int maxLen(int arr[], int n){
        int prefixSum=0;
        int maxLength=0;
        Map<Integer, Integer> memo=new HashMap<>();
        memo.put(0,-1);
        for (int right=0; right<n; right++){
            int add=arr[right];
            if (add==0)
                add=-1;
            prefixSum+=add;

            if (memo.containsKey(prefixSum)){
                //int temp=right-memo.get(prefixSum);
                maxLength=Math.max(maxLength, right-memo.get(prefixSum));
                /*
                also return start and end index-->paytm//comment line 23
                if(temp>maxLength){
                    maxLength=temp;
                    startIndex=memo.get(prefixSum);
                    endIndex=i;
                }
                 */
            }
            else memo.put(prefixSum, right);
        }
        return maxLength;
    }
    public static void main(String[] args) {
    }
}
