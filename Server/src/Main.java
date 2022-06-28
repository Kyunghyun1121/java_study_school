import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1000);
		Socket client = ss.accept();
		
		OutputStream outStream = client.getOutputStream();
		InputStream inStream = client.getInputStream();
		
		DataOutputStream dataOut = new DataOutputStream(outStream);
		DataInputStream dataIn = new DataInputStream(inStream);	
		
		String s = dataIn.readUTF();
		dataOut.writeUTF(s);
	
		System.out.println(s);
		inStream.close();
		outStream.close();
		outStream.flush();
		dataIn.close();
		dataOut.flush();
		dataOut.close();
		ss.close();

		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//String line = reader.readLine();
		//System.out.println(line);  //서버와 통신이 완료되어 "안녕하세요"라는 값을 가지고 온다.

		

		//http://127.0.0.1:1000
	}

}
