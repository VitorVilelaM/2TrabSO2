package components;

/**
 *
 * @author vitor
 */
public class CPU {

    private int numProcess;
    private int timeTotal;
    private int timeWaitMax;
    private int idlenessMax; // Ociosidade
    private int contextTrade;
    private int quantum;

    private double timeWaitMed;
    private double timeidlenesstMed;

    private boolean run;

    public CPU(int quantum) {
        this.quantum = quantum;
        this.timeWaitMed = 0;
        this.idlenessMax = 0;
        this.timeWaitMax = 0;
        this.timeTotal = 0;
        this.numProcess = 0;
        this.idlenessMax = 0;
        
    }

    public int getNumProcess() {
        return numProcess;
    }

    public void setNumProcess(int numProcess) {
        this.numProcess = numProcess;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(int timeTotal) {
        this.timeTotal = timeTotal;
    }

    public int getTimeWaitMax() {
        return timeWaitMax;
    }

    public void setTimeWaitMax(int timeWaitMax) {
        this.timeWaitMax = timeWaitMax;
    }

    public int getIdlenessMax() {
        return idlenessMax;
    }

    public void setIdlenessMax(int idlenessMax) {
        this.idlenessMax = idlenessMax;
    }

    public int getContextTrade() {
        return contextTrade;
    }

    public void setContextTrade(int contextTrade) {
        this.contextTrade = contextTrade;
    }

    public double getTimeWaitMed() {
        return timeWaitMed;
    }

    public void setTimeWaitMed(double timeWaitMed) {
        this.timeWaitMed = timeWaitMed;
    }

    public double getTimeidlenesstMed() {
        return timeidlenesstMed;
    }

    public void setTimeidlenesstMed(double timeidlenesstMed) {
        this.timeidlenesstMed = timeidlenesstMed;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
    
    public void mostrarDados(){
        System.out.println("Tempo Total : " + getTimeTotal());
        System.out.println("Tempo Maximo de espera : " + getTimeWaitMax());
        System.out.println("Tempo Medio de Espera : " + getTimeWaitMed() / getNumProcess());
        System.out.println("Tempo Medio de ociosidade da CPU : " + getTimeidlenesstMed() / getNumProcess());
        System.out.println("Tempo Maximo de ociosidade da CPU : " + getIdlenessMax());
        System.out.println("Trocas de Contexto: " + getContextTrade());
    }

}
