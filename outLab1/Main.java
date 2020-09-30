package outLab1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        // C:\\Users\\aramj\\OneDrive\\Java 232 Projects (OneDrive)\\Text Files\\data1.txt  // Laptop file location
        // C:\\Users\\Ara\\OneDrive\\Java 232 Projects (OneDrive)\\Text Files\\data1.txt    // Desktop file location

        String file_directory = Arrays.toString(args).replace(",", "")
                .replace("[", "").replace("]", "");      // format the file correctly
        File file = new File(file_directory);
        Scanner scanner = new Scanner(file);                                    // new scanner to scan in file
        ArrayList<Integer> int_list = new ArrayList<>();                        // new array list to hold the data on the file

        while (scanner.hasNextInt())
            int_list.add(scanner.nextInt());                                    // scan all the data from the file into the array list

        int[] p_array = new int[int_list.size()/4];                             // new integer array to hold just the values that correspond to the priority
        Jobs[] job_array = new Jobs[int_list.size()/4];                         // new Jobs array that holds all the information associated with each job

        int counter = 0;
        for(int c=0; c<int_list.size(); c+=4) {                                 // this for loop takes the raw information from the array list and puts it into
            Jobs job = new Jobs();                                              // the jobs class to help simplify the data
            job.setJob_number(int_list.get(c));
            job.setPriority(int_list.get(c+1));
            job.setArrival_time(int_list.get(c+2));
            job.setDuration(int_list.get(c+3));
            p_array[c/4] = job.getPriority();
            job_array[counter] = job;
            counter++;
        }

        myMaxHeaper mh = new myMaxHeaper(p_array.length);                       // new max heap
        for(int n=0; n<p_array.length-1; n++) {                                 // add all the integers from the priority array to the max heap
            mh.add(p_array[n]);
        }
        for(int position=0; position<p_array.length; position++) {              // builds and fills new max_heap
            mh.run_heap(position);
        }
        Run_jobs rj = new Run_jobs();                                           // new Run_jobs
        rj.run_jobs(job_array, mh);                                             // pass the array with all the job information and the max heaped priority queue through Run_jobs
    }

}
