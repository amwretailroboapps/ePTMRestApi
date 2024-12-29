package com.ehrs.restapi.models;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "party_details")
public class ModelPartyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sys_id")
    int	sys_id 	;
	
	@Column(name="party_id")
	private String party_id;
	
	@Column(name="party_parent_id")
	private String party_parent_id;
	
	@Column(name="party_type")
    private String party_type; // e.g., Head Office, Branch, Employee, Agent
	@Column(name="name")
    private String name;
	@Column(name="registration_number")
    private String registration_number;
	
	@Column(name="website")
    private String website;
	
	@Column(name="address")
    private String address;
	
	@Column(name="city")
    private String city;
	
	@Column(name="state")
    private String state;
	@Column(name="country")
    private String country;
	@Column(name="pin")
    private String pin;
	@Column(name="established_date")
    private String established_date;		
    @Column(name="contactNumber1")
    private String contactNumber1;
    @Column(name="contactNumber2")
    private String contactNumber2;
    @Column(name="contactNumber3")
    private String contactNumber3;
    @Column(name="contactNumber4")
    private String contactNumber4;
    @Column(name="contactNumber5")
    private String contactNumber5;
    @Column(name="email")
    private String email;
    @Column(name="notes")
    private String notes;
    @Column(name="status")
    private Boolean status;
   
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
    
    public ModelPartyDetails()
    {}
    
	public ModelPartyDetails(int sys_id, String party_id, String party_type, String name, String registration_number,
			String website, String address, String city, String state, String country, String pin,
			String established_date, String contactNumber1, String contactNumber2, String contactNumber3,
			String contactNumber4, String contactNumber5, String email, String notes, Boolean status, Date created,
			int created_by, Date updated, int updated_by) {
		super();
		this.sys_id = sys_id;
		this.party_id = party_id;
		this.party_type = party_type;
		this.name = name;
		this.registration_number = registration_number;
		this.website = website;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.established_date = established_date;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.contactNumber3 = contactNumber3;
		this.contactNumber4 = contactNumber4;
		this.contactNumber5 = contactNumber5;
		this.email = email;
		this.notes = notes;
		this.status = status;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}

	public int getSys_id() {
		return sys_id;
	}

	public void setSys_id(int sys_id) {
		this.sys_id = sys_id;
	}

	
	public String getParty_id() {
		return party_id;
	}

	public void setParty_id(String party_id) {
		this.party_id = party_id;
	}

	public String getParty_parent_id() {
		return party_parent_id;
	}

	public void setParty_parent_id(String party_parent_id) {
		this.party_parent_id = party_parent_id;
	}

	public String getParty_type() {
		return party_type;
	}

	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getEstablished_date() {
		return established_date;
	}

	public void setEstablished_date(String established_date) {
		this.established_date = established_date;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	public String getContactNumber3() {
		return contactNumber3;
	}

	public void setContactNumber3(String contactNumber3) {
		this.contactNumber3 = contactNumber3;
	}

	public String getContactNumber4() {
		return contactNumber4;
	}

	public void setContactNumber4(String contactNumber4) {
		this.contactNumber4 = contactNumber4;
	}

	public String getContactNumber5() {
		return contactNumber5;
	}

	public void setContactNumber5(String contactNumber5) {
		this.contactNumber5 = contactNumber5;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

    
    
}
