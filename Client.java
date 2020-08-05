import java.io.*;
import java.net.*;


/**
 * Client
 */
public class Client {
    public static void main(String[] args) throws Exception {
        
        Socket socket=new Socket(InetAddress.getByName("localhost"),5000);
        byte[] contents=new byte[10000];
        
        FileOutputStream file_output_stream= new FileOutputStream("C:\\Users\\Abhinav\\Desktop\\Desktop Files\\CP\\Java\\Client\\output.txt");
        BufferedOutputStream buffered_outputstream=new BufferedOutputStream(file_output_stream);
        InputStream input_stream=socket.getInputStream();

        int bytesRead=0;

        while((bytesRead=input_stream.read(contents))!=-1)
        {
            buffered_outputstream.write(contents,0,bytesRead);

        }
        buffered_outputstream.flush();
        socket.close();

        System.out.println("File Saved Succesfully");

    }
    
}