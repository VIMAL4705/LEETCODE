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
class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        List<List<Integer>>res=new ArrayList<>();
        if(root==null) return res;
        while(q.size()>0)
        {
            int size=q.size();
            ArrayList<Integer>currLevelElements=new ArrayList<>();
            while(size-->0)
            {
                TreeNode currentElement=q.poll();
                currLevelElements.add(currentElement.val);
                if(currentElement.left!=null)q.add(currentElement.left);
                if(currentElement.right!=null)q.add(currentElement.right);
            }
            res.add(currLevelElements);
        }
        return res;
    }
}
