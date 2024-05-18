package tree;

public class TreeNode {

        public int data;
        public TreeNode left, right;

        // default constructor
        public TreeNode() {

        }

        // initializing tree node with left and right children
        public TreeNode(int value) {
                data = value;
                left = right = null;
        }

        // prints the PreOrder
        protected void preOrder(TreeNode root) {
                if (root == null) {
                        return;
                }
                System.out.print(root.data + ", ");
                preOrder(root.left);
                preOrder(root.right);
        }

        public void preOrder() {
                System.out.print(this.data + ", ");
                preOrder(this.left);
                preOrder(this.right);
        }

        // prints the InOrder
        protected void inOrder(TreeNode root) {
                if (root == null) {
                        return;
                }
                preOrder(root.left);
                System.out.print(root.data + ", ");
                preOrder(root.right);
        }

        // prints the PostOrder
        protected void postOrder(TreeNode root) {
                if (root == null) {
                        return;
                }
                preOrder(root.left);
                preOrder(root.right);
                System.out.print(root.data + ", ");
        }
}
