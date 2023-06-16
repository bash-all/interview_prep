package array;

import java.util.*;

public class triplets_with_bitwise_and_equal_to_zero {

    //tle
    static int countTriplets(int[] nums) {
        int n=nums.length;
        Map<Integer,List<int[]>> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            { 
                map.computeIfAbsent((nums[i] & nums[j]) ,v->new ArrayList<>()).add(new int[]{i,j});
            }
        }
        int ans=0;
        System.out.println(map);
        Set<List<Integer>> vis=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j:map.keySet())
            {
                if( (nums[i]&j )!=0) continue;
                
                for(int[] p:map.get(j))
                {
                    int val1=Math.min(p[0], i),val3= Math.max(p[1],i),val2=p[0]+p[1]+i-val1-val3;
                    
                    List<Integer> temp=List.of(val1,val2,val3);
                    if(vis.contains(temp)) continue;
                    
                    else
                    {
                        if(val1==val2 && val2==val3) ans++;
                        else if(val1==val2 || val2==val3) ans+=3;
                        else ans+=6;
                    }
                    vis.add(temp);
                }
                
            }
        }
        
        return ans; 
        
    }

    public static void main(String[] args)
    {
        System.out.println(countTriplets2(new int[]{2,1,2,3}));
    }


    //simple O(n^2) approach 
    static int countTriplets2(int[] nums) {
        
        Map<Integer,Integer> map=new HashMap<>();
     
        for(int i:nums)
        {
            for(int j:nums)
            {
                map.put(i&j,map.getOrDefault( (i&j),0)+1);
            }
        }
        
        int ans=0;
        for(int i:nums)
        {
            for(int j:map.keySet())
            {
                if( (j&i)==0) ans+=map.get(j);
            }
        }
        
        return ans;
        
    }
    
}
