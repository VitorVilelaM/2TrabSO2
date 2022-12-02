package main;

import algorithms.FCFS;
import components.CPU;
import components.Process;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class Main {

    public static void main(String[] args) {
        int t1, t2, p;
        FCFS fcfs = new FCFS();
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

        System.out.println("Tempo Total : " + cpu.getTimeTotal());
        System.out.println("Tempo Maximo de espera : " + cpu.getTimeWaitMax());
        System.out.println("Tempo Medio de Espera : " + cpu.getTimeWaitMed()/cpu.getNumProcess());
        System.out.println("Tempo Medio de ociosidade da CPU : " + cpu.getTimeidlenesstMed()/cpu.getNumProcess());
        System.out.println("Tempo Maximo de ociosidade da CPU : " + cpu.getIdlenessMax());
    }

}
