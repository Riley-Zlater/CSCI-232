package outLab1;

/**
 *
 * @authors Ara Megerdichian and Riley Slater
 */

public class Run_jobs {

    // Fields
    public int timer = 0;
    public int elapsed_time = 0;
    public int total_time = 0;
    public int counter = 0;

    /**
     * This method resets the timer back to 0.
     */
    public void clear_timer() {
        timer = 0;
    }

    /**
     * This method resets the elapsed time back to 0.
     */
    public void clear_elapsed() {
        elapsed_time = 0;
    }

    /**
     * This method allows us to search the array of jobs to get the one with the highest priority.
     * @param job_array This parameter is the array of jobs.
     * @param priority This parameter is the priority we're looking for in the array of jobs as an integer.
     * @return This method returns the array that holds all the information for the job wiht the highest priority.
     */
    public Jobs search(Jobs[] job_array, int priority) {
        for (Jobs job: job_array) {
            if(job.getPriority() == priority) {
                return job;
            }
        }
        return null;
    }

    /**
     * This method takes the max heap and jobs array and uses them to figure out which job is running and for how long.
     * Then, this method formats and prints the desired output including the running time calculations.
     * @param job_array This parameter is the array of jobs.
     * @param mh This parameter is the max heaped priority queue.
     */
    public void run_jobs(Jobs[] job_array, myMaxHeaper mh) {

        try {
            counter++;
            int priority = mh.getMax();
            Jobs job = search(job_array, priority);
            int job_arrival = job.getArrival_time();
            int job_duration = job.getDuration();
            System.out.println("\n" + counter + ". Beginning job number " + job.getJob_number());
            System.out.println("    Arrival time: " + total_time + "s.");
            while (job_arrival - timer > 0) {
                Runnable thread = new Runnable();
                try {
                    thread.sleep(1000);               // We added this try so the program actually increments by seconds, it could be removed for simulations/tests
                } catch (InterruptedException ie) {
                    thread.currentThread().interrupt();
                }
                timer++;
                elapsed_time++;
                total_time++;
            }
            System.out.println("    Job arrival complete after " + elapsed_time + "s.");
            clear_timer();
            System.out.println("    Beginning job at time " + elapsed_time + "s.");
            while (job_duration - timer > 0) {
                Runnable thread = new Runnable();
                try {
                    thread.sleep(1000);            // Same as above
                } catch (InterruptedException ie) {
                    thread.currentThread().interrupt();
                }
                timer++;
                elapsed_time++;
                total_time++;
            }
            clear_timer();
            System.out.println("    Job" + job.getJob_number() + "complete at time " + elapsed_time + "s.");
            System.out.println("    Reordering queue...");
            mh.remover();
            clear_elapsed();
            run_jobs(job_array, mh);
        } catch(NullPointerException e){
            System.out.println("\n All jobs completed after " + total_time + "s.");
        }
    }
}
