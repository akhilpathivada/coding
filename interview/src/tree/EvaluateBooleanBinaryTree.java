/**
 * author: akhilpathivada
 * time: 18/05/24 08:01
 */
package tree;

public class EvaluateBooleanBinaryTree {

    private boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.data == 1;
        }
        boolean evaluationOfLeftSubtree = evaluateTree(root.left);
        boolean evaluationOfRightSubtree = evaluateTree(root.right);
        if (root.data == 2) {
            return evaluationOfLeftSubtree | evaluationOfRightSubtree;
        }
        return evaluationOfLeftSubtree & evaluationOfRightSubtree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(new EvaluateBooleanBinaryTree().evaluateTree(root));
    }
}
