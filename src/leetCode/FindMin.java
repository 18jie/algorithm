package leetCode;

/**
 * @author fengjie
 * @date 2019:02:03
 */
public class FindMin {

    /**
     * 不含重复元素
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (min > nums[mid]) {
                min = nums[mid];
            }
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    /**
     * 含重复元素
     *
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (min > nums[mid]) {
                min = nums[mid];
            }
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindMin f = new FindMin();
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(f.findMin1(nums));
    }

}
