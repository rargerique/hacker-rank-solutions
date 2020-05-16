import java.io.*;
import java.util.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int altitude = 0;
        int sum = 0;
        boolean configuresValley = false;
        for(char movement: s.toCharArray()){
            if(movement == 'D'){
                altitude--;
            } else{
                altitude++;
            }
            if(!configuresValley){
                configuresValley = altitude <= -1;
            }
            if(altitude == 0 && configuresValley){
                sum++;
                configuresValley = false;
            }
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
