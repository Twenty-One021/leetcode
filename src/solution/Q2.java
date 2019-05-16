/**
 * 
 */
package solution;

/**
 * @Description 
 * @author zhihui
 * @date 2019年3月15日 下午5:41:50
 *
 */
public class Q2 {

	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {this.val = val;}
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
//		ListNode b = new ListNode(4);
		ListNode c = new ListNode(8);
		a.next = c;
//		b.next = c;
		c.next = null;
		ListNode d = new ListNode(0);
//		ListNode e = new ListNode(6);
//		ListNode f = new ListNode(9);
		d.next = null;
//		e.next = f;
//		f.next = null;
		System.err.println("start: " + System.currentTimeMillis());
		ListNode addListNode = addListNode(a, d);
		ListNode reverse = reverse(addListNode);
		ListNode tmp = reverse;
		System.err.println("end: " + System.currentTimeMillis());
		while (tmp != null) {
			System.out.print(tmp.val);
			tmp = tmp.next;
		}
	}
	
	public static ListNode reverse(ListNode listNode) {
		ListNode tmp;
		ListNode res = null;
		ListNode cursor = listNode;
		while (cursor != null) {
			tmp = new ListNode(cursor.val);
			tmp.next = res;
			res = tmp;
			cursor = cursor.next;
		}
		return res;
	}
	
	public static ListNode addListNode(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tail = null;
        res.next = tail;
        ListNode tmpNode;
		ListNode cursor1 = l1;
		ListNode cursor2 = l2;
        int overflow = 0;
        int digit;
        while (cursor1 != null && cursor2 != null) {
        	digit = (cursor1.val + cursor2.val + overflow) % 10;
        	overflow = (cursor1.val + cursor2.val + overflow) / 10;
            tmpNode = new ListNode(digit);
            tail = res.next;
            res.next = tmpNode;
            tmpNode.next =tail;
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
            
        }
        ListNode remain;
        if (cursor1 == null) {
        	remain = cursor2;
        } else {
        	remain = cursor1;
        }
        while (remain != null) {
        	digit = (remain.val + overflow) % 10;
        	overflow = (remain.val + overflow) / 10;
        	ListNode up = new ListNode(digit);
        	tail = res.next;
        	res.next = up;
        	up.next = tail;
            remain = remain.next;
        }
        if (overflow != 0) {
        	ListNode up = new ListNode(overflow);
        	tail = res.next;
        	res.next = up;
        	up.next = tail;
        }
        return res.next;
	}

}
