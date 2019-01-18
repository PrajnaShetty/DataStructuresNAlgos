package greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prajnashetty on 1/13/19.
 *
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 */
public class ActivitySelection {

    private static int[] getActivitiesSelected(int[] start, int[] finish) {
        List<Integer> activitiesSelected = new ArrayList<>();

        Arrays.sort(finish);

        activitiesSelected.add(0);

        int j = 0;
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= finish[j]) {
                activitiesSelected.add(i);
                j = i;
            }
        }

        return activitiesSelected.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 9, 7, 4, 6, 9};

        int[] activitiesSelected = getActivitiesSelected(start, finish);
        System.out.println("Max activities selected : " + Arrays.toString(activitiesSelected));








    }


}
