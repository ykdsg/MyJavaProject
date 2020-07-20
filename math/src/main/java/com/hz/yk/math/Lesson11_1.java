package com.hz.yk.math;

/**
 * 前缀树实现字典查询
 * 前缀树的主要优劣对比：
 * 1.使用前缀树可以高效地进行前缀搜索字符串和插入字符串，时间复杂度为O(length)；
 * 2.使用前缀树可以按字母顺序轻松打印所有字符串，该功能是散列表不易实现的，但前缀树的搜索效率可能不如散列表快；
 * 3.前缀树的缺点在于，需要大量的内存来存储字符串，对于每个节点需要太多的节点指针。倘若关注内存空间上的优化，可以考虑使用三元搜索树。三元搜索树是实现字典的首选结构，其搜索字符串的时间复杂度是O(height)；
 *
 * @author wuzheng.yk
 * @date 2020/7/15
 */
public class Lesson11_1 {

    private static final int CHARACTER_SIZE = 26;

    private TrieNode root;

    public void insert(String key) {
        TrieNode newNode = root;
        int index;

        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';

            if (newNode.children[index] == null) {
                newNode.children[index] = new TrieNode();
            }

            newNode = newNode.children[index];
        }

        newNode.isWordEnd = true;
    }

    public boolean search(String key) {
        TrieNode searchNode = root;
        int index;

        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';

            if (searchNode.children[index] == null) {
                return false;
            }

            searchNode = searchNode.children[index];
        }

        return (searchNode != null && searchNode.isWordEnd);
    }

    public static void main(String[] args) {
        String[] keys = { "my", "name", "is", "hanyonglu", "the", "son", "handongyang", "home", "near", "not",
                          "their" };

        Lesson11_1 trieTest = new Lesson11_1();
        trieTest.root = new TrieNode();

        for (String key : keys) {
            trieTest.insert(key);
        }

        System.out.println("home result : " + trieTest.search("home"));
        System.out.println("their result : " + trieTest.search("their"));
        System.out.println("t result : " + trieTest.search("t"));
    }

    private static class TrieNode {

        private TrieNode[] children;

        private boolean isWordEnd;

        public TrieNode() {
            isWordEnd = false;

            children = new TrieNode[CHARACTER_SIZE];
            for (int index = 0; index < CHARACTER_SIZE; index++) {
                children[index] = null;
            }
        }
    }
}
