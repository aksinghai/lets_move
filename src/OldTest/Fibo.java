package OldTest;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-21
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Fibo {
    public static void main(String[] args) {
        int[] fibo = {1,2,3,5,8,13,21};
        Set<Integer> lookup = new HashSet<>();
        lookup.add(1);
        lookup.add(2);
        lookup.add(3);
        lookup.add(5);
        lookup.add(8);
        lookup.add(13);
        int[] arr = {1,3,7,5};
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j <arr.length; j++ ){
                int tempSum = arr[i]+arr[j];
                if(lookup.contains(tempSum)){
                    System.out.println(arr[i]+","+arr[j]);
                }
            }
        }
    }
}
