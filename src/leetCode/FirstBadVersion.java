package leetCode;

/**
 * @author fengjie
 * @date 2019:02:02
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) >> 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return isBadVersion(left) ? left : left + 1;
    }

    public boolean isBadVersion(int version) {
        return false;
    }
}
