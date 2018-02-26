public class CPU{
    String pName ="--";
    boolean taked = false;
    boolean run = false;

    public String getProcess(){
        if(run) return pName;
        else return "--";
    }

    public void run(){
        run = true;
    }
    
    public synchronized boolean take(String pName){
        if(taked) return false;
        taked = true;
        this.pName = pName;
        return true;
    }
    public synchronized void release(){
        taked = false;
        run = false;
    }
}