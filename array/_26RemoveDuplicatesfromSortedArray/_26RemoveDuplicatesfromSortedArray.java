package array._26RemoveDuplicatesfromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i = 0; i < nums.length - 1 ; i++) {
            if (nums[i] < nums[i + 1]) {
                nums[index] = nums[i + 1];
                index++;
            }
        }

        return index;
    }
}

public class _26RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
    }
}
