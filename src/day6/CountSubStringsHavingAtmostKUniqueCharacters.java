package day6;

import java.util.HashMap;
import java.util.Map;

public class CountSubStringsHavingAtmostKUniqueCharacters {
    static int getSubStringCount(String str, int k){
        int subStringCount=0;
        int left=0;
        int n=str.length();
        Map<Character, Integer> memo=new HashMap<>();
        for (int right=0; right<n; right++){
            Character key=str.charAt(right);
            memo.put(key, memo.getOrDefault(key,0)+1);
            while (memo.size()>k && left<=right){
                Character discard=str.charAt(left);
                memo.put(discard, memo.get(discard)-1);
                if (memo.get(discard)==0)
                    memo.remove(discard);
                ++left;
            }
            subStringCount+=right-left+1;
        }
        return subStringCount;
    }
    static int getSubStringCountUsingArraysAsMemo(String str, int k){
        int subStringCount=0;
        int left=0;
        int n=str.length();
        char[] memo=new char[26];
        int distinctCount=0;
        for (int right=0; right<n; right++){
            int key=str.charAt(right)-'a';
            if (memo[key]==0){
                ++distinctCount;
            }
            ++memo[key];
            while (distinctCount>k && left<=right){
                int discard=str.charAt(left)-'a';
                --memo[discard];
                if(memo[discard]==0)
                    --distinctCount;
                ++left;
            }
            subStringCount+=right-left+1;
        }
        return subStringCount;
    }
    public static void main(String[] args) {
        System.out.println(getSubStringCount("aabcbcdbca",2));
        System.out.println(getSubStringCountUsingArraysAsMemo("aabcbcdbca",2));
    }
}
