package thread;

public class Test2 {

	public static void main(String[] args) {

		// 싱글쓰레드
		
		SendMessage sm = new SendMessage("안녕하세요", 100);
		FileTransfer ft = new FileTransfer("Ex.java", 100000);
		
//		ft.run();
//		sm.run();
		
		//--------------------------------------------------------------
		
		// 멀티쓰레드
		
		SendMessageMultiThread smmt = new SendMessageMultiThread("안녕하세요", 100);
		FileTransferMultiThread ftmt = new FileTransferMultiThread("Ex.java", 100);
//		ReceiveMessageMultiThread rmmt = new ReceiveMessageMultiThread("반갑습니다", 100);
		Thread rmmt = new Thread(new ReceiveMessageMultiThread("반갑습니다", 100));
		ftmt.start();
		smmt.start();
		rmmt.start();
		
	}

}

// 싱글쓰레드
class SendMessage {
	String msg;
	int count;

	public SendMessage(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}
	
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println("메세지 전송 - " + i + " : " + msg);
		}
	}
}

// 멀티쓰레드
class SendMessageMultiThread extends Thread {
	String msg;
	int count;

	public SendMessageMultiThread(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println("메세지 전송 - " + i + " : " + msg);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//----------------------------------------------------------------------

// 싱글쓰레드
class FileTransfer {
	String fileName;
	int count;
	
	public FileTransfer(String fileName, int count) {
		super();
		this.fileName = fileName;
		this.count = count;
	}

	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println("파일 전송 - " + i + " : " + fileName);
		}
	}
}

// 멀티쓰레드
class FileTransferMultiThread extends Thread {
	String fileName;
	int count;
	
	public FileTransferMultiThread(String fileName, int count) {
		super();
		this.fileName = fileName;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println("파일 전송 - " + i + " : " + fileName);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//----------------------------------------------------------------------

class ReceiveMessageMultiThread implements Runnable {
	String msg;
	int count;

	public ReceiveMessageMultiThread(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println("메세지 수신 - " + i + " : " + msg);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

