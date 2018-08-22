package tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_Binary_Tree_Level_Order_Traversal_II {

    /**
     * 易错题。
     * qu.size()要提前保存。
     * queue的size可以用来做level的分层。
     *
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = qu.size(); //这里很重要！size要提前存好!
            for (int i = 0; i < size; i++) {//0
                TreeNode node = qu.poll();//2
                if(node != null) {
                    list.add(node.val);//[3]
                    if(node.left != null) qu.offer(node.left);//
                    if(node.right != null) qu.offer(node.right);//[9,20]
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
