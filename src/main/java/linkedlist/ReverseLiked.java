package linkedlist;

/**
 * 链表的反转
 *
 * @author 86185
 */
public class ReverseLiked {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node = reverseLikedList(node);
        System.out.println(node.value);
    }

    private static Node reverseLikedList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            //将head的下一个node记录
            next = node.next;

            //将head的下一个node引用成null
            node.next = pre;

            //使用pre记录head的值
            pre = node;

            //将head指向next
            node = next;

        }
        return pre;
    }

}

class Node {
    public int value;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public Node(int value){
        this.value = value;
    }


}
