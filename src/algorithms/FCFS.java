package algorithms;

import components.CPU;
import components.Process;

/**
 *
 * @author vitor
 */
public class FCFS {

    public FCFS() {
    }

    @SuppressWarnings("empty-statement")
    public void FCFS(Process p1, CPU cpu) {
        int timeIdleness = 0, timeWait;
        boolean repeat = true;

        do {
            if (cpu.getTimeTotal() >= p1.getTimeArrival()) {
                cpu.setTimeidlenesstMed(cpu.getTimeidlenesstMed() + timeIdleness);
                timeWait = cpu.getTimeTotal() - p1.getTimeArrival();
                cpu.setTimeWaitMed(cpu.getTimeWaitMed() + timeWait);
                
                if(timeWait > cpu.getTimeWaitMax()){
                    cpu.setTimeWaitMax(timeWait);
                }
                
                if (timeIdleness > cpu.getIdlenessMax()) {
                    cpu.setIdlenessMax(timeIdleness);
                }
                
                repeat = false;
                timeIdleness = 0;
                cpu.setNumProcess(cpu.getNumProcess() + 1);
                
                
                while (p1.getTimeService() > 0) {
                    p1.setTimeService(p1.getTimeService() - 1);
                    cpu.setTimeTotal(cpu.getTimeTotal() + 1);
                }
            } else {
                timeIdleness++;
                cpu.setTimeTotal(cpu.getTimeTotal() + 1);
            }
        } while (repeat);
    }

}
