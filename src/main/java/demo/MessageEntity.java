package demo;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name="MESSAGES")
public class MessageEntity {
	private Long id;
	private String message;

	public MessageEntity() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	@NotNull @NotEmpty
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
