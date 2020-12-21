
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
public class niuke_3 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    @Test
    public void test3(){
        //创建单链表
        ListNode head = new ListNode(0);
        ListNode pre = head, next;
        for(int i = 1; i < 10; i++){
            next = new ListNode(i);
            pre.next = next;
            pre = next;
        }
        pre.next = null;

        ArrayList<Integer> list1 = print_1(head), list2 = print_2(head), list3 = print_3(head);

        //for循环遍历
        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i)+"\t");
        }
        System.out.println();

        //迭代器进行遍历
        Iterator<Integer> it = list2.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+"\t");
        }
        System.out.println();

        //增强型for循环遍历
        for(Integer i : list3){
            System.out.print(i+"\t");
        }
    }

    public ArrayList<Integer> print_1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
        Stack<Integer> st = new Stack<>();
        while(listNode != null){
            st.push(listNode.val);
            listNode = listNode.next;
        }
        while(!st.isEmpty()) list.add(st.pop());
        return list;
    }

    public ArrayList<Integer> print_2(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
        while(listNode != null){
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public ArrayList<Integer> print_3(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
        //将链表进行反向操作，首指针变为pre
        ListNode pre = null, cur = listNode, next;
        while(cur != null){
            next = cur.next;
            cur.next = pre; //反向
            pre = cur;
            cur = next;
        }
        while(pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
}
