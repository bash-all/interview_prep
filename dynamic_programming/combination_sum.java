import java.util.ArrayList;
import java.util.List;

public class combination_sum {

    static  void find(int[] a, int target, List<Integer> temp,List<List<Integer>> list,int i) {

        if(target<0) return;
        if(i==a.length)
        {
            if(target==0) 
            list.add(new ArrayList<>(temp));
           // System.out.println(list);
            return;
        }
        //take the element
        temp.add(a[i]);
        find(a, target-a[i], temp, list, i);
        temp.remove(temp.size()-1);
        find(a, target, temp, list, i+1);
        
    }

    public static void main(String[] args)
    {
        List<List<Integer>> list=new ArrayList<>();
        find(new int[]{2,3,6,7}, 7, new ArrayList<>(), list, 0);
        // build(0, 7, list, new ArrayList<>(), new int[]{2,3,6,7});
        //only on sorted array
        System.out.println(list);
    }
    //include every element only once and no duplicate subsequences

    static void build(int i,int t,List<List<Integer>> list,List<Integer> temp,int[] a)
    {
        if(t <0) return;
        if(t==0) list.add(new ArrayList<>(temp));

        for(int start=0;start<a.length;start++)
        {
            if(start>i && a[start]==a[start-1]) continue;
            if(a[start]>t) break;

            temp.add(a[start]);
            build(start+1, t-a[start], list, temp, a);
            temp.remove(temp.size()-1);
        }
    }


    
}
