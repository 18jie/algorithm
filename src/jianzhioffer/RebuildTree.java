package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:10:21
 */
public class RebuildTree {

    public TreeNode solution(int [] pre,int [] in){
        TreeNode root = new TreeNode(pre[0]);
        buildHead(root,pre,in);
        return root;
    }

    public void buildHead(TreeNode node,int[] pre,int[] in){
        int position = position(node.val, in);
        int[] left = new int[position];
        int[] right = new int[in.length - position];
//        buildLeft(node,pre,in,position,);
    }

    public void buildLeft(TreeNode node,int[] pre,int[] in,int inPostion,int prePosition){

    }

    public void buildRight(){

    }

    public int position(int i,int[] nums){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] < i){
                left = left + 1;
            }else if(nums[mid] > i){
                right = right - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
