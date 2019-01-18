package greedyalgorithms;

import jdk.nashorn.api.scripting.AbstractJSObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by prajnashetty on 1/16/19.
 *
 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline.
 * It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.
 *
 * Examples:
 *

 Input:  Five Jobs with following deadlines and profits
 JobID     Deadline     Profit
 a         2           100
 b         1           19
 c         2           27
 d         1           25
 e         3           15
 Output: Following is maximum profit sequence of jobs  -> c, a, e

 Input: Four Jobs with following deadlines and profits
 JobID    Deadline      Profit
 a        4            20
 b        1            10
 c        1            40
 d        1            30
 Output: Following is maximum profit sequence of jobs -> c, a

Solution 1:

 Time Complexity of the solution 1 is O(n^2).
 


 */
public class JobSequencing {

    public static void main(String[] args) {
        Job1[] jobs1 = {
                new Job1('a', 2, 100),
                new Job1('b', 1, 19),
                new Job1('c', 2, 27),
                new Job1('d', 1, 25),
                new Job1('e', 3, 15)

        };

        Job1[] jobs2 = {
                new Job1('a', 4, 20),
                new Job1('b', 1, 10),
                new Job1('c', 1, 40),
                new Job1('d', 1, 30)

        };

        //Solution 1
        System.out.println("Max activities selected : " + getJobsSeqSolution1(jobs1));
        System.out.println("Max activities selected : " + getJobsSeqSolution1(jobs2));

    }

    private static List<Character> getJobsSeqSolution1(Job1[] jobs) {

        //sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());

        List<Integer> deadlineList = Arrays.stream(jobs).map(Job1::getDeadline).collect(Collectors.toList());
        Collections.sort(deadlineList);

        int maxDeadline = deadlineList.get(deadlineList.size() - 1);

        Map<Integer, Character> slotToJobIdMap = new HashMap<>();

        //Initialize all slots to be free
        for (int i = 1; i <= maxDeadline; i++) {
            slotToJobIdMap.put(i, '-');
        }

        int profit = 0;
        for (Job1 job : jobs) {
            int jobDeadline = job.getDeadline();

            //find free slot for this job
            for(int i = jobDeadline; i >= 1; i--) {
                if (slotToJobIdMap.get(i).equals('-')) {
                    slotToJobIdMap.put(i, job.getId());
                    profit += job.getProfit();
                    break;
                }

                if (!slotToJobIdMap.values().contains('-')) {
                    break;
                }
            }
        }


        return slotToJobIdMap.values().stream().filter(a -> a != '-').collect(Collectors.toList());
    }
}


class Job1 {
    private char id;
    private int deadline;
    private int profit;

    Job1(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    char getId() {
        return id;
    }

    int getDeadline() {
        return deadline;
    }

    int getProfit() {
        return profit;
    }

    public String toString() {
        return id + "";
    }
}
