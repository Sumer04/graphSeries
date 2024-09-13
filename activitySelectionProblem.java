import java.util.*;

public class activitySelectionProblem {
    public static void main(String[] args) {
     Activity arr[] = {
        new Activity(2, 3),
        new Activity(1, 4),
        new Activity(5, 8),
        new Activity(6, 10),
     };
     int res  = ActivitySelectionProblem(arr);
     System.out.println(res);
    }
    public static int ActivitySelectionProblem(Activity arr[])
    {

        Arrays.sort(arr,new MyCmp());
        System.out.println(Arrays.toString(arr));
        int res =1;
        int prev =0;
        for(int i =1; i<arr.length; i++)
        {
            System.out.println(arr[i].startTime);
            System.out.println(arr[i].finishTime);
            if(arr[i].startTime>=arr[prev].finishTime)
            {
                res++;
                prev=i;
            }
        }
        return res;
    }
}
class Activity{
    int startTime;
    int finishTime;
    Activity(int startTime, int finishTime)
    {
        this.startTime=startTime;
        this.finishTime = finishTime;
    }
}
class MyCmp implements Comparator<Activity>{
  public int compare(Activity arr,Activity arr2){
     return arr.finishTime -arr2.finishTime;
  }
}