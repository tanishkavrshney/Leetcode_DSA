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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightview(root,ans,0);
        return ans;
    }
    public void rightview(TreeNode root,List<Integer> ans,int rootdepth){
        if(root==null) return;
        if(rootdepth==ans.size()) ans.add(root.val);
        rightview(root.right,ans,rootdepth+1);
        rightview(root.left,ans,rootdepth+1);
    }
}