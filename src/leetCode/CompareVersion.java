package leetCode;

/**
 * 没有完成，思路很简单，并没有什么意义
 * @author fengjie
 * @date 2018:12:25
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        int index = 0;
        String[] version1s = version1.split(".");
        String[] version12 = version2.split(" ");
        while (index < version1.length() && index < version2.length()) {
            if (version1.charAt(index) == version2.charAt(index)) {
                index++;
            } else if (version1.charAt(index) > version2.charAt(index)) {
                return 1;
            } else {
                return -1;
            }
        }
        if (index < version1.length()) {
            return 1;
        } else if (index < version2.length()) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        CompareVersion c = new CompareVersion();
//        System.out.println(c.compareVersion(version1, version2));
        System.out.println(Integer.parseInt("01"));
    }

}
