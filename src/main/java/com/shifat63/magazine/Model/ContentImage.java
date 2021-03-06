package com.shifat63.magazine.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "content_image")
public class ContentImage implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_image_id")
    private Integer contentImageId;
	
    @Column(name = "location")
    private String location;
    
    @NotNull(message = "Image position must not be empty")
    @Column(name = "position")
    private String position;
    
    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
