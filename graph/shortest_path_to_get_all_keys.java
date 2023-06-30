package graph;
import java.util.*;


public class shortest_path_to_get_all_keys {
    
    int bfs(char[][] mat,int i,int j,int row,int col,int keys)
    {
        int[][] dis={ {1,0},{0,1},{-1,0},{0,-1}};         
        Deque<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j,0,0});//i,j,mask,distance
        Map<Integer,Set<Integer>> map=new HashMap<>();
        map.computeIfAbsent(0,v->new HashSet<>()).add(i*row+j);
       
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            int x=curr[0],y=curr[1],mask=curr[2],distance=curr[3];
            
            
            for(int[] a:dis)
            {
                int next1=x+a[0],next2=y+a[1];
                
                if(next1<0 || next2<0 || next1==row || next2==col || 
                   mat[next1][next2]=='#')
                    continue;
                
                
                char ch=mat[next1][next2];
                if(ch>='a' && ch<='f' && (1<<(ch-'a')&mask)!=0) continue;
                //if its a key not picked already
                else if(ch>='a' && ch<='f' && (1<<(ch-'a')&mask)==0)
                {
                    int temp=(mask| (1<<(ch-'a')));
                    if(Integer.bitCount(temp)==keys) return distance+1;
                map.computeIfAbsent(temp,v->new HashSet<>())
                                               .add(next1*col+next2);
                q.add(new int[]{next1,next2,temp,distance+1});
               
                    
                }
                
                if(ch>='A' && ch<='F'&& 
                   ( ((mask & (1<<(ch-'A') ))==0 )))
                    continue;
            
                else if(!map.get(mask).contains(next1*col+next2))
                {
                    q.add(new int[]{next1,next2,mask,distance+1});
                    map.get(mask).add( next1*col+next2);
                }
                
            }
            
        }
        return -1;
    }
    public int shortestPathAllKeys(String[] grid) {
        int startx=0,starty=0;
        int row=grid.length,col=grid[0].length();
        char[][] mat=new char[row][col];
        int target=0,k=0;
        for(String s:grid)
        {
            mat[k]=s.toCharArray();
            for(int j=0;j<col;j++)
            {
                if(mat[k][j]=='@')
                {
                    startx=k;starty=j;
                }
                else if(mat[k][j]>='a' && mat[k][j]<='f') 
                    target++;
            }
            k++;
        }
        
        return bfs(mat,startx,starty,row,col,target);
    }
}

