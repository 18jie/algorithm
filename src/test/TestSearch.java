package test;

import java.util.Arrays;

public class TestSearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 8, 10};
        int i = Arrays.binarySearch(array, 3);
        System.out.println(i);
    }

    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = (left + right)/2;
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }
        }
        if(nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }
}
