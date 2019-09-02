import java.io.*;
import java.util.Scanner;

public class AlgoSolution {
    public static void main(String[] args) throws IOException {
        for(int fileIndex = 1; fileIndex <= 10;fileIndex++) {
            try {
                Scanner scanner = new Scanner(new File("/Users/chufanxiao/Documents/testing/MSSMSummerAlgo/algoinput/" + fileIndex +".in"));
                int lifeguardsNum = Integer.parseInt(scanner.nextLine());
                //System.out.println(lifeguardsNum);
                Interval[] intervals = new Interval[lifeguardsNum];
                for(int i = 0;i < lifeguardsNum;i++) {
                    String[] nextInterval = scanner.nextLine().split(" ");
                    //System.out.println("Interval: " + nextInterval[0] + "," + nextInterval[1]);
                    intervals[i] = new Interval(Integer.parseInt(nextInterval[0]), Integer.parseInt(nextInterval[1]));
                }
                int maxCoverageTime = Integer.MIN_VALUE;
                for(int skip = 0;skip < lifeguardsNum;skip++) {
                    Interval[] currentIntervals = new Interval[lifeguardsNum - 1];
                    int index = 0;
                    for(int i = 0;i < lifeguardsNum;i++) {
                        if (i != skip) {
                            currentIntervals[index] = intervals[i];
                            index++;
                        }
                    }
                    MergeInterval mergeIntervalHelper = new MergeInterval(currentIntervals);
                    int currentTotalCoverageTime = mergeIntervalHelper.getCoverageTime();
                    maxCoverageTime = Math.max(maxCoverageTime, currentTotalCoverageTime);
                }
                //System.out.println("maxCoverageTime : " + maxCoverageTime);
                BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/chufanxiao/Documents/testing/MSSMSummerAlgo/algooutput/" + fileIndex + ".out"));
                writer.write(String.valueOf(maxCoverageTime));
                writer.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
