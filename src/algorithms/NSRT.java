package algorithms;

import components.CPU;
import components.Process;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class NSRT {

    public NSRT() {
    }

    public void NSRT(ArrayList<Process> Processos, CPU cpu) {
        int timeIdleness = 0, timeWait, i = 1;
        boolean repeat = true, exec = true;
        ArrayList<Process> bloqueados = new ArrayList();
        ArrayList<Process> executados = new ArrayList();
        Process aux;

        for (Process p1 : Processos) {
            do {
                if (cpu.getTimeTotal() >= p1.getTimeArrival()) {
                    i = 1;
                    cpu.setTimeidlenesstMed(cpu.getTimeidlenesstMed() + timeIdleness);
                    timeWait = cpu.getTimeTotal() - p1.getTimeArrival();
                    cpu.setTimeWaitMed(cpu.getTimeWaitMed() + timeWait);

                    if (timeWait > cpu.getTimeWaitMax()) {
                        cpu.setTimeWaitMax(timeWait);
                    }

                    if (timeIdleness > cpu.getIdlenessMax()) {
                        cpu.setIdlenessMax(timeIdleness);
                    }

                    repeat = false;
                    timeIdleness = 0;
                    cpu.setNumProcess(cpu.getNumProcess() + 1);

                    if (executados.indexOf(p1) >= 0) {
                        exec = false;
                    } else {
                        exec = true;
                    }

                    while (p1.getTimeService() > 0 && exec) {
                        if ((Processos.indexOf(p1) + i) < Processos.size()) {
                            aux = Processos.get(Processos.indexOf(p1) + i);
                            if (aux.getTimeService() < p1.getTimeService() && aux.getTimeArrival() <= cpu.getTimeTotal()) {
                                bloqueados.add(p1);
                                System.out.println(p1.getTimeArrival() + " " + p1.getTimeService() + " " + p1.getPriority());
                                p1 = aux;
                                executados.add(aux);
                                cpu.setContextTrade(cpu.getContextTrade() + 1);
                            }
                        }

                        p1.setTimeService(p1.getTimeService() - 1);
                        cpu.setTimeTotal(cpu.getTimeTotal() + 1);
                        
                        if (p1.getTimeService() == 0 && !bloqueados.isEmpty()) {
                            p1 = bloqueados.remove(0);
                            i++;
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
