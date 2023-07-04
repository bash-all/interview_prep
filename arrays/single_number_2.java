class Solution {


  //hashmap approach O(n)
  public int singleNumber2(int[] nums) {
        
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
            
        }
        for(int i:map.keySet()) if(map.get(i)==1) return i;
        return -1;
        
    }


  //bit manipulation approach  O(n)
    public int singleNumber(int[] nums) {
        
        int ones=0,twos=0;
        
        for(int i:nums)
        {
            ones=(ones^i)& ~twos;
            twos=(twos^i)&~ ones;
        }
        return ones;
    }
}
