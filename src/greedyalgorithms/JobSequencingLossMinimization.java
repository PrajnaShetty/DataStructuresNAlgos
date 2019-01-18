package greedyalgorithms;

import java.util.Arrays;

/**
 * Created by prajnashetty on 1/16/19.
 *
 * We are given N jobs numbered 1 to N. For each activity, let Ti denotes the number of days required to complete the job. For each day of delay before starting to work for job i, a loss of Li is incurred.
 We are required to find a sequence to complete the jobs so that overall loss is minimized. We can only work on one job at a time.

 If multiple such solutions are possible, then we are required to give the lexicographically least permutation (i.e earliest in dictionary order).

 Examples:

 Input : L = {3, 1, 2, 4} and
 T = {4, 1000, 2, 5}
 Output : 3, 4, 1, 2
 Explanation: We should first complete job 3, then jobs 4, 1, 2 respectively.

 Input : L = {1, 2, 3, 5, 6}
 T = {2, 4, 1, 3, 2}
 Output : 3, 5, 4, 1, 2
 Explanation: We should complete jobs 3, 5, 4, 1 and then 2 in this order.

 Time Complexity: O(N log N)
 Space Complexity: O(N)

 */
public class JobSequencingLossMinimization {
    public static void main(String[] args) {
        Job2[] jobs1 = {
                new Job2('1', 3, 4),
                new Job2('2', 1, 1000),
                new Job2('3', 2, 2),
                new Job2('4', 4, 5)

        };

        Job2[] jobs2 = {
                new Job2('1', 1, 2),
                new Job2('2', 2, 4),
                new Job2('3', 3, 1),
                new Job2('4', 5, 3),
                new Job2('5', 6, 2)

        };

        System.out.println("Order of activities selected : " + Arrays.toString(getJobsSeqSolution1(jobs1)));
        System.out.println("order of activities selected : " + Arrays.toString(getJobsSeqSolution1(jobs2)));
    }

    private static Job2[] getJobsSeqSolution1(Job2[] jobs) {
        Arrays.sort(jobs, (a, b) -> ((b.getLossPerDay() * a.getDuration()) - (a.getLossPerDay() * b.getDuration())));

        return jobs;
    }
}


class Job2 {
    private char id;
    private int lossPerDay;
    private int duration;

    Job2(char id, int l, int d) {
        this.id = id;
        this.lossPerDay = l;
        this.duration = d;
    }

    char getId() {
        return id;
    }

    int getLossPerDay() {
        return lossPerDay;
    }

    int getDuration() {
        return duration;
    }

    public String toString() {
        return id + "";
    }
}
