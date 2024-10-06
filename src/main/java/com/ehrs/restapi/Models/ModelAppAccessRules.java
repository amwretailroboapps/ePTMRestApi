package com.ehrs.restapi.Models;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "AppAccessRules")
public class ModelAppAccessRules 
{
	/**
	 * @param sys_id
	 * @param mobile
	 * @param login_id
	 * @param role_name
	 * @param status
	 * @param lastresponse
	 * @param created
	 * @param created_by
	 * @param updated
	 * @param updated_by
	 */
	public ModelAppAccessRules()
	{}
	
	public ModelAppAccessRules(int sys_id, int login_id, String mobile, String role_name,
			boolean status,String lastresponse, Date created, int created_by, Date updated, int updated_by) {
		super();
		this.sys_id = sys_id;
		this.login_id = login_id;
		this.mobile = mobile;
		this.role_name = role_name;
		this.status = status;
		this.lastresponse = lastresponse;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sys_id")
    int	sys_id 	;
	@Column(name="login_id")
    int	login_id 	;
	
	@Column(name="mobile")
    String	mobile 	;
	@Column(name="role_name")
    String	role_name 	;
	@Column(name="status")
    boolean	status 	;
	@Column(name="lastresponse")
    String	lastresponse 	;

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
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	 * @return the lastresponse
	 */
	public String getLastresponse() {
		return lastresponse;
	}

	/**
	 * @param lastresponse the lastresponse to set
	 */
	public void setLastresponse(String lastresponse) {
		this.lastresponse = lastresponse;
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

	/**
	 * @return the login_id
	 */
	public int getLogin_id() {
		return login_id;
	}

	/**
	 * @param login_id the login_id to set
	 */
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	    
	
    
    
   
    
    
}
