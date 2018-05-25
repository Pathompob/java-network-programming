import java.net.*;
import java.util.*;

public class EchoServer {
  public static void main(String args[]){
    try {
      DatagramSocket socket = new DatagramSocket(9876);
      while(true){
        byte[] recvBuffer = new byte[8000];
        byte[] sendDate = new byte[8000];
        DatagramPacket dp = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(dp);
        System.out.println(new String(dp.getData(), 0, dp.getLength()));
        Date now = new Date();
        sendDate = now.toString().getBytes();
        DatagramPacket dp2 = new DatagramPacket(sendDate,
                                                sendDate.length,
                                                dp.getAddress(),
                                                dp.getPort());
        socket.send(dp2);
      }
    } catch (Exception e) {}
  }
}
