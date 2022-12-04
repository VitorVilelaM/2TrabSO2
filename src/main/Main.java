package main;

import algorithms.FCFS;
<<<<<<< Updated upstream
=======
import algorithms.NSRT;
import algorithms.RR;
import algorithms.SJF;
>>>>>>> Stashed changes
import components.CPU;
import components.Process;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class Main {

    public static void main(String[] args) {
<<<<<<< Updated upstream
        int t1, t2, p;
        FCFS fcfs = new FCFS();
=======
        int t1, t2, p, op = 4;
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        NSRT nsrt = new NSRT();
        RR rr = new RR();
>>>>>>> Stashed changes
        CPU cpu = new CPU(10);
        Process process;
        ArrayList<String> data = FileManager.stringReader("./testes/teste.txt");

        for (String aux : data) {
            String[] processData = aux.split(", ");
            t1 = Integer.parseInt(processData[0]);
            t2 = Integer.parseInt(processData[1]);
            p = Integer.parseInt(processData[2]);
            process = new Process(t1, t2, p);
            fcfs.FCFS(process, cpu);
        }

<<<<<<< Updated upstream
        System.out.println("Tempo Total : " + cpu.getTimeTotal());
        System.out.println("Tempo Maximo de espera : " + cpu.getTimeWaitMax());
        System.out.println("Tempo Medio de Espera : " + cpu.getTimeWaitMed()/cpu.getNumProcess());
        System.out.println("Tempo Medio de ociosidade da CPU : " + cpu.getTimeidlenesstMed()/cpu.getNumProcess());
        System.out.println("Tempo Maximo de ociosidade da CPU : " + cpu.getIdlenessMax());
=======
        switch (op) {
            case 1 -> {
                for (Process aux : processos) {
                    fcfs.FCFS(aux, cpu);
                }
            }
            case 2 -> {
                Collections.sort(processos);
                for (Process aux : processos) {
                    sjf.SJF(aux, cpu);
                }
            }
            case 3 -> {
                Collections.sort(processos);
                nsrt.NSRT(processos, cpu);
            }
            case 4 -> rr.RR(processos, cpu);
            default -> {
            }
        }

        cpu.mostrarDados();
>>>>>>> Stashed changes
    }

}
