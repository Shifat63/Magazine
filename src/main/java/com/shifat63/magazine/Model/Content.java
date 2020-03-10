package com.shifat63.magazine.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Data
@Table(name = "content")
public class Content implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_id")
    private Integer contentId;
	
	@NotNull(message = "Content Language must not be empty")
	@Column(name = "language")
    private String language;
	
	@NotBlank(message = "Headline must not be empty")
    @Size(min = 1, max = 200, message = "Headline must be between 1 to 200 characters")
    @Column(name = "headline")
    private String headline;
	
	@NotBlank(message = "Teaser must not be empty")
    @Size(min = 1, max = 500, message = "Teaser must be between 1 to 500 characters")
    @Column(name = "teaser")
    private String teaser;
	
	@NotBlank(message = "Content text must not be empty")
    @Size(min = 1, max = 5000, message = "Content text must be between 1 to 5000 characters")
    @Column(name = "content_text")
    private String contentText;
	
    @Column(name = "creation_date")
    private LocalDate creationDate;
    
    @Column(name = "is_front")
    private Boolean isFront;
    
    @Size(min = 0, max = 100, message = "Keywords must be less than 100 characters")
    @Column(name = "keyword")
    private String keyword;
    
    @Nullable
    @Column(name = "translation_of")
    private Integer translationOf;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "content_category_id")
    @NotNull(message = "Every content must belong to a category")
    private ContentCategory contentCategory;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "content")
    private Set<ContentImage> ContentImageSet;
}
