package OldTest;

import java.util.Arrays;

public class ArrivalDepartureProblem {
    public static void main(String[] args) {
        int arrival[] = {100, 140, 150, 200, 215, 400};
        int departure[] = {110, 300, 220, 230, 315, 600};
        System.out.println(minPlatformReq(arrival, departure));
    }

    //O(nlogn + 2n) ~= O(nlog(n))
    private static int minPlatformReq(int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0;
        int j = 0;
        int max = 0;
        int t = 0;
        while (i < arrival.length){
            if(arrival[i] < departure[j]){
                t++;
                i++;
            } else {
                t--;
                j++;
            }
            if(t > max){
                max = t;
            }
        }
        return max;
    }
}
