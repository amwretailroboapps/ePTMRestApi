package com.epatient.restapi.Models;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "loginusers")
public class ModelAppLoginUser 
{
	/**
	 * @param sys_id
	 * @param username
	 * @param password
	 * @param mobile
	 * @param pin
	 * @param role_name
	 * @param status
	 * @param created
	 * @param created_by
	 * @param updated
	 * @param updated_by
	 */
	public ModelAppLoginUser()
	{}
	
	public ModelAppLoginUser(int sys_id, String username, String password, String mobile, String pin, String role_name,
			boolean status, Date created, int created_by, Date updated, int updated_by) {
		super();
		this.sys_id = sys_id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.pin = pin;
		this.role_name = role_name;
		this.status = status;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sys_id")
    int	sys_id 	;
	
	//@Column(nullable = false, unique = true)
	@Column(name="username")
    private String username;
	
	//@Column(nullable = false)
	@Column(name="password")
    private String password;
	
	//@Column(nullable = false, unique = true)
	@Column(name="mobile")
    private String mobile;
	
    //@Column(nullable = false)
    @Column(name="pin")
    private String pin;
	
    //@Column(nullable = false)
    @Column(name="role_name")
    private String role_name;
    
    //@Column(nullable = false)
    @Column(name="status")
    private boolean status;
	    
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
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
