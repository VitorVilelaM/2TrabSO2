package main;

import algorithms.FCFS;
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
        int t1, t2, p, op = 2;
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
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
        
        if(op == 1){
            for(Process aux : processos){
                fcfs.FCFS(aux, cpu);
            }
        }else if(op == 2){
            Collections.sort(processos);
            for(Process aux : processos){
                sjf.SJF(aux, cpu);
            }
        }
        

        System.out.println("Tempo Total : " + cpu.getTimeTotal());
        System.out.println("Tempo Maximo de espera : " + cpu.getTimeWaitMax());
        System.out.println("Tempo Medio de Espera : " + cpu.getTimeWaitMed()/cpu.getNumProcess());
        System.out.println("Tempo Medio de ociosidade da CPU : " + cpu.getTimeidlenesstMed()/cpu.getNumProcess());
        System.out.println("Tempo Maximo de ociosidade da CPU : " + cpu.getIdlenessMax());
    }

}
