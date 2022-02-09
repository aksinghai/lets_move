package OldTest;

public class Problem11 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int K = 5;
        printCombinationWithSumK(arr, K, arr.length-1, "");
    }

    private static void printCombinationWithSumK(int[] arr, int K, int n, String str){
        if(n < 0 && K == 0){
            System.out.println(str);
            return;
        }
        if(n >= 0){
            if(K >= arr[n]){
                //Include
                printCombinationWithSumK(arr,K - arr[n], n-1, arr[n]+" "+str);
            }
            //Exclude
            printCombinationWithSumK(arr,K, n-1, str);
        }
    }

    private static void printCombinationWithSumKApproach2(int[] arr, int K){
        int n = arr.length;
        boolean[][] lookup = new boolean[n+1][K+1];
        for(int i = 0; i < n+1; i++){
            lookup[i][0] = true;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < K+1; j++){
                if(arr[i - 1] > j){

                }
            }
        }


    }

}
