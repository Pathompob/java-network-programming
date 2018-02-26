public class Warehouse {
    int productID;
    boolean empty = true;
    public synchronized void put (int productID){
        if(!empty) {
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        empty = false;
        this.productID = productID;
        notify();
    }
    public synchronized int take(){
        if(empty){
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        int result = this.productID;
        empty = true;
        notify();
        return result;
    }   
}