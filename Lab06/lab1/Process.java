import java.lang.reflect.Array;

public class Process extends Thread{
    String name;
    CPU[] cpu;
    int nCPU;

    public Process(String name,CPU[] cpu,int nCPU){
        this.name = name;
        this.cpu = cpu;
        this.nCPU = nCPU;
    }

    public void run(){
        boolean done = false;
        while(!done){
            int cpuuse[] = new int[nCPU];
            int count=0;
            for(int i=0;i<nCPU;i++){
                for(int j=0;j<cpu.length;j++){
                    if(cpu[j].take(this.name)){
                        cpuuse[count] = j;
                        count++;
                        break;
                    }
                }
            }
            if(count==nCPU){
                for(int i=0;i<count;i++){
                    cpu[cpuuse[i]].run();
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
                for(int i=0;i<count;i++){
                    cpu[cpuuse[i]].release();
                }
                done = true;
            }
            else{
                for(int i=0;i<count;i++){
                    cpu[cpuuse[i]].release();
                }
            }
        }    
    }
}