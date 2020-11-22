package demo;

import java.util.List;

public interface MessageService {

	public MessageBoundary create(MessageBoundary message);
	public List<MessageBoundary> getAll (int size, int page);

}
