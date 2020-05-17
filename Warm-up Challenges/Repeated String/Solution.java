import java.io.*;
import java.util.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        //count on single string
        StringBuilder builder = new StringBuilder(s);
        long count = builder.chars().filter(a -> a == 97).count();

        //count on total complete strings
        long totalStrings = n / (s.length());
        count = (totalStrings * count);

        int leftOver = (int) (n % (s.length()));
        String finalSubstring = s.substring(0, leftOver);
        builder = new StringBuilder(finalSubstring);
        count += builder.chars().filter(a -> a == 97).count();

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
