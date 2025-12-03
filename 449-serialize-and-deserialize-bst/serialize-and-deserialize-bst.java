/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        return "";
        StringBuilder sb= new StringBuilder();
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            TreeNode node=que.poll();
            if(node==null)
            sb.append("null,");
            else
            {
            sb.append(node.val).append(",");
            que.offer(node.left);
            que.offer(node.right);

            }

        }
        sb.setLength(sb.length()-1);
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())
        return null;
        
       String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < parts.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!parts[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < parts.length && !parts[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;