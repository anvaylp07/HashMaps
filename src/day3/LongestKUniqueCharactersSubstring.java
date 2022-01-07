package day3;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharactersSubstring {
    public static int longestkSubstr(String s, int k) {
        // code here
        Map<Character, Integer> memo=new HashMap<>();
        int maxLength=-1;
        int left=0;
        for (int right=0; right<s.length(); right++) {
            Character key=s.charAt(right);
            memo.put(key, memo.getOrDefault(key,0)+1);
            while (memo.size()>k && left<=right){
                Character discard=s.charAt(left);//note left here not key
                memo.put(discard, memo.get(discard)-1);
                if (memo.get(discard)==0)
                    memo.remove(discard);
                left++;
            }
            if (memo.size()==k)
                maxLength=Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe",3));
        //cqcoendtomfgdwdw
    }
}
