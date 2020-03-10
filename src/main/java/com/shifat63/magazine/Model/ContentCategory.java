package com.shifat63.magazine.Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "content_category")
public class ContentCategory implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_category_id")
    private Integer contentCategoryId;
	
    @NotBlank(message = "Content category name must not be empty")
    @Size(min = 1, max = 50, message = "Content category name must be between 1 to 50 characters")
    @Column(name = "name")
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentCategory")
    private Set<Content> contentSet;
}
