package OldTest;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        int[] arr =  { 5, 4, 3, 7, 6, 1, 9 };
        int n = arr.length;
        sol2(arr, n);
    }

    private static void sol1(int arr[], int n){
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= i; j--){
                if(arr[i] < arr[j]-1 && (j - i) > 1){
                    for(int k = i+1; k < j; k++){
                        if(arr[i] < arr[k] && arr[k] < arr[j]){
                            System.out.println(arr[i]+" "+arr[k]+ " "+arr[j]);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Not found");
    }

    private static void sol2(int[] arr, int n){
        int[] minArr = new int[n];
        int[] maxArr = new int[n];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int maxIndex = n-1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] < min){
                minArr[i] = i;
                min = arr[i];
                minIndex = i;
            } else {
                minArr[i] = minIndex;
            }

            if(arr[n-i-1] > max){
                maxArr[n-i-1] = n-i-1;
                max = arr[n-i-1];
                maxIndex = n-i-1;
            } else {
                maxArr[n-i-1] = maxIndex;
            }
        }
        System.out.println(Arrays.toString(minArr));
        System.out.println(Arrays.toString(maxArr));
        for(int i = 0; i < n; i++){
            if((maxArr[i] - minArr[i]) > 1){
                for(int k = minArr[i]; k < maxArr[i]; k++){
                    if(arr[minArr[i]] < arr[k] && arr[k] < arr[maxArr[i]]){
                        System.out.println(arr[minArr[i]]+" "+arr[k]+ " "+arr[maxArr[i]]);
                    }
                }
            }
        }
    }
}
