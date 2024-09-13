import java.util.Arrays;
import java.util.Comparator;

public class KnapsackProblem {
    public static void main(String[] args) {
        Activity arr[] = {
            new Activity(50, 600),
            new Activity(20, 500),
            new Activity(30, 400)
        };
        int capacity = 70;
        double max_profit = KnapsackProblem(arr, capacity);
        System.out.println("Maximum Profit: " + max_profit);
    }

    public static double KnapsackProblem(Activity arr[], int capacity) {
        Arrays.sort(arr, new MyCmp());
        
        double res = 0.0;
        int curr_cap = capacity;

        for (int i=0; i<arr.length; i++) {
            if (arr[i].weight <= curr_cap) {
                curr_cap -= arr[i].weight;
                res += arr[i].value;
            } else {
                res += arr[i].value * ((double) curr_cap / arr[i].weight);
                break;
            }
        }
        
        return res;
    }
}

class Activity {
    int weight;
    int value;

    Activity(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class MyCmp implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
       
        double ratio1 = (double) a1.value / a1.weight;
        double ratio2 = (double) a2.value / a2.weight;
        return Double.compare(ratio2, ratio1);
    }
}
