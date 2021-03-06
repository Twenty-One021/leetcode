package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Q94
 * @Description
 * @Author zhihui
 * @Date 2019/5/24 9:30
 * @Version 1.0
 */
public class Q94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        root.left = null;
        root.right = r1;
        r1.left = null;
        r1.right = r2;
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
        System.out.println(inorderIter(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    private static List<Integer> inorderIter(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode rootNode = root;
        List<Integer> result = new ArrayList<>();
        while (rootNode != null || !stack.isEmpty()) {
            while (rootNode != null) {
                stack.addFirst(rootNode);
                rootNode = rootNode.left;
            }
            if (!stack.isEmpty()) {
                TreeNode first = stack.removeFirst();
                result.add(first.val);
                rootNode = first.right;
            }
        }
        return result;
    }
}
