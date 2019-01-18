package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SearchInRotatedSortedArray {
    private static int search(int[] nums, int target) {
        int mid = 0;
        int n = nums.length;
        int low = 0, high = n - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < high, and lo or high will shrink by at least 1.
        // Proof by contradiction that mid < high: if mid==high, then lo==high and loop would have been terminated.
        while(low < high){
            mid = (low + high)/2;
            if(nums[mid] > nums[high])
                low = mid + 1;
            else high = mid;
        }
        // low==high is the index of the smallest value and also the number of places rotated.
        int rot = low;
        low = 0;high = n-1;
        // The usual binary search and accounting for rotation.
        while(low <= high){
            mid = (low + high)/2;
            int realmid = (mid + rot) % n;
            if(nums[realmid] == target)
                return realmid;
            if(nums[realmid] < target)
                    low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}