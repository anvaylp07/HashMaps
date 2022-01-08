package day7;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //leetcode
    public static int[] twoSum(int[] nums, int target) {
        int []indexes=new int[2];
        int n=nums.length;
        Map<Integer, Integer> memo=new HashMap<>();
        for (int i=0; i<n; i++){
            int key=target-nums[i];
            if (memo.containsKey(key)){
                indexes[0]=memo.get(key);
                indexes[1]=i;
                break;
            }
            memo.put(nums[i], i);
        }
        return indexes;
    }
    public static void main(String[] args) {
        int []a=twoSum(new int[]{3,3},6);

        System.out.println(a[0]+" "+a[1]);
    }
}
