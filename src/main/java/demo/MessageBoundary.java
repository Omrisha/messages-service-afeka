package demo;

// {"message":"hello", "id":"xyz"}
public class MessageBoundary {
	private String message;
	private String id;
	
	public MessageBoundary() {
	}
	
	public MessageBoundary(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
