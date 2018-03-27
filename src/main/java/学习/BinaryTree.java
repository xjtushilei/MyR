package 学习;


import java.util.Stack;

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void display() {
        System.out.print(this.value + "\t");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
//        AbstractQueuedSynchronizer
//        HashSet set=new HashSet();
//        set.retainAll(set);
        return String.valueOf(value);
    }
}


public class BinaryTree {


    private Node root = null;

    BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }


    //    查找数据：
    public Node findKey(int value) {
        Node current = root;
        while (current != null) {
            if (current.value == value) {
                return current;
            } else if (current.value > value) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        return null;
    }

    //    插入数据：与查找数据类似，不同点在于当节点为空时，不是返回而是插入
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.leftChild = null;
            root.rightChild = null;
        } else {
            Node current = root;
            Node parent = null;
            while (current != null) {
                if (value < current.value) {
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else if (value > current.value) {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                } else {
                    System.out.println("having same value in binary tree");
                    break;
                }
            }
        }
    }

    /**
     * //前序遍历(递归)：
     * 1、访问这个节点
     * 2、调用自身来遍历节点的左子树
     * 3、调用自身来遍历节点的右子树
     */
    public void preOrderTraverse() {
        System.out.print("前序遍历:");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node node) {
        if (node == null)
            return;
        node.display();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 前序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void preOrderByStack() {
        System.out.print("前序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current.display();
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.rightChild;
            }
        }
        System.out.println();
    }


    /**
     * //中序遍历(递归)：
     * 1、调用自身来遍历节点的左子树
     * 2、访问这个节点
     * 3、调用自身来遍历节点的右子树
     */
    public void inOrderTraverse() {
        System.out.print("中序遍历:");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }

    /**
     * 中序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void inOrderByStack() {
        System.out.print("中序非递归遍历:");
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    /**
     * //后序遍历(递归)：
     * 1、调用自身来遍历节点的左子树
     * 2、调用自身来遍历节点的右子树
     * 3、访问这个节点
     */
    public void postOrderTraverse() {
        System.out.print("后序遍历:");
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node node) {
        if (node == null)
            return;

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.display();
    }

    /**
     * 后序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void postOrderByStack() {
        System.out.print("后序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        Node preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.peek().rightChild;
                if (current == null || current == preNode) {
                    current = stack.pop();
                    current.display();
                    preNode = current;
                    current = null;
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(6);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(4);


        binaryTree.preOrderTraverse();
        binaryTree.inOrderTraverse();
        binaryTree.postOrderTraverse();

        binaryTree.inOrderByStack();
        binaryTree.preOrderByStack();
        binaryTree.postOrderByStack();

    }

}