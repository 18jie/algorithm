package leetCode;

import java.util.Arrays;

/**
 * leetcode 88
 * @author fengjie
 * @date 2018:12:19
 */
public class Merge {

    //这种方式太直了，可以从后往前对应
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) return;
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        int iNum1 = 0, iNum2 = 0;
        while (iNum1 < m && iNum2 < n) {
            if (temp[iNum1] < nums2[iNum2]) {
                nums1[iNum1 + iNum2] = temp[iNum1++];
            } else {
                nums1[iNum1 + iNum2] = nums2[iNum2++];
            }
        }

        while (iNum1 < m) {
            nums1[iNum1 + iNum2] = temp[iNum1++];
        }

        while (iNum2 < n) {
            nums1[iNum1 + iNum2] = nums2[iNum2++];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        Merge me = new Merge();
        me.merge(nums1, 0, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
