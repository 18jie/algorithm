package leetCode;

/**
 * @author fengjie
 * @date 2019:01:01
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null){
            return false;
        }
        if(q == null && p != null){
            return false;
        }
        if(q == null && p == null){
            return true;
        }
        if(p.val == q.val){
            boolean flag = isSameTree(p.left,q.left);
            if(!flag){
                return false;
            }
            return isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }

}
