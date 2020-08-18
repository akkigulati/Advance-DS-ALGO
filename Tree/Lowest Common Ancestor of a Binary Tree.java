//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode LCANode = null;
    
    public boolean lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;

        boolean selfDone = false;
        if(root == p || root == q) selfDone = true;

        boolean leftDone = lowestCommonAncestor_(root.left, p, q);
        if(LCANode!=null) return true;
        
        boolean rightDone = lowestCommonAncestor_(root.right, p, q);
        if(LCANode!=null) return true;

        if((leftDone && rightDone) ||(leftDone && selfDone) || (rightDone && selfDone)) LCANode = root;
        
        return selfDone || leftDone || rightDone;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor_(root,p,q);
        return LCANode;
    }
}
