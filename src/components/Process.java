package components;

/**
 *
 * @author vitor
 */
public class Process implements Comparable<Process>{

    private int timeArrival;
    private int timeService;
    private int priority;
    private int timeJob;

    public Process(int timeArrival, int timeService, int priority) {
        this.timeArrival = timeArrival;
        this.timeService = timeService;
        this.priority = priority;
        this.timeJob = timeArrival+timeService;
    }

    public int getTimeJob() {
        return timeJob;
    }

    public void setTimeJob(int timeJob) {
        this.timeJob = timeJob;
    }

    public int getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(int timeArrival) {
        this.timeArrival = timeArrival;
    }

    public int getTimeService() {
        return timeService;
    }

    public void setTimeService(int timeService) {
        this.timeService = timeService;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Process o) {
        if(o.getTimeArrival() == this.timeArrival){
            int controle1= o.getTimeJob(), controle2 = this.timeJob;
            if(o.getTimeJob() > this.timeJob){
                return -1;
            }else if(o.getTimeJob() < this.timeJob){
                return 1;
            }else{
                return 0;
            }
        }
        return 0;
    }
}
