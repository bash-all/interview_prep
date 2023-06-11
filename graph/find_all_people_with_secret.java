class Solution {
    public List<Integer> findAllPeople(int n, int[][] meet, int first) {
        
      //create hashmap for edges and their weights
        Map<Integer,List<int[]>> adj=new HashMap<>();
        
        for(int[] i:meet)
        {
            adj.computeIfAbsent(i[0],v->new ArrayList<>()).add(new int[]{i[1],i[2]});
            adj.computeIfAbsent(i[1],v->new ArrayList<>()).add(new int[]{i[0],i[2]});
        }
        
      //to traverse current nodes and keep track of minimum time
        Deque<int[]> q=new LinkedList<>();
        int[] time=new int[n];
        Arrays.fill(time,100001);
        
      //answer with all nodes
        Set<Integer> vis=new HashSet<>();
        
        
        q.add(new int[]{first,0});
        q.add(new int[]{0,0});
        time[0]=0;
        time[first]=0;
        vis.add(first);
        vis.add(0);
        while(!q.isEmpty())
        {
            int curr=q.peek()[0];
            int currtime=q.remove()[1];
            if(time[curr]<currtime) continue;
            if(adj.containsKey(curr))
            {
            for(int[] i:adj.get(curr))
            {
                int person=i[0],reqtime=i[1];
                if(reqtime<currtime || time[person]<=reqtime) continue;
                
                vis.add(person);
                q.add(new int[]{person,reqtime});
                time[person]=reqtime;
            }
            }
        }
      
        return new ArrayList<>(vis);
        
    }
}
