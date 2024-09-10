package com.epatient.restapi.Models;

import jakarta.persistence.*;
import java.util.Date;

//import org.hibernate.annotations.Entity;
//new file updated
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "patients")
public class ModelAppointment {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int	sys_id 	;
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paitents_panumber_seq")
   //@SequenceGenerator(name = "paitents_panumber_seq", sequenceName = "paitents_panumber_seq", allocationSize = 1)
    @Column(name = "appt_number")
    String	appt_number 	;
    @Column(name="appt_date")
    String	appt_date 	;
    @Column(name="appt_time")
    String	appt_time 	;
    @Column(name = "appt_message")
    String	appt_message 	;
    @Column(name = "apply_date")
    String	apply_date 	;
    @Column(name = "remarks")
    String	remarks 	;
    @Column(name = "status")
    String	status 	;
    @Column(name = "doctor_id")
    // Doctor Data
    int doctor_id;
    @Column(name = "specialization")
    String	specialization 	;
  //Patient Data    
    @Column(name = "pat_id")
    int pat_id 	;
    @Column(name = "pat_name")
    String	pat_name 	;
    @Column(name = "pat_mobile")
    String	pat_mobile 	;
    @Column(name = "pat_whatsapp")
    String	pat_whatsapp 	;
    @Column(name = "pat_email")
    String	pat_email 	;
    
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
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date	registrDate 	;
    
    /**
	 * @param sys_id
	 * @param appt_number
	 * @param appt_date
	 * @param appt_time
	 * @param appt_message
	 * @param apply_date
	 * @param remarks
	 * @param status
	 * @param doctor_id
	 * @param specialization
	 * @param pat_id
	 * @param pat_name
	 * @param pat_mobile
	 * @param pat_whatsapp
	 * @param pat_email
	 * @param created
	 * @param updated
	 * @param registrDate
	 * @param created_by
	 * @param updated_by
	 */
	public ModelAppointment(int sys_id, String appt_number, String appt_date, String appt_time, String appt_message,
			String apply_date, String remarks, String status, int doctor_id, String specialization, int pat_id,
			String pat_name, String pat_mobile, String pat_whatsapp, String pat_email, Date created, Date updated,
			Date registrDate, int created_by, int updated_by) {
		super();
		this.sys_id = sys_id;
		this.appt_number = appt_number;
		this.appt_date = appt_date;
		this.appt_time = appt_time;
		this.appt_message = appt_message;
		this.apply_date = apply_date;
		this.remarks = remarks;
		this.status = status;
		this.doctor_id = doctor_id;
		this.specialization = specialization;
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.pat_mobile = pat_mobile;
		this.pat_whatsapp = pat_whatsapp;
		this.pat_email = pat_email;
		this.created = created;
		this.updated = updated;
		this.registrDate = registrDate;
		this.created_by = created_by;
		this.updated_by = updated_by;
	}


	public int getSys_id() {
		return sys_id;
	}


	public void setSys_id(int sys_id) {
		this.sys_id = sys_id;
	}


	public String getAppt_number() {
		return appt_number;
	}


	public void setAppt_number(String appt_number) {
		this.appt_number = appt_number;
	}


	public String getAppt_date() {
		return appt_date;
	}


	public void setAppt_date(String appt_date) {
		this.appt_date = appt_date;
	}


	public String getAppt_time() {
		return appt_time;
	}


	public void setAppt_time(String appt_time) {
		this.appt_time = appt_time;
	}


	public String getAppt_message() {
		return appt_message;
	}


	public void setAppt_message(String appt_message) {
		this.appt_message = appt_message;
	}


	public String getApply_date() {
		return apply_date;
	}


	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public int getPat_id() {
		return pat_id;
	}


	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}


	public String getPat_name() {
		return pat_name;
	}


	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}


	public String getPat_mobile() {
		return pat_mobile;
	}


	public void setPat_mobile(String pat_mobile) {
		this.pat_mobile = pat_mobile;
	}


	public String getPat_whatsapp() {
		return pat_whatsapp;
	}


	public void setPat_whatsapp(String pat_whatsapp) {
		this.pat_whatsapp = pat_whatsapp;
	}


	public String getPat_email() {
		return pat_email;
	}


	public void setPat_email(String pat_email) {
		this.pat_email = pat_email;
	}


	public Date getRegistrDate() {
		return registrDate;
	}


	public void setRegistrDate(Date registrDate) {
		this.registrDate = registrDate;
	}

    public ModelAppointment()
    {}

    
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
