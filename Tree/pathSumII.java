//Path Sum II https://leetcode.com/problems/path-sum-ii/

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<>();
        path(root,sum,ans,new ArrayList<>());
        return ans;
    }
    public static void path(TreeNode root,int sum,List<List<Integer>> ans,List<Integer> li){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(sum-root.val==0){
                li.add(root.val);
                ans.add(new ArrayList<>(li));
                li.remove(li.size()-1);
            }
            return;
        }
        li.add(root.val);
        path(root.left,sum-root.val,ans,li);
        path(root.right,sum-root.val,ans,li);
        li.remove(li.size()-1);
    }
}
