package array;
import java.util.*;
public class top_k_frequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put( nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>( (a,b)->b[1]-a[1]);
        
        for(int i:map.keySet())
        {
            pq.offer(new int[]{i,map.get(i)});
        }
        
        int[] ans=new int[k];
        while(k>0)
        {
            ans[--k]=pq.remove()[0];
        }
        
        
        return ans;

      
    }

    public static void main(String[] args)
    {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
    
}
