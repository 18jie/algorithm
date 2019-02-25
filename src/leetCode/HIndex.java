package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:12
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }

    public int hIndex1(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        /*
        使用二分法，如果中间那个数>从mid开始到最末尾也就是大于等于这个数的数的个数至少有这么多（mid前面可能还有跟mid一样大的数），
        说明mid右边的数不可能存在h，去左边找，
        同理与另一种情况
        最后循环结束时，low=high+1；
        从low开始右边的数都比当前位置的大
        */
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        HIndex h = new HIndex();
        int[] nums = {3, 0, 6, 1, 5};
        int i = h.hIndex(nums);
        System.out.println(i);
    }

}
