//https://leetcode.com/problems/binary-tree-cameras/submissions/

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
    //-1 :camera required, 0 :camera, 1 :leaf 
    int cameras=0;
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        if(minCameraCover_(root)==-1) cameras++;
        return cameras;
    }
    public int minCameraCover_(TreeNode root) {
        if(root==null) return 1;
        int lans=minCameraCover_(root.left);
        int rans=minCameraCover_(root.right);
        
        if(lans==-1||rans==-1){
            cameras++;
            return 0;
        }
        if(lans==0||rans==0) return 1;
        
        return -1;
    }
}
