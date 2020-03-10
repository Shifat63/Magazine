package com.shifat63.magazine.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "contact_ticket")
public class ContactTicket implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_ticket_id")
    private Integer contactTicketId;
	
	@NotBlank(message = "First name must not be empty")
    @Size(min = 1, max = 50, message = "First name must be between 1 to 50 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    @Size(min = 1, max = 50, message = "Last name must be between 1 to 50 characters")
    @Column(name = "last_name")
    private String lastName;
    
    @Email
    @NotBlank(message = "Email must not be empty")
    @Size(min = 5, max = 100, message = "Email must be between 5 to 100 characters")
    @Column(name = "email")
    private String email;
    
    @NotBlank(message = "Description must not be empty")
    @Size(min = 1, max = 2000, message = "Description must be between 1 to 2000 characters")
    @Column(name = "description")
    private String description;
}
