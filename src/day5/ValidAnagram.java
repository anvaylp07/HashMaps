package day5;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;
        int n=s.length();
        Map<Character, Integer> memo=new HashMap<>();
        for (int i=0; i<n; i++){

            memo.put(s.charAt(i), memo.getOrDefault(s.charAt(i),0)+1);
            memo.put(t.charAt(i), memo.getOrDefault(t.charAt(i),0)-1);
            if (memo.get(s.charAt(i))==0)
                memo.remove(s.charAt(i));
            if (memo.containsKey(t.charAt(i)) && memo.get(t.charAt(i))==0)
                memo.remove(t.charAt(i));
        }
        return memo.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
