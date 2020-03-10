package com.shifat63.magazine.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "slider")
public class Slider implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slider_id")
    private Integer sliderId;
	
	@Column(name = "position")
    private Integer position;
	
	@Column(name = "image_location")
    private String imageLocation;
	
	@Column(name = "is_active")
    private Boolean isActive;

}
