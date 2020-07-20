package com.hz.yk.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 前缀树构造词典，比如Lesson11的实现更优雅一点，且通过栈的方式遍历了词典
 *
 * @author wuzheng.yk
 * @date 2020/7/16
 */
public class Lesson12_1 {

    private TreeNode rootNode;

    public static void main(String[] args) {
        String[] keys = { "my", "name", "is", "hanyonglu", "the", "son", "handongyang", "home", "near", "not", "their",
                          "no" };

        TreeNode rootNode = new TreeNode(' ', null, null);
        Lesson12_1 treeNodeDemo = new Lesson12_1(rootNode);
        for (String key : keys) {
            treeNodeDemo.insert(key);
        }
        System.out.println(treeNodeDemo.search("m"));
        System.out.println(treeNodeDemo.search("name"));
        System.out.println(treeNodeDemo.search("no"));

        System.out.println("------------遍历字典-------------");
        traverse(rootNode);

    }

    public Lesson12_1(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public boolean search(String key) {
        TreeNode searchNode = rootNode;
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            if (!searchNode.sons.containsKey(currentChar)) {
                return false;
            } else {
                searchNode = searchNode.sons.get(currentChar);
            }
        }
        return searchNode != null && searchNode.isCompleteWords();
    }

    /**
     * 遍历所有单词
     *
     * @param rootNode
     */
    public static void traverse(TreeNode rootNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(rootNode);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            if (node.isCompleteWords()) {
                System.out.println(node.prefix + node.label);
            }
            if (node.sons.size() != 0) {
                for (Map.Entry<Character, TreeNode> nodeEntry : node.sons.entrySet()) {
                    nodeStack.push(nodeEntry.getValue());
                }
            }
        }

    }

    public void insert(String str) {
        TreeNode currentNode = rootNode;
        String pre;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!currentNode.sons.containsKey(currentChar)) {
                TreeNode charNode = new TreeNode(currentChar, str.substring(0, i), null);
                currentNode.sons.put(currentChar, charNode);
            }
            currentNode = currentNode.sons.get(currentChar);
        }
        currentNode.explanation = "词条解释：" + str;
    }

    static class TreeNode {

        public char label;  // 结点的名称，在前缀树里是单个字母
        public HashMap<Character, TreeNode> sons = null; // 使用哈希映射存放子结点。哈希便于确认是否已经添加过某个字母对应的结点。
        public String prefix = null;   // 从树的根到当前结点这条通路上，全部字母所组成的前缀。例如通路b->o->y，对于字母o结点而言，前缀是b；对于字母y结点而言，前缀是bo
        public String explanation = null;  // 词条的解释

        // 初始化结点
        public TreeNode(char l, String pre, String exp) {
            label = l;
            prefix = pre;
            explanation = exp;
            sons = new HashMap<>();

        }

        /**
         * 是否一个完整的单词，根据是否有词条解释来判断
         *
         * @return
         */
        public boolean isCompleteWords() {
            return explanation != null;
        }

        /**
         * 是否已经结束
         *
         * @return
         */
        public boolean isEnd() {
            return sons == null || sons.size() == 0;
        }
    }
}

