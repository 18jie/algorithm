package leetCode;

/**
 * @author fengjie
 * @date 2018:12:24
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null) return null;
        String[] words = s.trim().split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("") || words[i].equals(" ")) continue;
            str.append(words[i].trim());
            if (i != 0) {
                str.append(" ");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "   a    b  ";
        ReverseWords r = new ReverseWords();
        System.out.println(r.reverseWords(s));
    }

}
