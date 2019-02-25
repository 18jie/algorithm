package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:09:19
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index1 = 0;
        int index2 = 0;
        int valNum = 0;
        while (index2 < nums.length && index1 < nums.length) {
            if (nums[index2] != val && nums[index1] != val) {
                index1++;
                index2++;
            } else if (nums[index1] == val) {
                while (index2 < nums.length && nums[index2] == val) index2++;
                if (index2 < nums.length) {
                    swap(nums, index1, index2);
                    index1++;
                }
            }
        }
        return index1;
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        RemoveElement r = new RemoveElement();
        int i = r.removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}
