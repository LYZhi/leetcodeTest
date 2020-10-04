package leetcode.solution.config;

/**
 * @author LYZhi
 * @date 2020/10/4 15:07
 */
public class ListHelper {

    String[] values ;
    int index ;

    public ListHelper(){

    }
    //创建list链表
    public ListNode creatList(String listValues){
        String[] values = listValues.split(",");
        int index = 0;
        ListNode pre = new ListNode(Integer.parseInt(values[index]));
        ListNode list = pre;
        index++;
        while(values.length>index) {
            list.next= new ListNode(Integer.parseInt(values[index]));
            list = list.next;
            index++;
        }
        return pre;
    }

    //遍历链表
    public void printList (ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
}
