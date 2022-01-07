package day4;

import java.util.HashMap;
import java.util.Map;

public class Equal0s1s2s {
    //GFG
    public static long getCountOfSubstrings(String s){
        int subArrayCount=0, noOfZeros=0, noOfOnes=0, noOfTwos=0;
        Map<String, Integer>memo=new HashMap<>();
        String key=(noOfOnes-noOfZeros)+"#"+(noOfTwos-noOfOnes);
        memo.put(key, 1);
        int n=s.length();
        for (int right=0; right<n; right++){
            if (s.charAt(right)=='0')
                noOfZeros++;
            else if (s.charAt(right)=='1')
                noOfOnes++;
            else if (s.charAt(right)=='2')
                noOfTwos++;
            key=(noOfOnes-noOfZeros)+"#"+(noOfTwos-noOfOnes);
            if (memo.containsKey(key)) {
                subArrayCount += memo.get(key);
            }
            memo.put(key, memo.getOrDefault(key, 0)+1);
        }
        return subArrayCount;
    }
    public static void main(String[] args) {
        System.out.println(getCountOfSubstrings("0102010"));
    }
}
