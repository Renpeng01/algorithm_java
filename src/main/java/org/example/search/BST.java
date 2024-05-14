package org.example.search;

import edu.princeton.cs.algs4.Queue;
import org.w3c.dom.Node;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) return 0;
            else return x.N;
        }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.value;
            else if (cmp < 0) return get(x.left, key);
            else return get(x.right, key);
        }

        public void put(Key key, Value value) {
            root = put(root, key, value);
        }

        private Node put(Node x, Key key, Value value) {
            if (x == null) return new Node(key, value, 1);
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = put(x.left, key, value);
            else if (cmp > 0) x.right = put(x.right, key, value);
            else x.value = value;
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public Key min() {
            return min(root).key;
        }

        private Node min(Node x) {
            if (x.left == null) return x;
            else return min(x.left);
        }

        public Key max() {
            return max(root).key;
        }

        private Node max(Node x) {
            if (x.right == null) return x;
            else return max(x.right);
        }

        // 这个方式多理解下
        // 向下取整
        private Node floor(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node y = floor(x.right, key);
            if (y != null) return y;
            else return x;
        }

        public Key select(int k) {
            return select(root, k).key;  // 不严谨  缺少select(root, k) 返回null的判断
        }

        private Node select(Node x, int k) {
            if (x == null) return null;

            int t = size(x.left);
            if (t > k) return select(x.left, k);
            else if (t < k) return select(x.right, k - t - 1);
            else return x;
        }

        public int rank(Key key) {
            return rank(root, key);
        }

        private int rank(Node x, Key key) {
            if (x == null) return 0;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return rank(x.left, key);
            else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
            else return size(x.left);
        }

        private void deleteMin() {
            root = deleteMin(root);// 这里的root的赋值是必须的，因为有可能删除的就是root，所以需要更新root
        }

        private Node deleteMin(Node x) {
            if (x.left == null) return x.right;
            x.left = deleteMin(x.left);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void delete(Key key) {
            root = delete(root, key);
        }

        private Node delete(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = delete(x.left, key);
            else if (cmp > 0) x.right = delete(x.right, key);
            else {
                if (x.right == null) return x.left;
                if (x.left == null) return x.right;
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public Iterable<Key> keys() {
            return keys(min(), max());
        }

        public Iterable<Key> keys(Key lo, Key hi) {
            Queue<Key> queue = new Queue<>();
            keys(root, queue, lo, hi);
        }

        private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
            if (x == null) return;
            int cmplo = lo.compareTo(key);
            int comhi = hi.compareTo(key);

            if (cmplo < 0) {
                keys(x.left, queue, lo, hi);
            }
            if (cmplo <= 0 && comhi >= 0) {
                queue.enqueue(x.key);
            }
            if (comhi > 0) {
                keys(x.right, queue, lo, hi);
            }
        }
    }
}
