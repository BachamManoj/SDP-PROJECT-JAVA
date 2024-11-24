package com.klu.OnlineMedicalAppointment.model;

import jakarta.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Lob
    private byte[] profileImage;

    public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	@Size(max = 50, message = "Doctor's name should not exceed 50 characters")
    private String name;

    @Size(max = 50, message = "Specialization should not exceed 50 characters")
    private String specialization;

    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a valid 10-digit number")
    private String contactNumber;

    @Email(message = "Email should be valid")
    private String email;
    
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments;
    
    private Double fee;
    
    public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Doctor() {}

    public Doctor(String name, String specialization, String contactNumber, String email,Double fee) {
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.email = email;
        this.fee=fee;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    public void updateDetails(Doctor updatedDoctor) {
        if (updatedDoctor.getName() != null) {
            this.name = updatedDoctor.getName();
        }
        if (updatedDoctor.getFee() != null) {
            this.fee = updatedDoctor.getFee();
        }
        if (updatedDoctor.getEmail() != null) {
            this.email = updatedDoctor.getEmail();
        }
        if (updatedDoctor.getContactNumber() != null) {
            this.contactNumber = updatedDoctor.getContactNumber();
        }
        if (updatedDoctor.getSpecialization() != null) {
            this.specialization = updatedDoctor.getSpecialization();
        }
        if (updatedDoctor.getProfileImage() != null) {
            this.profileImage = updatedDoctor.getProfileImage();
        }
    }
    
}
