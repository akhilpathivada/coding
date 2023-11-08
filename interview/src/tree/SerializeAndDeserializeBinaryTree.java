/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("# ");
                continue;
            }
            sb.append(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < values.length; ++i) {
            TreeNode node = queue.poll();
            if (!values[i].equals("#")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftChild;
                queue.add(leftChild);
            }
            if (++i < values.length && !values[i].equals("#")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightChild;
                queue.add(rightChild);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = new SerializeAndDeserializeBinaryTree().serialize(root);
        System.out.println(s);
        root.preOrder(new SerializeAndDeserializeBinaryTree().deserialize(s));
    }
}
