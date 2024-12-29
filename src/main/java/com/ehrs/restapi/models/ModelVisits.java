package com.ehrs.restapi.models;

import jakarta.persistence.*;
import java.util.Date;

//import org.hibernate.annotations.Entity;
//new file updated
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "pat_visits")
public class ModelVisits {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int	sys_id 	;
   
    // Doctor Data
    @Column(name = "doctor_id")
    int doctor_id;
    @Column(name = "doctor_mobile")
    String	doctor_mobile 	;
    @Column(name = "doctor_name")
    String	doctor_name 	;
    
    @Column(name = "remarks")
    String	remarks 	;
    @Column(name = "status")
    String	status 	;
    
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
    
    //Appointment data
    @Column(name="appointment_sys_id")
    int	appointment_sys_id 	;
    @Column(name="appt_number")
    String	appt_number 	;
    @Column(name="appt_date")
    String	appt_date 	;
    @Column(name="appt_time")
    String	appt_time 	;
    @Column(name = "appt_message")
    String	appt_message 	;
    
    //Visit Data
    @Column(name="visit_date")
    String	visit_date 	;
    @Column(name="visit_time")
    String	visit_time 	;
    @Column(name = "visit_remark")
    String	visit_remark 	;
    @Column(name = "visit_treatment")
    String	visit_treatment	;
    
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
	public ModelVisits(int sys_id, int doctor_id, String doctor_mobile, String doctor_name, String remarks,
			String status, int pat_id, String pat_name, String pat_mobile, String pat_whatsapp, String pat_email,
			int appointment_sys_id, String appt_number, String appt_date, String appt_time, String appt_message,
			String visit_date, String visit_time, String visit_remark, String visit_treatment, Date created,
			int created_by, Date updated, int updated_by) {
		super();
		this.sys_id = sys_id;
		this.doctor_id = doctor_id;
		this.doctor_mobile = doctor_mobile;
		this.doctor_name = doctor_name;
		this.remarks = remarks;
		this.status = status;
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.pat_mobile = pat_mobile;
		this.pat_whatsapp = pat_whatsapp;
		this.pat_email = pat_email;
		this.appointment_sys_id = appointment_sys_id;
		this.appt_number = appt_number;
		this.appt_date = appt_date;
		this.appt_time = appt_time;
		this.appt_message = appt_message;
		this.visit_date = visit_date;
		this.visit_time = visit_time;
		this.visit_remark = visit_remark;
		this.visit_treatment = visit_treatment;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}
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
	 * @return the doctor_id
	 */
	public int getDoctor_id() {
		return doctor_id;
	}
	/**
	 * @param doctor_id the doctor_id to set
	 */
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	/**
	 * @return the doctor_mobile
	 */
	public String getDoctor_mobile() {
		return doctor_mobile;
	}
	/**
	 * @param doctor_mobile the doctor_mobile to set
	 */
	public void setDoctor_mobile(String doctor_mobile) {
		this.doctor_mobile = doctor_mobile;
	}
	/**
	 * @return the doctor_name
	 */
	public String getDoctor_name() {
		return doctor_name;
	}
	/**
	 * @param doctor_name the doctor_name to set
	 */
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the pat_id
	 */
	public int getPat_id() {
		return pat_id;
	}
	/**
	 * @param pat_id the pat_id to set
	 */
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	/**
	 * @return the pat_name
	 */
	public String getPat_name() {
		return pat_name;
	}
	/**
	 * @param pat_name the pat_name to set
	 */
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	/**
	 * @return the pat_mobile
	 */
	public String getPat_mobile() {
		return pat_mobile;
	}
	/**
	 * @param pat_mobile the pat_mobile to set
	 */
	public void setPat_mobile(String pat_mobile) {
		this.pat_mobile = pat_mobile;
	}
	/**
	 * @return the pat_whatsapp
	 */
	public String getPat_whatsapp() {
		return pat_whatsapp;
	}
	/**
	 * @param pat_whatsapp the pat_whatsapp to set
	 */
	public void setPat_whatsapp(String pat_whatsapp) {
		this.pat_whatsapp = pat_whatsapp;
	}
	/**
	 * @return the pat_email
	 */
	public String getPat_email() {
		return pat_email;
	}
	/**
	 * @param pat_email the pat_email to set
	 */
	public void setPat_email(String pat_email) {
		this.pat_email = pat_email;
	}
	/**
	 * @return the appointment_sys_id
	 */
	public int getAppointment_sys_id() {
		return appointment_sys_id;
	}
	/**
	 * @param appointment_sys_id the appointment_sys_id to set
	 */
	public void setAppointment_sys_id(int appointment_sys_id) {
		this.appointment_sys_id = appointment_sys_id;
	}
	/**
	 * @return the appt_number
	 */
	public String getAppt_number() {
		return appt_number;
	}
	/**
	 * @param appt_number the appt_number to set
	 */
	public void setAppt_number(String appt_number) {
		this.appt_number = appt_number;
	}
	/**
	 * @return the appt_date
	 */
	public String getAppt_date() {
		return appt_date;
	}
	/**
	 * @param appt_date the appt_date to set
	 */
	public void setAppt_date(String appt_date) {
		this.appt_date = appt_date;
	}
	/**
	 * @return the appt_time
	 */
	public String getAppt_time() {
		return appt_time;
	}
	/**
	 * @param appt_time the appt_time to set
	 */
	public void setAppt_time(String appt_time) {
		this.appt_time = appt_time;
	}
	/**
	 * @return the appt_message
	 */
	public String getAppt_message() {
		return appt_message;
	}
	/**
	 * @param appt_message the appt_message to set
	 */
	public void setAppt_message(String appt_message) {
		this.appt_message = appt_message;
	}
	/**
	 * @return the visit_date
	 */
	public String getVisit_date() {
		return visit_date;
	}
	/**
	 * @param visit_date the visit_date to set
	 */
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	/**
	 * @return the visit_time
	 */
	public String getVisit_time() {
		return visit_time;
	}
	/**
	 * @param visit_time the visit_time to set
	 */
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	/**
	 * @return the visit_remark
	 */
	public String getVisit_remark() {
		return visit_remark;
	}
	/**
	 * @param visit_remark the visit_remark to set
	 */
	public void setVisit_remark(String visit_remark) {
		this.visit_remark = visit_remark;
	}
	/**
	 * @return the visit_treatment
	 */
	public String getVisit_treatment() {
		return visit_treatment;
	}
	/**
	 * @param visit_treatment the visit_treatment to set
	 */
	public void setVisit_treatment(String visit_treatment) {
		this.visit_treatment = visit_treatment;
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
