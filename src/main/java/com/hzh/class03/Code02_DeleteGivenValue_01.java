package com.hzh.class03;

/**
 * 删除链表中指定位置的值
 *
 * @author 86185
 */
public class Code02_DeleteGivenValue_01 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // head = removeValue(head, 2);

    /**
     * 删除链表上的指定值
     *
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue(Node head, int num) {
        //待删除的是头结点
        while (head!=null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }

        //代删除的不是头结点
        Node pre = head;
        Node cur = head;

        while (cur!=null){
            if (cur.value == num){
                pre.next = cur.next;
            }else
            {
                pre = cur;
            }

            cur = cur.next;
        }
        return head;
    }


}
