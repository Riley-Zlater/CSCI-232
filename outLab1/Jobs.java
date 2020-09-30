package outLab1;

/**
 * This java class file is used to help extract the proper information from the inputed text file.
 *
 * @authors Ara Megerdichian and Riley Slater
 */

public class Jobs {

    // Fields

    private int job_number;
    private int priority;
    private int arrival_time;
    private int duration;

    // Constructors

    /**
     * This constructs the jobs as they're recieved from the input file.
     * @param job_number This parameter is an integer that lists the number of the job.
     * @param priority This parameter is an integer that gives us the priority of the job.
     * @param arrival_time This parameter is an integer that gives us the time it will take for the job to arrive.
     * @param duration This parameter is an integer that gives us the duration the job will take before removing it from the priority queue.
     */

    public Jobs(int job_number, int priority, int arrival_time, int duration) {
        this.job_number = job_number;
        this.priority = priority;
        this.arrival_time = arrival_time;
        this.duration = duration;
    }

    /**
     * This is our base case empty constructor.
     */
    public Jobs() {
        this.job_number = -1;
        this.priority = -1;
        this.arrival_time = -1;
        this.duration = -1;
    }

    // Methods
    /**
     * This method gives us the job number.
     * @return This method returns the job number as an integer.
     */
    public int getJob_number() {return this.job_number;}

    /**
     * This method gives us the priority of the jobs.
     * @return This method returns the priority number as an integer.
     */
    public int getPriority() {return this.priority;}

    /**
     * this method gives us the arrival time.
     * @return This method returns the arrival time as an integer.
     */
    public int getArrival_time() {return this.arrival_time;}

    /**
     * This method gives us the duration of each job.
     * @return This method returns the duration time of the job as an integer.
     */
    public int getDuration() {return this.duration;}

    /**
     * This method allows us to set the specific job numbers.
     * @param job_number This parameter is the job number as an integer that we're setting.
     */
    public void setJob_number(int job_number) {this.job_number = job_number;}

    /**
     * This method allows us to set the priority number of a job.
     * @param priority This parameter is the priority as an integer of the job we're setting.
     */
    public void setPriority(int priority) {this.priority = priority;}

    /**
     * This method allows us to set the arrival time of a job.
     * @param arrival_time This parameter is the arrival time of the job that we're setting as an integer.
     */
    public void setArrival_time(int arrival_time) {this.arrival_time = arrival_time;}

    /**
     * This method allows us to set the duration of a job.
     * @param duration This parameter is the duration that we're setting as an integer.
     */
    public void setDuration(int duration) {this.duration = duration;}

}
