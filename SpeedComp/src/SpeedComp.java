import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class MyBufferedFileInputStream {
	private FileInputStream fis;
	private byte[] buffer = new byte[8192];
	private int num = 0;
	private long siz = 0;
	
	public MyBufferedFileInputStream(File file) throws FileNotFoundException {
		fis = new FileInputStream(file);
		siz = file.length();
		// TODO Auto-generated constructor stub
	}

	public int read() throws IOException {
		if(num == 8192) {
			num = 0;
			buffer = new byte[8192];
			
		}
		
		if(buffer[0] == 0) {
			if(siz < 8192) {
				fis.read(buffer, 0, (int) siz);
			}else {			
				fis.read(buffer, 0, 8192);
				siz -= 8192;
			}
		}

		if(buffer[num] != 0) {
			return buffer[num++];
		}else {
			return -1;
		}
	}

}

public class SpeedComp {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream mystream1 = new FileInputStream("one_mega.txt");
		int c = 0;
		long count = 0;
		
		double beforeTime = System.currentTimeMillis();
		while ( ( c = mystream1.read()) != -1 ) {
		    if ( c == 'a') count++;
		}
		System.out.println("개수 : "+count);
		double afterTime = System.currentTimeMillis(); 
		double secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("시간차이(m) : "+secDiffTime);
		
		
		count = 0;
		File ff = new File("one_mega.txt");
		beforeTime = System.currentTimeMillis();
		MyBufferedFileInputStream mystream2 = new MyBufferedFileInputStream(ff);
		while ( ( c = mystream2 .read()) != -1) {
		    if ( c == 'a') count++;
		}
		System.out.println("개수 : "+count);
		afterTime = System.currentTimeMillis(); 
		secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("시간차이(m) : "+secDiffTime);
	}
}