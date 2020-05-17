import java.util.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int swaps = 0;
        int[] swapsByPosition = new int[q.length];
        Arrays.fill(swapsByPosition, 0); 
        boolean lineReady = true;
        do{
            lineReady = true;
            for(int i=0; i<q.length-1; i++){
                if(q[i] > q[i+1]){
                    lineReady = false;
                    swapsByPosition[q[i]-1]++;
                    if (!validateSwapAmount(swapsByPosition[q[i]-1])) return;
    
                    int j = q[i];
                    q[i] = q[i+1];
                    q[i+1] = j;
    
                    swaps++;
                }
            }
        } while(!lineReady);
    
        System.out.println(swaps);
    }

    private static boolean validateSwapAmount(int runs){
        if(runs == 3){
            System.out.println("Too chaotic");
            return false;
        } 

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
