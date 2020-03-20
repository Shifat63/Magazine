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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Entity
@Data
@Table(name="user")
@EqualsAndHashCode(exclude = {"userType", "contentSet"})
@ToString(exclude = {"userType", "contentSet"})
public class User implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Integer userId;
	
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
    
    @Past(message = "Date of birth must be any past date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
    @Column(name = "password")
    private String password;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    @NotNull(message = "Every user must belong to a user type")
    private UserType userType;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Content> contentSet;
}
