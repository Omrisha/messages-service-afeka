package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceDb implements MessageService {

	private MesssageDao messageDao;

	@Autowired
	public MessageServiceDb(MesssageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	@Transactional
	public MessageBoundary create(MessageBoundary message) {
		MessageEntity entity = toEntity(message);
		entity = this.messageDao.save(entity);
		return this.fromEntity(entity);
	}

	private MessageBoundary fromEntity(MessageEntity entity) {
		MessageBoundary rv = new MessageBoundary();
		
		if (entity.getId() != null) {
			rv.setId("" + entity.getId());
		}
		
		rv.setMessage(entity.getMessage());
		
		return rv;
	}

	private MessageEntity toEntity(MessageBoundary message) {
		MessageEntity entity = new MessageEntity();
		
		if (message.getId() != null) {
			entity.setId(Long.parseLong(message.getId()));
		}
		
		entity.setMessage(message.getMessage());
		
		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MessageBoundary> getAll(int size, int page) {
		return this.messageDao
			.findAll(PageRequest.of(page, size, Direction.DESC, "id"))
			.getContent()
			.stream()
			.map(this::fromEntity)
			.collect(Collectors.toList());
	}

}








