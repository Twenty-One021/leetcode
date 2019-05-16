package solution;

/**
 * @ClassName Q23
 * @Description
 * @Author zhihui
 * @Date 2019/4/1 16:18
 * @Version 1.0
 */
public class Q23 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = null;
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;
        f.next = null;
        ListNode g = new ListNode(2);
        ListNode h = new ListNode(6);
        g.next = h;
        h.next = null;

        ListNode[] lists = {a, d, g};
        ListNode listNode = listMerge(new ListNode[] {null, null});
        System.out.println("----------result----------");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode listMerge(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode result = new ListNode(0);
        ListNode tail = result;
        ListNode temp;
        result.next = tail;
        while ((temp = min(lists)) != null) {
            tail.next = temp;
            tail = tail.next;
        }
        if (result.next == result) return null;
        return result.next;
    }

    private static ListNode min(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode result = null;
        int loc = 0;
        for (int index = 0; index < lists.length; index++) {
            if (lists[index] == null) continue;
            if (result == null || result.val > lists[index].val) {
                result = lists[index];
                loc = index;
            }
        }
        if (result != null)
            lists[loc] = result.next;

        for (ListNode node : lists) {
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
        System.out.println("----------separator----------");
        return result;
    }
}
