package greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by prajnashetty on 1/16/19.
 *
 * Time Complexity
 *
 * O(nk) where k is small constant. But we used sorting so overall it will be O(nlogn).
 * O(n) to iterate all jobs and O(k) for find operations. But because we use path compression, k is small constant.
 * Hence O(nk) -> O(n) . But we use sorting so O(nlogn).
 */
public class JobSequencingDisJointSets {

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

        //Solution with DisJoint Sets
        System.out.println("Max activities selected : " + getJobsSeqSolution(jobs1));
        System.out.println("Max activities selected : " + getJobsSeqSolution(jobs2));

    }

    private static List<Character> getJobsSeqSolution(Job1[] jobs) {
        List<Character> result = new ArrayList<>();

        Arrays.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());

        List<Integer> deadlineList = Arrays.stream(jobs).map(Job1::getDeadline).collect(Collectors.toList());
        Collections.sort(deadlineList);
        int maxDeadline = deadlineList.get(deadlineList.size() - 1);

        //makeSet for disjoint set
        DisjointSet disjointSet = new DisjointSet(maxDeadline);

        //iterate through jobs
        for(Job1 job: jobs) {

            int availableSlot = disjointSet.find(job.getDeadline());

            if (availableSlot > 0) {
                disjointSet.unionSet(disjointSet.find(availableSlot - 1), availableSlot);
                result.add(job.getId());
            }
        }

        return result;
    }


}

class DisjointSet{
    int[] parent;

    DisjointSet(int n) {
        parent = new int[n + 1];

        //makeSet
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int s) {
        if (s == parent[s])
            return s;

        return parent[s] = find(parent[s]);
    }

    void unionSet(int i, int j) {
        parent[j] = i;
    }
}
