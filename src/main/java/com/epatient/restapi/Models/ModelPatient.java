package com.epatient.restapi.Models;

import jakarta.persistence.*;

import java.sql.Types;
import java.util.Date;

import org.hibernate.annotations.JdbcTypeCode;

//import org.hibernate.annotations.Entity;
//new file updated
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name = "patients")
public class ModelPatient {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int	sys_id 	;
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paitents_panumber_seq")
   //@SequenceGenerator(name = "paitents_panumber_seq", sequenceName = "paitents_panumber_seq", allocationSize = 1)
    @Column(name = "pnumber")
    String	pnumber 	;
    @Column(name="adhaar_number")
    String	adhaar_number 	;
    @Column(name = "prefix")
    String	prefix 	;
    @Column(name = "first_name")
    String	first_name 	;
    @Column(name = "full_name")
    String	full_name 	;
    @Column(name = "last_name")
    String	last_name 	;
    @Column(name = "gender")
    String	gender 	;
    @Column(name = "dob")
    Date dob 	;
    @Column(name = "mobile")
    String	mobile 	;
    @Column(name = "whatsapp")
    String	whatsapp 	;
    @Column(name = "marital_status")
    String	marital_status 	;
    @Column(name = "email")
    String	email 	;
    @Column(name = "address")
    String	address 	;
    @Column(name = "age")
    String	age 	;
    @Column(name = "occupation")
    String	occupation 	;
    @Column(name = "emergency_contact")
    String emergency_contact;
    @Column(name = "area")
    String        area;
	@Column(name = "city")
    String        city;
    @Column(name = "state")
    String state;
    @Column(name = "country")
    String country;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "registrDate")
    Date	registrDate 	;
    
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
    @Lob
    @Column(name = "userImage")
    private byte[] userImage;

    public ModelPatient()
    {}

    /**
	 * @param sys_id
	 * @param pnumber
	 * @param adhaar_number
	 * @param prefix
	 * @param first_name
	 * @param full_name
	 * @param last_name
	 * @param gender
	 * @param dob
	 * @param mobile
	 * @param whatsapp
	 * @param marital_status
	 * @param email
	 * @param address
	 * @param age
	 * @param occupation
	 * @param emergency_contact
	 * @param area
	 * @param city
	 * @param state
	 * @param country
	 * @param registrDate
	 * @param created
	 * @param created_by
	 * @param updated
	 * @param updated_by
	 * @param userImage
	 */
	public ModelPatient(int sys_id, String pnumber, String adhaar_number, String prefix, String first_name,
			String full_name, String last_name, String gender, Date dob, String mobile, String whatsapp,
			String marital_status, String email, String address, String age, String occupation,
			String emergency_contact, String area, String city, String state, String country, Date registrDate,
			Date created, int created_by, Date updated, int updated_by, byte[] userImage) {
		super();
		this.sys_id = sys_id;
		this.pnumber = pnumber;
		this.adhaar_number = adhaar_number;
		this.prefix = prefix;
		this.first_name = first_name;
		this.full_name = full_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.whatsapp = whatsapp;
		this.marital_status = marital_status;
		this.email = email;
		this.address = address;
		this.age = age;
		this.occupation = occupation;
		this.emergency_contact = emergency_contact;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.registrDate = registrDate;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
		this.userImage = userImage;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getRegistrDate() {
		return registrDate;
	}

	public void setRegistrDate(Date registrDate) {
		this.registrDate = registrDate;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getEmergency_contact() {
        return emergency_contact;
    }
    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
    public int getSys_id() {
        return sys_id;
    }
    public void setSys_id(int sys_id) {
        this.sys_id = sys_id;
    }
    public String getPnumber() {
        return pnumber;
    }
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }
    public String getAdhaar_number() {
        return adhaar_number;
    }
    public void setAdhaar_number(String adhaar_number) {
        this.adhaar_number = adhaar_number;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getWhatsapp() {
        return whatsapp;
    }
    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
    public String getMarital_status() {
        return marital_status;
    }
    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    public int getCreated_by() {
        return created_by;
    }
    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }
    public int getUpdated_by() {
        return updated_by;
    }
    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }
}
