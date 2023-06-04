package linked_list;

public class reverse_k_pairs {

    static ListNode findk(ListNode n,int k)
    {
        while(n!=null && k>0)
        {
            k--;
            n=n.next;
        }
        return n;
    }

    //first approach by keeping track of the kth and groupprev node and then reversing k-1 links
    static ListNode k_reverse(ListNode head,int k)
    {
        ListNode dummy=new ListNode(0,head),groupprev=dummy,prev,curr,groupnext,kth;
        while(true)
        {
            kth=findk(groupprev,k);
            if(kth==null)
            break;
            groupnext=kth.next;
            
            prev=groupnext;
            curr=groupprev.next;
            while(curr!=groupnext)
            {
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            curr=groupprev.next;
            groupprev.next=kth;
            groupprev=curr;
        }
        return dummy.next;

    }
    public static void main(String[] args)
    {
        
        ListNode head=new ListNode(1),start=head;
        start.next=new ListNode(2);
        start=start.next;
        start.next=new ListNode(3);
        start=start.next;
        start.next=new ListNode(4);
        ListNode.display(head);
        start=k_reverse(head,2);
        ListNode.display(start);
        ListNode.display(head);
        start=reverse(head, 2);
        ListNode.display(start);
    }


    //recursive approach
    static ListNode reverse(ListNode head,int k)
    {
        if(head==null) return null;

        ListNode tail=head;
        for(int i=1;i<=k;i++)
        {
            if(tail==null) return head;
            tail=tail.next;
        }
        //reverse head to tail normally
        ListNode curr=head,prev=null;
        while(curr!=tail)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        ListNode newHead=prev;
        head.next=reverse(tail, k);
        return newHead;
    }
    
}
