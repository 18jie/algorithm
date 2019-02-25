package others;

/**
 * @author fengjie
 * @date 2018:11:28
 */
public class TestTest {

    public boolean solution(String a,String b){
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < a.length() - 1; i++) {
            String substring = a.substring(0, i);
            String substring1 = a.substring(i + 1, a.length());
            s.append(substring1).append(substring);
            if(s.toString().contains(b)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestTest t = new TestTest();
        String a = "ABACA";
        String b = "CAA";
        boolean solution = t.solution(a, b);
        System.out.println(solution);
    }

}
