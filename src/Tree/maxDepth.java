package Tree;

import javax.swing.tree.TreeNode;

public class maxDepth {
    public static int maxdepth(treeNode root){
        if(root==null) return 0;

        int left = maxdepth(root.left);
        int right = maxdepth(root.right);

        return 1+Math.max(left,right);
    }
}
