package Others.DFS_BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 多叉树结构的定义
class TreeNode{
    int val;
    List<TreeNode> children;

    public TreeNode() {
    }
    public TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }
}


public class DFS_BFS {
    // 多叉树遍历（迭代栈DFS） 测试用的方法
    public static void Test(TreeNode root){
        if (root == null) return;  //为空直接返回
        Stack<TreeNode> treeStack = new Stack<>();  // 定义一个栈
        treeStack.push(root);  // root入栈
        while (!treeStack.empty()){
            TreeNode node = treeStack.pop();  // 栈顶出栈
            System.out.println(node.val);  // 打印值
            if (node.children != null && !node.children.isEmpty()){  // 进行list的非空判断
                for (TreeNode child : node.children) {  // 遍历子树，并依次入栈
                    treeStack.push(child);
                }
            }

        }

    }

    // 多叉树遍历（递归） 测试用的方法
    public static void Test2(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            for (TreeNode child : root.children) {
                Test2(child);
            }
        }
    }
    // 多叉树遍历 （队列BFS迭代）测试用的方法
    public static void Test3(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                for (TreeNode child : node.children) {
                    queue.add(child);
                }
            }
        }
    }

    // 定义了1到8的测试用例
    public static void main(String[] args) {
        TreeNode tree8 = new TreeNode(8,null);
        TreeNode tree7 = new TreeNode(7,null);
        TreeNode tree6 = new TreeNode(6,null);
        TreeNode tree5 = new TreeNode(5,null);

        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(tree8);
        list.add(tree7);
        ArrayList<TreeNode> list2 = new ArrayList<>();
        list2.add(tree6);
        list2.add(tree5);

        TreeNode tree4 = new TreeNode(4, null);
        TreeNode tree3 = new TreeNode(3, list);
        TreeNode tree2 = new TreeNode(2, list2);

        ArrayList<TreeNode> list3 = new ArrayList<>();
        list3.add(tree2);
        list3.add(tree3);
        list3.add(tree4);

        TreeNode treeRoot = new TreeNode(1, list3);

        Test3(treeRoot);
    }
}
