public class Fork{
    boolean taked = false;
    String holderName = "  ";

    public String getHolderName(){
        return holderName;
    }
    public synchronized boolean take(String holderName){
        if(taked) return false;
        taked = true;
        this.holderName = holderName;
        return true;
    }
    public synchronized void putDown(){
        taked = false;
        this.holderName = "  ";
    }
}