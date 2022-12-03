package main;

import algorithms.FCFS;
import algorithms.NSRT;
import algorithms.SJF;
import components.CPU;
import components.Process;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author vitor
 */
public class Main {

    public static void main(String[] args) {
        int t1, t2, p, op = 3;
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        NSRT nsrt = new NSRT();
        CPU cpu = new CPU(10);
        Process process;
        ArrayList<String> data = FileManager.stringReader("./testes/teste.txt");
        ArrayList<Process> processos = new ArrayList();

        for (String aux : data) {
            String[] processData = aux.split(", ");
            t1 = Integer.parseInt(processData[0]);
            t2 = Integer.parseInt(processData[1]);
            p = Integer.parseInt(processData[2]);
            process = new Process(t1, t2, p);
            processos.add(process);
        }

        if (op == 1) {
            for (Process aux : processos) {
                fcfs.FCFS(aux, cpu);
            }
        } else if (op == 2) {
            Collections.sort(processos);
            for (Process aux : processos) {
                sjf.SJF(aux, cpu);
            }
            System.out.println(processos.size());
        } else if (op == 3) {
            Collections.sort(processos);
            nsrt.NSRT(processos, cpu);
        }

        cpu.mostrarDados();
    }

}
