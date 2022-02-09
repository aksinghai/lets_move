package OldTest;

import java.util.*;
import java.util.stream.Collectors;

class Node {
    int item;
    Node next;

    public Node(int item, Node next) {
        this.item = item;
        this.next = next;
    }
}

public class KthElementFromLast {
    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,7,6,8};
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
        System.out.println(list.stream().filter(i -> i%2 == 0).collect(Collectors.toList()));
        /*int k = 4;
        Node head = createLinkedList(arr);
        Node desired = findKthElementFromLast(head, k);
        System.out.println(desired.item);*/
    }

    private static Node createLinkedList(int[] arr){
        Node head = null;
        Node temp = null;
        for(int i = 0; i < arr.length; i++){
            if(head == null){
                head = new Node(arr[i], null);
                temp = head;
            } else {
                temp.next = new Node(arr[i], null);
                temp = temp.next;
            }
        }
        return head;
    }

    private static Node findKthElementFromLast(Node head, int k){
        if(head == null){
            return null;
        }

        Node first = head;
        Node second = null;
        for(int i = 0; i < k && first != null; i++){
            first = first.next;
        }
        if(first != null){
            second = head;
            while (first != null) {
                first = first.next;
                second = second.next;
            }
        }
        return second;
    }
}
