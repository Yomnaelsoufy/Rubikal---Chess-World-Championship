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

public class Solution {

    // Complete the solve function below.
    static String solve(List<List<Integer>> board) {
    int row=board.size();
    int column=board.get(0).size();
    for (int i=0;i<row;i++)
    {
        for (int j=0;j<column;j++){
            int point=board.get(i).get(j);
            int right=(j+1<column)?board.get(i).get(j+1):-1;
            int down=(i+1<row)?board.get(i+1).get(j):-1;

            if ((point==1&&(right==1||down==1))||(point==0&&(right==0||down==0)))
            { return "No";}
        }
    }
    return "Yes";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> board = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        board.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = solve(board);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
