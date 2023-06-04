package linked_list;
class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }
public class remove_nth_fromend {
    static Node insert(Node h,int v)
    {
        Node head=h;
        Node n=new Node(v);
        if(h==null)
        {
            h=n;
        }
        else
        {
            while(h.next!=null)
            h=h.next;
            //display(head);
            
            h.next=n;
        }
        return head;
    }

    static Node del(Node head,int n)
    {
        Node h=head;
        int l=0;
        if(h.next==null)
        {
        head=null;
        return head;
        }
        while(h!=null)
        {
            h=h.next;
            l++;
        }
        h=head;
        l=l-n;
        if(l==0)
        {
            head=head.next;
            return head;
        }
        while(l-->1)
        {
            h=h.next;
        }
        h.next=h.next.next;
        return head;


    }
    static void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" -> ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Node h=new Node(1);
        h=insert(h,2);
        h=insert(h,3);
        // h=insert(h,4);
        // h=insert(h,5);
        display(h);
        h=del2(h, 3);
        display(h);
    }

    static Node del2(Node h,int n)
    {
        Node head=h;
        Node fast=h,slow=h;
        if(h.next==null)
        {
            return null;
        }
        while(n-->0)
        fast=fast.next;
        if(fast==null)
        {
            h=h.next;
            return h;
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;

    }
    
}
