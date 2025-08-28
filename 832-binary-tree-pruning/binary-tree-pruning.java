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
    public boolean check(TreeNode node){
        if(node==null) return false;
        boolean left=check(node.left);
        boolean right=check(node.right);
        if(left==false){
            node.left=null;
        }
        if(right==false){
            node.right=null;
        }
        if(left || right || node.val==1){
            return true;
        }
        return false;
    }
    public TreeNode pruneTree(TreeNode root) {
        check(root);
        if(root.val==0 && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
}