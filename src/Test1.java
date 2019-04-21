import java.util.*;

/**
 * Created by prajnashetty on 2/25/19.
 *
 * findNodesWithZeroAndOneParents(parentChildPairs) => [
 [1, 2, 4],    // Individuals with zero parents
 [5, 7, 8, 10] // Individuals with exactly one parent
 ]
 */
public class Test1 {


    public static void main(String[] args) {

        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        };

        int[][] res = findNodesWithZeroAndOneParents(parentChildPairs);

    }

    private static int[][] findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> noParents = new HashSet<>();


        for (int i = 0; i < parentChildPairs.length; i++) {

            int[] pair = parentChildPairs[i];

            List<Integer> parents;
            if (map.containsKey(pair[1])) {
                parents = map.get(pair[1]);
            } else {
                parents = new ArrayList<>();
            }

            parents.add(pair[0]);
            map.put(pair[1], parents);

        }

        Set<Integer> noParent = new HashSet<>();
        for (int i = 0; i < parentChildPairs.length; i++) {
            int[] pair = parentChildPairs[i];
            if (!map.containsKey(pair[0])) {
                noParent.add(pair[0]);
            }
        }

        Set<Integer> oneParent = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())    {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue().size() == 1) {
                oneParent.add(entry.getKey());
            }
        }

        int[][] res = new int[2][];
        int[] noParentsArr = noParent.stream().mapToInt(a -> a).toArray();
        res[0] = noParentsArr;
        System.out.println("no parents = " + Arrays.toString(noParentsArr));

        int[] oneParentsArr = oneParent.stream().mapToInt(a -> a).toArray();
        res[1] = oneParentsArr;
        System.out.println("one parents = " + Arrays.toString(oneParentsArr));

        return res;
    }
}
