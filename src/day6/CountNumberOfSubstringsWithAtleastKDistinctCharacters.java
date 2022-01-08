package day6;

public class CountNumberOfSubstringsWithAtleastKDistinctCharacters {
    //gfg
    public static int getCount(String str, int k){
        int atmostKMinus1Count=CountSubStringsHavingAtmostKUniqueCharacters
                .getSubStringCount(str,k-1);
        //imp!!! it's k-1
        int n=str.length();
        int totalSubStringCount=n*(n+1)/2;
        return totalSubStringCount-atmostKMinus1Count;
    }
    public static void main(String[] args) {
        System.out.println(getCount("aabcbcdbca",2));
    }
}
