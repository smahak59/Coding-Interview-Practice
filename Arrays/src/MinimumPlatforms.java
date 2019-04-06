import java.io.*;
import java.util.Arrays;

/*Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
        Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times must not be same for a train.

        Input:
        The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
        Note: Time intervals are in the 24-hour format(hhmm), preceding zeros are insignificant. 200 means 2:00.
        Consider the example for better understanding of input.

        Output:
        For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

        Constraints:
        1 <= T <= 100
        1 <= N <= 1000
        1 <= A[i] < D[i] <= 2359

        Example:
        Input:
        1
        6
        900  940 950  1100 1500 1800
        910 1200 1120 1130 1900 2000

        Output:
        3

        Explanation:
        Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.
*/
        public class MinimumPlatforms {
            public static void main (String[] args) throws IOException {
                //code
                BufferedReader br  = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./MinimumPlatformsInput"))));
                int testCase = Integer.parseInt(br.readLine());
                while(testCase>0){
                    int num = Integer.parseInt(br.readLine());
                    String arrivalTimes[] = br.readLine().split(" ");
                    String departureTimes[] = br.readLine().split(" ");
                    Train trainsArrival[] = new Train[num];
                    Train trainsDeparture[] = new Train[num];
                    //int arr1[] = new int[num];
                    int i = 0;
                    for(i = 0 ; i<num;i++){
                        trainsArrival[i] = new Train(Integer.parseInt(arrivalTimes[i]),i);
                    }
                    for(int j = 0; j<num;j++,i++){
                        trainsDeparture[j] = new Train(Integer.parseInt(departureTimes[j]),j);
                    }
                    Arrays.sort(trainsArrival);
                    Arrays.sort(trainsDeparture);
                    int plat_needed = 1, result = 1;
                    int arr = 1, dep = 0;

                    // Similar to merge in merge sort to process
                    // all events in sorted order
                    while (arr < num && dep < num)
                    {
                        // If next event in sorted order is arrival,
                        // increment count of platforms needed
                        if (trainsArrival[arr].time < trainsDeparture[dep].time)
                        {
                            plat_needed++;
                            arr++;

                            // Update result if needed
                            if (plat_needed > result)
                                result = plat_needed;
                        }

                        // Else decrement count of platforms needed
                        else if(trainsArrival[arr].time > trainsDeparture[dep].time)
                        {
                            plat_needed--;
                            dep++;
                        }
                        else{
                            if(trainsArrival[arr].index==trainsDeparture[dep].index){
                                plat_needed++;
                                arr++;
                                if (plat_needed > result)
                                    result = plat_needed;
                            }
                            else{
                                plat_needed--;
                                dep++;
                            }
                        }
                    }

                    System.out.println(result);
/*
                    while (arr < num && dep < num)
                    {
                        // If next event in sorted order is arrival,
                        // increment count of platforms needed
                        if (trainsArrival[arr] <= trainsDeparture[dep])
                        {
                            plat_needed++;
                            arr++;

                            // Update result if needed
                            if (plat_needed > result)
                                result = plat_needed;
                        }

                        // Else decrement count of platforms needed
                        else
                        {
                            plat_needed--;
                            dep++;
                        }
                    }

                   System.out.println(result);*/
                    testCase--;
            }

        }
        }

class Train implements Comparable<Train> {
    int time;

    int index;

    Train(int time,  int index) {
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Train o) {

        if (this.time >= o.time) {
            return 1;
        } else if (this.time < o.time) {
            return -1;
        }
       /* else if(this.time == o.time)
        {
            if(this.index == o.index)
                return 1;
            else
                return -1;
        }*/
        return 0;

    }
}

