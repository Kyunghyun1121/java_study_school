import sms_sender.MsgSender;

class AtomicPlant {
	Logger myLogger;

	public AtomicPlant(Logger logger) {
		// 초기화
		myLogger = logger;
	}

	public void checkTemparature() {
		// 로거를 이용해서 "관리자 java39 흥길동" 처럼 출력한다.
		// 각자 자기의 ID와 이름을 보내는 거다.
		myLogger.log("classadapter_노경현_java08");
	}
}

interface Logger {
	public void log(String msg);
}

class SMSLogger extends MsgSender implements Logger {
	public SMSLogger(String phone) {
		super(phone);
	}

	public void log(String msg) {
		System.out.println(send(msg));
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SMSLogger myLogger = new SMSLogger("01085784321"); // 조세형교수 전번임
		AtomicPlant ap = new AtomicPlant(myLogger);
		ap.checkTemparature();
	}

}