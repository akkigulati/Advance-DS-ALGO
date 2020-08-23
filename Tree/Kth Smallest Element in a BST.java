//https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int KthSmallestAns = -1;
    int Kth=0;
    public boolean kthSmallest_(TreeNode root) {
        if(root == null) return false;

        if(kthSmallest_(root.left)) return true;

        if(--Kth == 0){
            KthSmallestAns = root.val;
            return true;
        }

        if(kthSmallest_(root.right)) return true;
        return false;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Kth = k;
        kthSmallest_(root);
        return KthSmallestAns;
    }
}
