class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        Stack<ListNode> s = new Stack<>();
        ListNode temp = head;
        int size = 1;

        while (temp.next != null) {
            s.push(temp);
            temp = temp.next;
            size = size + 1;
        }

        int count = 0;
        k = k % size;

        while (count < k && s.size() > 0) {
            ListNode curr = s.pop();
            curr.next.next = head;
            head = curr.next;
            curr.next = null;
            count++;
        }

        return head;
    }
}
