package com.hz.yk.math;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 广度优先的遍历，使用了栈的结构，如果找2个人之间的最短路径还可以使用双向广度优先搜索。
 *
 * @author wuzheng.yk
 * @date 2020/7/20
 */
public class Lesson13_1 {

    public static void main(String[] args) {

        int userNum = 10;

        int relation_num = 100;

        Node[] user_nodes = new Node[userNum];

        // 生成所有表示用户的结点
        for (int i = 0; i < userNum; i++) {
            user_nodes[i] = new Node(i);
        }
        Random random = new Random();

        // 生成所有表示好友关系的边
        for (int i = 0; i < relation_num; i++) {
            int friend_a_id = random.nextInt(userNum);
            int friend_b_id = random.nextInt(userNum);
            if (friend_a_id == friend_b_id) {
                continue;
            }
            // 自己不能是自己的好友。如果生成的两个好友id相同，跳过
            Node friend_a = user_nodes[friend_a_id];
            Node friend_b = user_nodes[friend_b_id];

            friend_a.friends.add(friend_b_id);
            friend_b.friends.add(friend_a_id);
        }

        bfs(user_nodes, 1);
    }

    /**
     * @param user_nodes-用户的结点；user_id-给定的用户ID，我们要为这个用户查找好友
     * @return void
     * @Description: 通过广度优先搜索，查找好友
     */

    public static void bfs(Node[] user_nodes, int user_id) {

        if (user_id > user_nodes.length) {
            return;  // 防止数组越界的异常
        }
        // 用于广度优先搜索的队列
        Queue<Integer> queue = new LinkedList<Integer>();
        // 放入初始结点
        queue.offer(user_id);
        // 存放已经被访问过的结点，防止回路
        HashSet<Integer> visited = new HashSet<>();
        visited.add(user_id);

        while (!queue.isEmpty()) {
            // 拿出队列头部的第一个结点
            int currentUserId = queue.poll();
            if (user_nodes[currentUserId] == null) {
                continue;
            }

            // 遍历刚刚拿出的这个结点的所有直接连接结点，并加入队列尾部
            for (int friendId : user_nodes[currentUserId].friends) {
                if (user_nodes[friendId] == null) {
                    continue;
                }
                if (visited.contains(friendId)) {
                    continue;
                }
                queue.offer(friendId);
                visited.add(friendId);
                user_nodes[friendId].degree = user_nodes[currentUserId].degree + 1;    // 好友度数是当前结点的好友度数再加1
                System.out.println(String.format("\t%d度好友：%d", user_nodes[friendId].degree, friendId));
            }
        }

    }

    static class Node {

        public int user_id;    // 结点的名称，这里使用用户id
        public HashSet<Integer> friends = null;
        // 使用哈希映射存放相连的朋友结点。哈希便于确认和某个用户是否相连。
        public int degree;    // 用于存放和给定的用户结点，是几度好友

        // 初始化结点
        public Node(int id) {
            user_id = id;
            friends = new HashSet<>();
            degree = 0;
        }
    }
}



