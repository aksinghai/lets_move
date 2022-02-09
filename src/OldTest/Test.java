package OldTest;

public class Test {
    public static void main(String[] args){
        int[] arr = {3, 5, 9, 10, 4, 2, 40, 60, 100};
        int max = 0;
        for(int j = 2; j < arr.length-2; j++){
            int leftMax = 0;
            int[] ar = new int[j];
            ar[0] = arr[0];
            for(int i = 1; i < j; i++){
                if(ar[i-1] < arr[i]){
                    ar[i] = ar[i-1];
                } else {
                    ar[i] = arr[i];
                }
            }

            for(int i = j-1; i >= 0; i--){
                if(leftMax < (arr[i] - ar[i])){
                    leftMax = arr[i] - ar[i];
                }
            }

            int rightMax = 0;
            ar = new int[arr.length-j];
            ar[0] = arr[j];
            for(int i = j+1; i < arr.length; i++){
                if(ar[i-j-1] < arr[i]){
                    ar[i-j] = ar[i-j-1];
                } else {
                    ar[i-j] = arr[i];
                }
            }

            for(int i = arr.length-1; i >= j; i--){
                if(rightMax < (arr[i]-ar[i-j])){
                    rightMax = arr[i] - ar[i-j];
                }
            }
            max = Integer.max(max, leftMax+rightMax);
        }
        System.out.println(max);
    }
}
