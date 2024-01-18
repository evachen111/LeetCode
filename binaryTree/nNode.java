package binaryTree;

public class nNode {
    public int val;
    public nNode left;
    public nNode right;
    public nNode next;

    public nNode() {}

    public nNode(int _val) {
        val = _val;
    }

    public nNode(int _val, nNode _left, nNode _right, nNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
