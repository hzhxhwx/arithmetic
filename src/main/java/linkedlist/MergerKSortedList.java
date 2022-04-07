package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 86185
 * 合并k和有序链表
 * 使用小顶堆
 * [1,4,5],[1,3,4],[2,6]
 */
public class MergerKSortedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode[] lists = {node1, node2, node3};
        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new NodeComparator());
        for (ListNode node : lists) {
            heap.add(node);
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next!=null){
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();

            pre.next = cur;

            pre = cur;

            if (cur.next!=null){
                heap.add(cur.next);
            }
        }

        return head;
    }


}

class NodeComparator implements Comparator<ListNode>{

    @Override
    public int compare(ListNode o1, ListNode o2) {

        return o1.val - o2.val;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}