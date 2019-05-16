package solution;

/**
 * @ClassName Q21
 * @Description
 * @Author zhihui
 * @Date 2019/3/25 15:40
 * @Version 1.0
 */
public class Q21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
        ListNode c = new ListNode(8);
        a.next = b;
		b.next = c;
        c.next = null;
        ListNode d = new ListNode(0);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(9);
        d.next = e;
		e.next = f;
		f.next = null;
        ListNode listNode = mergeTwoLists(a, d);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result;
        if (l1.val <= l2.val) {
            result = l1;
        } else {
            result = l2;
            l2 = l1;
            l1 = result;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (l1.next == null) {
                    l1.next = l2;
                    break;
                } else if (l1.next.val >= l2.val) {
                    ListNode tmp = l1.next;
                    l1.next = l2;
                    ListNode tmp2 = l2.next;
                    l1.next.next = tmp;
                    l2 = tmp2;
                }
            }
            l1 = l1.next;
        }
        if (l1 == null) l1 = l2;
        return result;
    }
}
