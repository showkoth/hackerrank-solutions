import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    private static long arraySum(List<Integer> arr, int start, int end){
        int even = 0;
        int odd = 0;
        for(int i = start; i <= end; i++){
            if(i % 2 == 0) even += arr.get(i);
            else odd += arr.get(i);
        }
        int x = even - odd;
        return x * x;
    }
    public static long maxSubarrayValue(List<Integer> arr) {
        long MAX_SUM = Long.MIN_VALUE;
        int n = arr.size();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++ ){
                long sum = arraySum(arr, i, j);
                if(sum > MAX_SUM) MAX_SUM = sum;
            }
        }
        return MAX_SUM;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.maxSubarrayValue(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
