package day3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
    //good problem
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int left=0;
        //int right=0;
        int maxlength=0;

        Map<Character,Integer> memo = new HashMap<>();

        for (int right=0;right<n;right++){
            Character key=s.charAt(right);
            if (memo.containsKey(key)) {
                left = Math.max(left, memo.get(key) + 1);
            }
            //"Max(left, )" for abba case left is more than last loc of a
            //or alternate condition
//            if (memo.containsKey(key) && memo.get(key)>=left)
//                left=memo.get(key)+1;
            memo.put(key, right);
            maxlength=Math.max(maxlength, right-left+1);
        }
        return maxlength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
