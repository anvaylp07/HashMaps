package day7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> allAnagramsList=new LinkedList<>();
        int n=strs.length;
        Map<String, List<String>> anagramMemo=new HashMap<>();
        for (int i=0; i<n; i++){
            String currentStr=strs[i];
            int []memo=new int[26];
            for (int j=0; j<currentStr.length(); j++){
                memo[currentStr.charAt(j)-'a']++;
            }
            String key="";
            for (int j=0; j<26; j++){
                key=key.concat(String.valueOf(memo[j])).concat("_");
            }
            if (anagramMemo.containsKey(key)){
                anagramMemo.get(key).add(currentStr);
            }
            else{
                List<String> anagramList=new LinkedList<>();
                anagramList.add(currentStr);
                anagramMemo.put(key,anagramList);
                allAnagramsList.add(anagramList);
            }
        }
        return allAnagramsList;
    }
    public static void main(String[] args) {
        String [] s=new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> allAnagramsList=groupAnagrams(s);
        for (List<String> angrams:allAnagramsList){
            for (String str: angrams){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}
