package day6;

public class CountNumberOfSubstringsWithExactlyKDistinctCharacters {
    //failed to solve on your own
    //GFG imp
    //Amazon
    public static int getCount(String s, int k){
        //Count number of substrings
        //NOTE:
        //using array as memo as using hashmap gives TLE on GFG.
        //Most likely due to hash collisons.
        return CountSubStringsHavingAtmostKUniqueCharacters.getSubStringCountUsingArraysAsMemo(s,k)
                -CountSubStringsHavingAtmostKUniqueCharacters.getSubStringCountUsingArraysAsMemo(s,k);
    }
    public static void main(String[] args) {
        System.out.println(getCount("ababca",2));
    }
}
