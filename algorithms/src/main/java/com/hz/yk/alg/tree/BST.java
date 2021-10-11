package com.hz.yk.alg.tree;

import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * @author wuzheng.yk
 * @date 2021/10/4
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    public int size() {
        return size(root);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 向上取整和向下取整
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    public Key min() {
        return min(root).key;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private @Nullable Node deleteMin(@Nonnull Node node) {
        //不断深入根结点的左子树中直至遇见一个空链接，然后将指向该结点的链接指向该结点的右子树
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.subNodeSize = size(node.left) + size(node.right) + 1;
        return node;

    }

    private Node select(Node node, int k) {
        if (node == null || size(node) < k) {
            return null;
        }
        final int leftSize = size(node.left);
        if (leftSize > k) {
            return select(node.left, k);
        } else if (leftSize < k) {
            return select(node.right, k - leftSize - 1);
        } else {
            return node;
        }
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    /**
     * 如果给定的键key小于二叉查找树的根结点的键，那么小于等于key的最大键foor(key)一定在根结点的左子树中；
     * 如果给定的键key大于二叉查找树的根结点，那么只有当根结点右子树中存在小于等于key的结点时，
     * 小于等于key的最大键才会出现在右子树中，否则根结点就是小于等于key的最大键。
     *
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        } else {
            final Node floor = floor(node.right, key);
            if (floor != null) {
                return floor;
            } else {
                return node;
            }
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.subNodeSize = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.subNodeSize;
        }
    }

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        //以该结点为根的子树中结点的个数
        private int subNodeSize;

        public Node(Key key, Value value, int subNodeSize) {
            this.key = key;
            this.value = value;
            this.subNodeSize = subNodeSize;
        }
    }
}
