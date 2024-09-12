package com.epatient.restapi.Models;

import jakarta.persistence.*;
import java.util.Date;

//import org.hibernate.annotations.Entity;
//new file updated
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "doctors")
public class ModelDoctors {
    /**
	 * @param sys_id
	 * @param adhaar_number
	 * @param prefix
	 * @param first_name
	 * @param last_name
	 * @param gender
	 * @param dob
	 * @param mobile
	 * @param whatsapp
	 * @param email
	 * @param specialization
	 * @param status
	 * @param created
	 * @param created_by
	 * @param updated
	 * @param updated_by
	 */
	
	public ModelDoctors()
	{}
	public ModelDoctors(int sys_id, String adhaar_number, String prefix, String first_name, String last_name,
			String gender, String dob, String mobile, String whatsapp, String email, String specialization,
			boolean status, Date created, int created_by, Date updated, int updated_by) {
		super();
		this.sys_id = sys_id;
		this.adhaar_number = adhaar_number;
		this.prefix = prefix;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.whatsapp = whatsapp;
		this.email = email;
		this.specialization = specialization;
		this.status = status;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int	sys_id 	;
    @Column(name = "adhaar_number")
    String	adhaar_number 	;
    @Column(name="prefix")
    String	prefix 	;
    @Column(name="first_name")
    String	first_name 	;
    @Column(name = "last_name")
    String	last_name 	;
    @Column(name = "gender")
    String	gender 	;
    @Column(name = "dob")
    String	dob 	;
    @Column(name = "mobile")
    String	mobile 	;   
    @Column(name = "whatsapp")
    String	whatsapp 	;
    @Column(name = "email")
    String	email 	;
    @Column(name = "specialization")
    String	specialization 	;
    @Column(name = "status")
    boolean	status 	;    
    //system columns
    @Column(name = "created")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date	created 	;
    @Column(name = "created_by")
    int	created_by 	;
    @Column(name = "updated")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date	updated 	;
    @Column(name = "updated_by")
    int	updated_by 	;
	/**
	 * @return the sys_id
	 */
	public int getSys_id() {
		return sys_id;
	}
	/**
	 * @param sys_id the sys_id to set
	 */
	public void setSys_id(int sys_id) {
		this.sys_id = sys_id;
	}
	/**
	 * @return the adhaar_number
	 */
	public String getAdhaar_number() {
		return adhaar_number;
	}
	/**
	 * @param adhaar_number the adhaar_number to set
	 */
	public void setAdhaar_number(String adhaar_number) {
		this.adhaar_number = adhaar_number;
	}
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the whatsapp
	 */
	public String getWhatsapp() {
		return whatsapp;
	}
	/**
	 * @param whatsapp the whatsapp to set
	 */
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the created_by
	 */
	public int getCreated_by() {
		return created_by;
	}
	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * @return the updated_by
	 */
	public int getUpdated_by() {
		return updated_by;
	}
	/**
	 * @param updated_by the updated_by to set
	 */
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
    
    
}
