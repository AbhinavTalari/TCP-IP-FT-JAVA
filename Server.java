import java.io.*;
import java.net.*;



public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server_socket=new ServerSocket(5000);
        Socket socket= server_socket.accept();


        InetAddress iA=InetAddress.getByName("localhost");
        File file=new File("C:\\Users\\Abhinav\\Desktop\\Desktop Files\\CP\\Java\\Server\\test.txt");
        FileInputStream file_input_stream=new FileInputStream(file);
        BufferedInputStream buffered_input_steam= new BufferedInputStream(file_input_stream);

        OutputStream out_stream=socket.getOutputStream();
        
        byte[] contents;
        long file_length=file.length();
        long current=0;

        long start= System.nanoTime();
        while(current!=file_length)
        {
            int size=10000;
            if(file_length-current>size)
            {
                current+=size;
            }
        
            else
            {   
                size=(int)(file_length-current);
                current=file_length;

            }

            contents=new byte[size];
            buffered_input_steam.read(contents,0,size);
            out_stream.write(contents);
            System.out.println("Sending File-......."+(current*100)/file_length+"% Complete");
        }
        
        out_stream.flush();
        socket.close();
        server_socket.close();
        buffered_input_steam.close();
        
        System.out.println("File Sent Succesfully");
        System.out.println("Time Taken : "+start);

    }
    
}