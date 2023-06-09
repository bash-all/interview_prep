package dynamicp;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class permutations 
{

    //using a list to mark the visited indices
    static void generate(int[] a,int i,List<Integer> visit,List<List<Integer>> ans,List<Integer> temp)
    {
        if(visit.size()==a.length)
        {
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int ind=0;ind<a.length;ind++)
        {
            if(visit.contains(ind))
            continue;
            temp.add(a[ind]);
            visit.add(ind);
            generate(a, ind+1, visit, ans, temp);
            temp.remove(temp.size()-1);
            visit.remove(visit.size()-1);
        }

    }

    public static void main(String[] args)
    {
        List<List<Integer>> list=new ArrayList<>();

        //generate(new int[]{1,2,3}, 0, new ArrayList<>(), list, new ArrayList<>());
        sub(new int[]{1,2,3}, 0, list);
        System.out.println(list);
    }

    //same time complexity yet saving space complexity 
    static void sub(int[] a,int ind,List<List<Integer>> list)
    {
        if(ind == a.length) 
        {
            List<Integer> temp=new ArrayList<>();
            for (int i : a) {
                temp.add(i); }
            list.add(new ArrayList<>(temp));
        }

        for(int i=ind;i<a.length;i++)
        {
            swap(a, ind, i);
            sub(a, ind+1, list);
            swap(a, i, ind);
        }

    }

    static void swap(int[] a,int x,int y)
    {
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }


    
}
