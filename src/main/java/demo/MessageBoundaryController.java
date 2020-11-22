package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageBoundaryController {
	private MessageService messageService;

	@Autowired
	public MessageBoundaryController(MessageService messageService) {
		this.messageService = messageService;
	}

	// C[RUD]
	@RequestMapping(path = "/messages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageBoundary create(@RequestBody MessageBoundary message) {

		return this.messageService.create(message);
	}
	
	@RequestMapping(path = "/messages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageBoundary[] getAll (
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
		return this.messageService.getAll(size, page)
			.toArray(new MessageBoundary[0]);
	}
}
