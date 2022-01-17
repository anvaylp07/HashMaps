package day8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsForAPhoneNumber {
    final static Map<Character, String>memo=new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");

    }};

    public static void generateCombinations(int currentIndex, String currentStr
            , String digits, List<String> letterCombinationsList){

        if (currentIndex>=digits.length()){
            letterCombinationsList.add(currentStr);
            return;
        }
        String currentCombination=memo.get(digits.charAt(currentIndex));
        for (int i=0; i<currentCombination.length(); i++){
            generateCombinations(currentIndex+1, currentStr.concat(String.valueOf(currentCombination.charAt(i)))
                    , digits, letterCombinationsList);
        }
        return;
    }
    public static List<String> letterCombinations(String digits) {
        List<String> letterCombinationsList=new LinkedList<>();
        if (!digits.isEmpty())
            generateCombinations(0, "", digits, letterCombinationsList);
        return letterCombinationsList;
    }
    public static void main(String[] args) {
        List<String> list=letterCombinations("2");
        list.forEach(System.out::println);
        System.out.println(list.size());
    }
}
