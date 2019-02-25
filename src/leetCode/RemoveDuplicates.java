package leetCode;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。<br>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。<br>
 * @author fengjie
 * @date 2018:09:19
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int index1 = 0;
        int index2 = 1;
        while(index2 < nums.length){
            if(nums[index1] != nums[index2]){
                nums[++index1] = nums[index2];
                index2++;
            }else{
                index2++;
            }
        }
        return index1+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }

}
