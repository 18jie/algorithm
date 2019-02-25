package leetCode;

import java.io.*;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        helper(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void helper(TreeNode root, StringBuilder stringBuilder) {
        if (root != null) {
            stringBuilder.append(root.val).append(",");
            helper(root.left, stringBuilder);
            helper(root.right, stringBuilder);
        } else {
            stringBuilder.append("#").append(",");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] split = data.split(",");
        System.out.println("split de 长度:" + split.length);
        LinkedList<Integer> list = new LinkedList<>();
        for (String str : split) {
            if ("#".equals(str.trim())) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(str.trim()));
            }
        }
        return makeTree(list);
    }

    private TreeNode makeTree(LinkedList<Integer> list) {
        Integer pop = list.pop();
        TreeNode root;
        if (pop == null) {
            return null;
        } else {
            root = new TreeNode(pop);
        }
        if (!list.isEmpty()) {
            root.left = makeTree(list);
        }
        if (!list.isEmpty()) {
            root.right = makeTree(list);
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
//        node4.left = node5;
//        node4.right = node6;
        Codec c = new Codec();

//        File file = new File("C:\\Users\\丰杰\\Desktop\\data.txt");
//        InputStream ins = new FileInputStream(file);
//        byte[] data = new byte[(int) file.length()];
//        ins.read(data);
        String serialize = c.serialize(root);
        System.out.println("原本 ：" + serialize);
        TreeNode deserialize = c.deserialize(serialize);
        System.out.println("还原 ：" + c.serialize(deserialize));

//        TreeNode deserialize = c.deserialize(new String(data));
//
//        long start = System.currentTimeMillis();
//        System.out.println(c.serialize(deserialize));
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
    }
}