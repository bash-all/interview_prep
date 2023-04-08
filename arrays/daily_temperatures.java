import java.util.Stack;

public class daily_temperatures {

    //not efficient due to resizing of stack involved
    static int[] dailyTemperatures(int[] t) {
        
        Stack<Integer> s=new Stack<>();
        
        int[] ans=new int[t.length];
        s.push(t.length-1);
        for(int i=t.length-2;i>=0;i--)
        {
                while(!s.isEmpty() && t[s.peek()]<=t[i])
                {
                    s.pop();
                }
                if(s.isEmpty())
                {
                    ans[i]=0;
                    s.push(i);
                }
                else
                {
                ans[i]=s.peek()-i;
                s.push(i);
                }
        }
        return ans;
        
    }

    public static void main(String[] args)
    {
        int[] a={73,74,75,71,69,72,76,73};
        int[] b=daily3(a);
        for (int i : b) {
            System.out.print(i+",");
        }
        System.out.println();

    }

    //faster stack approach
    static int[] daily2(int[] a)
    {
        int[] ans=new int[a.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<a.length;i++)
        {
            while(!s.empty() && a[i]>a[s.peek()])
            {
                int id=s.pop();
                ans[id]=i-id;
            }
            s.push(i);

        }
        return ans;
    }


    //fastest approach
    //get rid of stack in built structure to get rid of dynamic resizing and popping
    static int[] daily3(int[] a)
    {
        int l=a.length;
        int[] stack=new int[l];
        int top=-1;
        int[] ans=new int[l];
        for(int i=0;i<=l-1;i++)
        {
            while(top>-1 && a[stack[top]]<a[i])
            {
                int id=stack[top--];
                ans[id]=i-id;

            }
            stack[++top]=i;

        }
        return ans;
    }
    
}
