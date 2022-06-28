import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {
	public static void main(String[] args) throws IOException {
		
		String content = "Hello from java08";
		Socket socket = new Socket("127.0.0.1",1000); 
		
		OutputStream outStream = socket.getOutputStream();
		InputStream inStream = socket.getInputStream();
		
		DataOutputStream dataOut = new DataOutputStream(outStream);
		DataInputStream dataIn = new DataInputStream(inStream);	

		dataOut.writeUTF(content);
		//String s = dataIn.readUTF();

		
		inStream.close();
		outStream.close();
		outStream.flush();
		dataIn.close();
		dataOut.flush();
		dataOut.close();
		socket.close();
		
	}
}
