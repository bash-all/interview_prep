/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse 
order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/

class Node
{
    int val;
    Node next;
    Node(int d)
    {
        val=d;
    }
}
public class two_numbers 
{
    
    static Node add2(Node l1,Node l2)
    {
        Node start=new Node(0);
        Node head=start;
        int sum=0,carry=0;
        int v1=0,v2=0;
        while(l1!=null  || l2!=null )
        {
            if(l1!=null) 
            { v1=l1.val;
             l1=l1.next;
            }
            if(l2!=null) 
            {  v2=l2.val; l2=l2.next;
            }
                
            sum = v1 + v2 + carry ;
            carry = sum/10 ;
            sum= sum%10 ;
            head.next=new Node(sum);
            head=head.next;
            v1=v2=0;     
            
        }
        if(carry==1) head.next=new Node(carry);
        
        return start.next;
    }
    static void display(Node head)
    {
        Node p=head;
        while(p!=null)
        {
            System.out.print(p.val+",");
            p=p.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //[9],[1,9,9,9,9,9,9,9,9,9
        //[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[5,6,4]
        Node head=null;
        Node n=new Node(1);
        head=n;
       
        n=n.next;
        n.next=new Node(1);

        Node h2=null;
        Node n2=new Node(5);
        h2=n2;
        n2.next=new Node(6);
        n2=n2.next;
        n2.next=new Node(4);
        n2=n2.next;


        
        n2=n2.next;
        display(head);
        display(h2);
        n=add2(head,h2);
        display(n);

    }

    
}
