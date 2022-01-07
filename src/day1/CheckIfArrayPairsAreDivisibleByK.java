package day1;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByK {
    //this problem not possible in single loop
    public static boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> memoRemainder=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int remainder=((arr[i]%k)+k)%k;//when arr[i] is -ve because they should satisfy
            // dividend=quo*divisor+remainder
            memoRemainder.put(remainder, memoRemainder.getOrDefault(remainder,0)+1);
        }

        for (Integer i: memoRemainder.keySet()){
            //wrong condition
            //if (i==0 && memoRemainder.get(i)%2!=0){
            if (i==0){
                if (memoRemainder.get(i)%2!=0){
                    return false;
                }
            }
            else {
                if (!memoRemainder.get(i).equals(memoRemainder.get(k-i)))
                    return false;
            }
        }
//        for (Map.Entry<Integer, Integer> entry: memoRemainder.entrySet()){
//            if (entry.getKey()==0) {
//                if (entry.getValue() % 2 != 0)
//                    return false;
//            }
//            else {
//                int pair = k-entry.getKey();// it's get key not getValue
//                if (!entry.getValue().equals((memoRemainder.get(pair))))// use .equals not != here
//                    //refer line 34
//                    return false;
//            }
//        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(canArrange(new int[]{-1,1,-2,2,-3,3,-4,4},3));
        //System.out.println(-11%7);
        Map<Integer, Integer>memo=new HashMap<>();

        System.out.println(Integer.valueOf(1).equals(memo.get(1)));
        //System.out.println(memo.get(1).equals(1));//error memo should be within equals
    }
}
