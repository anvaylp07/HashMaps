package day4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqual0s1s2s {
    //Pepcoding
    //length of subarray having number of 0s, 1s and 2s are equal
    public static int getLongestString(int arr[]){
        int maxLength=0,noOfZeros=0, noOfOnes=0, noOfTwos=0;
        Map<String, Integer> memo=new HashMap<>();
        String key=(noOfZeros-noOfOnes)+"#"+(noOfOnes-noOfTwos);
        memo.put(key,-1);
        int n=arr.length;
        for (int right=0; right<n; right++){
            if (arr[right]==0)
                noOfZeros++;
            else if (arr[right]==1)
                noOfOnes++;
            else if (arr[right]==2)
                noOfTwos++;
            key=(noOfZeros-noOfOnes)+"#"+(noOfOnes-noOfTwos);
            if (memo.containsKey(key))
                maxLength=Math.max(maxLength, right-memo.get(key));
            else memo.put(key, right);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.print(getLongestString(new int[]{0, 1, 0, 2, 0, 1, 0}));
    }
}
