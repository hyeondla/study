package vo;

public class ActionForward {
	
	private String path;
	private boolean isRedirect; // 리다이렉트 true, 디스패쳐 false
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
