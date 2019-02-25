package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:26
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> num = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                if (pop != null) {
                    if (flag) {
                        num.add(pop.val);
                        flag = false;
                    }
                    queue.add(pop.right);
                    queue.add(pop.left);
                }
            }

        }
        return num;
    }

}
