/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
     {
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
         {
            TreeNode node = queue.poll();
            if (node == null) 
            {
                res.append("null ");
                continue;
            }
            res.append(node.val).append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if (data.isEmpty()) return null;

        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        for (int i = 1; i < str.length; i++) 
        {
            TreeNode parent = qu.poll();

            if (!str[i].equals("null"))
             {
                parent.left = new TreeNode(Integer.parseInt(str[i]));
                qu.add(parent.left);
            }
            i++;
            if (i < str.length && !str[i].equals("null")) 
            {
                parent.right = new TreeNode(Integer.parseInt(str[i]));
                qu.add(parent.right);
            }
        }
        return root;
    }
}
