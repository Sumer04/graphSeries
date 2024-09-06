import java.util.*;
public class minimualLengthToSwapTheArray {
    public static void main(String[] args) {
        int nums[] = {10,19,6,3,5};
        int ans = minimualLengthToSwapTheArray(nums);
        System.out.println(ans);
    }
    public static int minimualLengthToSwapTheArray(int nums[])
  {
     
      boolean visited[] = new boolean[nums.length];
      Pair[] pair= new Pair[nums.length];
      for(int i=0; i<nums.length; i++)
      {
          pair[i] = new Pair(nums[i],i);
      }
      Arrays.sort(pair, Comparator.comparingInt(p -> p.value));
      int ans=0;
    for(int i=0 ;i<nums.length; i++)
    {
        if(visited[i]==true || pair[i].idx==i)
        {
           continue;
        }
        int count=0;
  
        int j=i;
        while(visited[j]==false)
        {
             visited[j]=true;
             count++;
             j = pair[j].idx;
        }
        ans =ans + count-1;
    }
    return ans;
  } 
}

class Pair {
    int value, idx;

    Pair(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}


