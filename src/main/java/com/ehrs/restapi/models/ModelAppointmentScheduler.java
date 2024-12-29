package com.ehrs.restapi.models;

import jakarta.persistence.*;
import java.util.Date;

//import org.hibernate.annotations.Entity;
//new file updated
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "doc_appointment_scheduler")
public class ModelAppointmentScheduler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int	sys_id 	;
	@Column(name = "schedule_id")
    String	schedule_id 	;
	@Column(name = "avail_days")
    String	avail_days 	;
	@Column(name = "slot")
    String	slot 	;
	@Column(name = "start_date")
    String	start_date 	;
    @Column(name="end_date")
    String	end_date 	;
    @Column(name="start_time")
    String	start_time 	;
    @Column(name="end_time")
    String	end_time 	;
    @Column(name = "comments")
    String	comments 	;
    @Column(name = "doctor_id")
    String	doctor_id 	;
    @Column(name = "doctor_name")
    String	doctor_name 	;   
    @Column(name = "doctor_mobile")
    String	doctor_mobile 	;
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
	 * @param sys_id
	 * @param schedule_id
	 * @param avail_days
	 * @param slot
	 * @param start_date
	 * @param end_date
	 * @param start_time
	 * @param end_time
	 * @param comments
	 * @param doctor_id
	 * @param doctor_name
	 * @param doctor_mobile
	 * @param status
	 
	 * @param created
	 * @param created_by
	 * @param updated
	 * @param updated_by
	 */
	
	public ModelAppointmentScheduler()
	{}
	
	public ModelAppointmentScheduler(int sys_id, String schedule_id,String avail_days, String slot, String start_date, String end_date, String start_time,String end_time,
			String comments, String doctor_id, String doctor_name, String doctor_mobile, boolean status,  Date created, int created_by, Date updated,int updated_by) {
		super();
		this.sys_id = sys_id;
		this.schedule_id = schedule_id;
		this.avail_days = avail_days;
		this.slot = slot;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.comments = comments;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_mobile = doctor_mobile;
		this.status = status;
		
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}

	
	
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	
	public String getAvail_days() {
		return avail_days;
	}

	public void setAvail_days(String avail_days) {
		this.avail_days = avail_days;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_mobile() {
		return doctor_mobile;
	}

	public void setDoctor_mobile(String doctor_mobile) {
		this.doctor_mobile = doctor_mobile;
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
