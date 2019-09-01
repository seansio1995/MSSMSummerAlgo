import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlgoSolution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/Users/chufanxiao/Documents/testing/MSSMSummerAlgo/algoinput/1.in"));
            int lifeguardsNum = Integer.parseInt(scanner.nextLine());
            System.out.println(lifeguardsNum);
            Interval[] intervals = new Interval[lifeguardsNum];
            for(int i = 0;i < lifeguardsNum;i++) {
                String[] nextInterval = scanner.nextLine().split(" ");
                System.out.println("Interval: " + nextInterval[0] + "," + nextInterval[1]);
                intervals[i] = new Interval(Integer.parseInt(nextInterval[0]), Integer.parseInt(nextInterval[1]));
            }

        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    }
}
