package jianzhioffer;

import java.util.ArrayList;

/**
 * 打印字符串的全排列
 * 第一反应：回溯法
 * @author fengjie
 * @date 2018:11:10
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : chars) {
            if (!characters.contains(c))
                characters.add(c);
        }
        ArrayList<String> result = new ArrayList<>();
        char[] temp = new char[str.length()];
        for (int i = 0; i < characters.size(); i++) {
            Character remove = characters.remove(i);
            makeResult(result, remove, characters, new StringBuilder());
            characters.add(i, remove);
        }
        return result;
    }

    public void makeResult(ArrayList<String> result, char head, ArrayList<Character> chars, StringBuilder stringBuilder) {
        stringBuilder.append(head);
        if (chars.size() == 0) {
            String temp = stringBuilder.toString();
            if (!result.contains(temp))
                result.add(temp);
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            Character remove = chars.remove(i);
            makeResult(result, remove, chars, stringBuilder);
            stringBuilder.delete(stringBuilder.toString().length() - 1, stringBuilder.toString().length());
            chars.add(i, remove);
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<String> abc = p.Permutation("abcde");
        System.out.println(abc);
    }

}
