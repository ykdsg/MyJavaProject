package com.hz.yk.alg4.tree;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author wuzheng.yk
 * @date 2021/10/14
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    //假设节点node 为红色，node.left和node.left.left都是黑色
    //将node.left或者node.left的子节点之一变红
    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);

        }
        return node;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, BLACK, 1);
        }
        final int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        //如果存在连续的2条左红链接，进行右旋之后就变成左右都是红链接。进入下一个if判断
        if (isRed(node.left) && node.left.left != null && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;

    }

    private boolean isRed(@Nullable Node node) {
        return node != null && node.color == RED;
    }

    /**
     * 左旋，当前节点的右链接是红色，需要改变红链接的指向。
     *
     * @param node
     * @return
     */
    private Node rotateLeft(@NotNull Node node) {
        //右子节点
        Node subRightNode = node.right;
        node.right = subRightNode.left;
        subRightNode.left = node;
        subRightNode.color = node.color;
        node.color = RED;
        subRightNode.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return subRightNode;
    }

    /**
     * 右旋，当前节点的左链接是红色，需要改变红链接的指向。
     *
     * @param node
     * @return
     */
    private Node rotateRight(@NotNull Node node) {
        Node subLeftNode = node.left;
        node.left = subLeftNode.right;
        subLeftNode.right = node;
        subLeftNode.color = node.color;
        node.color = RED;
        subLeftNode.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return subLeftNode;
    }

    /**
     * 当前节点的2个子节点都是红色改为黑色，自身改为红色
     *
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;

    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;     // color of parent link
        /**
         * 以该结点为根的子树中结点的个数
         */
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

}
