//https://leetcode.com/problems/binary-search-tree-iterator/
import java.util.*;
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
class BSTIterator {
    static LinkedList<TreeNode> qu;
    public BSTIterator(TreeNode root) {
        qu=new LinkedList<>();
        inorder(root);
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        qu.addLast(root);
        inorder(root.right);
    }
    /** @return the next smallest number */
    public int next() {
        return qu.removeFirst().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return qu.size()==0?false:true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        pushallnextElem(root);
        
    }
    public void pushallnextElem(TreeNode root){
        if(root==null) return;
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode rem=st.pop();
        pushallnextElem(rem.right);
        return rem.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return st.size()==0?false:true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
