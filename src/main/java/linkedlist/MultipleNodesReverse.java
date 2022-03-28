package linkedlist;

/**
 * k个节点的组内逆序调整
 * 给定一个单链表的头节点head,和一个正数k
 * 实现k个节点的小组内部逆序,如果最后一组不够k就不调整
 * 调整前:1->2->3->4->5->6->7->8,k=3
 * 调整后:3->2->1->6->5->4->7->8
 *
 * @author 86185
 */
public class MultipleNodesReverse {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        Node head4 = new Node(4);
        Node head5 = new Node(5);
        Node head6 = new Node(6);
        Node head7 = new Node(7);
        Node head8 = new Node(8);
        head1.next = head2;
        head1.next.next = head3;
        head1.next.next.next = head4;
        head1.next.next.next.next = head5;
        head1.next.next.next.next.next = head6;
        head1.next.next.next.next.next.next = head7;
        head1.next.next.next.next.next.next.next = head8;


        int k = 3;
        System.out.println("======逆序前====");
        System.out.println(head1);
        head1 = reverseGroup(head1, k);
        System.out.println("======逆序后====");

        System.out.println(head1.toString());
    }

    private static Node reverseGroup(Node head, int k) {
        Node start = head;

        Node end = getGroup(start, k);

        if (end == null){
            return head;
        }

        head = end;
        reverse(start,end);

        Node lastEnd = start;
        while (lastEnd.next != null){
            start = lastEnd.next;
            end = getGroup(start,k);
            if (end == null){
                return head;
            }

            reverse(start,end);
            lastEnd.next = end;
            lastEnd = start;
        }



        return head;
    }

    private static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node next = null;
        Node cur = start;

        while (cur != end){
            next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;
        }
        start.next = end;
    }

    private static Node getGroup(Node start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }


}


