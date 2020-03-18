package com.shifat63.magazine.Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import lombok.Data;


@Entity
@Data
@Table(name = "event")
public class Event implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
    private Integer eventId;
	
	@NotBlank(message = "Event name must not be empty")
    @Size(min = 1, max = 200, message = "Event name must be between 1 to 200 characters")
    @Column(name = "name")
    private String name;
	
	@NotBlank(message = "Event description must not be empty")
    @Size(min = 1, max = 2000, message = "Event description must be between 1 to 2000 characters")
    @Column(name = "description")
    private String description;
	
	@NotBlank(message = "Event location must not be empty")
    @Size(min = 1, max = 200, message = "Event location must be between 1 to 200 characters")
    @Column(name = "place")
    private String place;
	
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Future(message = "Event time must be in future")
    @Column(name = "datetime")
    private LocalDate datetime;
    
    @NotBlank(message = "Event organizer must not be empty")
    @Size(min = 1, max = 200, message = "Event organizer must be between 1 to 200 characters")
    @Column(name = "organizer")
    private String organizer;
    
    @URL
    @Column(name = "link")
    private String link;
    
    @Column(name = "is_front")
    private Boolean isFront;
    
    @NotNull(message = "Event ticket price must be given")
    @Column(name = "ticket_price")
    private Double ticketPrice;
}
