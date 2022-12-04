package algorithms;

import components.CPU;
import components.Process;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class RR {
//Algoritimo Escalonamento Circular (Round-Robin)
    public RR() {
    }

    public void RR(ArrayList<Process> Processos, CPU cpu) {
        int timeIdleness = 0, timeWait, i = 0;
        Process p1;
        boolean repeat = true;
        Process aux;

        while (!Processos.isEmpty()) {
            p1 = Processos.get(0);
            do {
                if (cpu.getTimeTotal() >= p1.getTimeArrival()) {
                    i = 0;
                    cpu.setTimeidlenesstMed(cpu.getTimeidlenesstMed() + timeIdleness);

                    if (timeIdleness > cpu.getIdlenessMax()) {
                        cpu.setIdlenessMax(timeIdleness);
                    }

                    repeat = false;
                    timeIdleness = 0;
                    if (Processos.indexOf(p1) >= 0) {
                        aux = Processos.remove(Processos.indexOf(p1));

                        timeWait = cpu.getTimeTotal() - aux.getTimeArrival();
                        cpu.setTimeWaitMed(cpu.getTimeWaitMed() + timeWait);

                        if (timeWait > cpu.getTimeWaitMax()) {
                            cpu.setTimeWaitMax(timeWait);
                        }

                        while (i < cpu.getQuantum() && aux.getTimeService() > 0) {
                            aux.setTimeService(aux.getTimeService() - 1);
                            cpu.setTimeTotal(cpu.getTimeTotal() + 1);
                            i++;
                        }
                        if (aux.getTimeService() > 0) {
                            cpu.setContextTrade(cpu.getContextTrade() + 1);
                            Processos.add(aux);
                        } else {
                            cpu.setNumProcess(cpu.getNumProcess() + 1);
                        }
                    }

                } else {
                    timeIdleness++;
                    cpu.setTimeTotal(cpu.getTimeTotal() + 1);
                }
            } while (repeat);

            repeat = true;

        }
    }
}
