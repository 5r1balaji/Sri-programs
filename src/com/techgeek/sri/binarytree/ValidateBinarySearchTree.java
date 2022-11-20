package com.techgeek.sri.binarytree;


public class ValidateBinarySearchTree {

    /**
     *              6
     *          4     10
     *       3   7   5   11
     *
     *       Expected False bcoz 7 cannot be on the left sub tree
     * @param args
     */

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(6);
        tree.right = new BinaryTree(10);
        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(11);

        tree.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(7);
        tree.left.left = new BinaryTree(3);

        System.out.println(validate(tree,null,null));
        //System.out.println(validate2(tree,null,null));

    }



    /**
     * When processing the validation , the left and right Variables plays the role of the root node.
     * i.e When travelling through left , the right node will be root to be compared and its value
     * should greater than the current node which is processed. The current node will the left of Root node
     *
     * While travelling through right node, the root will be the left node. The current node will be root's right node
     * The value of root element is retained in the right variable .
     * So in the  6 root (while travelling left will be passed in the right variable).
     *
     * Once the first recursion passed, the root element comparison with right sub child will be done again
     * i.e 6 and 7 , 6 is in the right variable and 7 is the current element.(tree)
     * 4 will in the left variable. if (left.data > tree.data) means (4 > 7 ) is false
     * so the next condition is to check whether 7 is also greater than 4's parent
     *
     * @param root
     * @param left
     * @param right
     * @return
     */
    private static boolean validate(BinaryTree tree, BinaryTree left, BinaryTree right) {
        if (tree == null) {
            return true;
        }
            if ( left != null && left.data > tree.data) {
                return false;
            }
            if ( right != null && right.data < tree.data) {
                return false;
            }
        return validate(tree.left,left,tree) && validate(tree.right,tree,right);
    }


}
