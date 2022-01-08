package day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {
    //gfg
    private static List<Integer> countDistinct(int arr[], int k){
        int left=0,right=0;
        int n=arr.length;
        int distinctCount=0;
        Map<Integer, Integer>memo=new HashMap<>();
        List<Integer> windowCount=new ArrayList<>();
        while (right<n){

            if (!memo.containsKey(arr[right]))
                distinctCount++;
            memo.put(arr[right], memo.getOrDefault(arr[right],0)+1);
            right++;
            if (right>=k) {
                windowCount.add(distinctCount);
                if (memo.get(arr[left])==1) {
                    distinctCount--;
                    memo.remove(arr[left]);
                }
                else memo.put(arr[left], memo.get(arr[left])-1);
                left++;
            }
        }
        return windowCount;
    }
    public static void main(String[] args) {
        List<Integer> list= countDistinct(new int[]{4,1,1},2);
        for (Integer i: list){
            System.out.println(i);
        }
    }
}
