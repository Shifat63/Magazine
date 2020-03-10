package com.shifat63.magazine.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "front_message")
public class FrontMessage implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "front_message_id")
    private Integer frontMessageId;
	
	@NotBlank(message = "Message body must not be empty")
    @Size(min = 1, max = 500, message = "Message body must be between 1 to 500 characters")
    @Column(name = "message_body")
    private String messageBody;
	
	@Column(name = "is_active")
    private Boolean isActive;
}
