import java.util.*;
import java.util.Scanner;
class Process 
{ 
    int pid; // Process ID 
    int bt; // Burst Time 
    int art; // Arrival Time 
      
    public Process(int   pid, int  art, int  bt) 
    { 
        this.pid = pid; 
        this.bt = bt; 
        this.art = art; 
    } 
} 

  
public class ASSIGNMENT3_SRT
{ 
    // Method to find the waiting time for all 
    // processes 
    static void findWaitingTime(Process proc[], int n, 
                                     int wt[]) 
    { 
        int rt[] = new int[n]; 
       
        // Copy the burst time into rt[] 
        for (int i = 0; i < n; i++) 
            rt[i] = proc[i].bt; 
       
        int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
        int shortest = 0, finish_time; 
        boolean check = false; 
       
        // Process until all processes gets 
        // completed 
        while (complete != n) { 
       
            // Find process with minimum 
            // remaining time among the 
            // processes that arrives till the 
            // current time` 
            for (int j = 0; j < n; j++)  
            { 
                if ((proc[j].art <= t) && 
                  (rt[j] < minm) && rt[j] > 0) { 
                    minm = rt[j]; 
                    shortest = j; 
                    check = true; 
                } 
            } 
       
            if (check == false) { 
                t++; 
                continue; 
            } 
       
            // Reduce remaining time by one 
            rt[shortest]--; 
       
            // Update minimum 
            minm = rt[shortest]; 
            if (minm == 0) 
                minm = Integer.MAX_VALUE; 
       
            // If a process gets completely 
            // executed 
            if (rt[shortest] == 0) { 
       
                // Increment complete 
                complete++; 
                check = false; 
       
                // Find finish time of current 
                // process 
                finish_time = t + 1; 
       
                // Calculate waiting time 
                wt[shortest] = finish_time - 
                             proc[shortest].bt - 
                             proc[shortest].art; 
       
                if (wt[shortest] < 0) 
                    wt[shortest] = 0; 
            } 
            // Increment time 
            t++; 
        } 
    } 
       
    // Method to calculate turn around time 
    static void findTurnAroundTime(Process proc[], int n, 
                            int wt[], int tat[]) 
    { 
        // calculating turnaround time by adding 
        // bt[i] + wt[i] 
        for (int i = 0; i < n; i++) 
            tat[i] = proc[i].bt + wt[i]; 
    } 
       
    // Method to calculate average time 
    static void findavgTime(Process proc[], int n) 
    { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int  total_wt = 0, total_tat = 0; 
       
        // Function to find waiting time of all 
        // processes 
        findWaitingTime(proc, n, wt); 
       
        // Function to find turn around time for 
        // all processes 
        findTurnAroundTime(proc, n, wt, tat); 
       
        // Display processes along with all 
        // details 
        System.out.println("Processes " + " Arival time " + "  Burst Time"+ "      Waiting time " +  "     Turn around time"); 
       
        // Calculate total waiting time and 
        // total turnaround time 
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.println(" " + proc[i].pid + "\t\t"+ proc[i].art+ "\t\t"+proc[i].bt + "\t\t " + wt[i]  + "\t\t" + tat[i]); 
        } 
       
        System.out.println("Average waiting time = " + (float)total_wt / (float)n); 
        System.out.println("Average turn around time = " + (float)total_tat / (float)n); 
    } 
      
    // Driver Method
 
    public static void main(String[] args)  throws Exception {
    
	java.io.File file =new java.io.File("C:\\Users\\Dell\\Desktop\\sucess\\inpset4.txt");
	Scanner input = new Scanner(file);
	while(input.hasNext())
{

int at1  	= input.nextInt();
int bt1	= input.nextInt();  	
int at2 	= input.nextInt();
int bt2	= input.nextInt();  	
int at3 	= input.nextInt();
int bt3	= input.nextInt();  	
int at4 	= input.nextInt();
int bt4	= input.nextInt();  	
int at5 	= input.nextInt();
int bt5	= input.nextInt(); 	

         Process proc[] = { new Process(1,at1,bt1),  
                                         new Process(2,at2,bt2), 
                                         new Process(3,at3,bt3),
                                         new Process(4,at4,bt4),
                                       new Process(5,at5,bt5),
}; 
        
         findavgTime(proc, proc.length); 

}
input.close();
    } 

}
 