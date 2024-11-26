package com.ehrs.restapi.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class ModelExpense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int	sys_id 	;
	
	@Column(name = "expense_name")
    private String expense_name;
	
	@Column(name = "expense_amount")
    private String expense_amount;
	
	@Column(name = "expense_date")
    private String expense_date;
	
	@Column(name = "expense_category")
    private String expense_category;
	
	@Column(name = "expense_source")
    private String expense_source;
	
	@Column(name = "reference_num")
    private String reference_num;
	
	@Column(name = "approver_comments")
    private String approver_comments;
	
	@Column(name = "approval_staus", columnDefinition = "boolean default false")
    private boolean approval_staus;
	
	@Column(name = "approval_date")
    private String approval_date;
	
	@Column(name = "imageURL")
    private String imageURL;
		
	public int getSys_id() {
		return sys_id;
	}

	public void setSys_id(int sys_id) {
		this.sys_id = sys_id;
	}

	public String getApprover_comments() {
		return approver_comments;
	}

	public void setApprover_comments(String approver_comments) {
		this.approver_comments = approver_comments;
	}

	public boolean isApproval_staus() {
		return approval_staus;
	}

	public void setApproval_staus(boolean approval_staus) {
		this.approval_staus = approval_staus;
	}

	public String getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(String approval_date) {
		this.approval_date = approval_date;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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

  

    public String getExpense_name() {
        return expense_name;
    }

    public void setExpense_name(String expense_name) {
        this.expense_name = expense_name;
    }

    public String getExpense_amount() {
        return expense_amount;
    }

    public void setExpense_amount(String expense_amount) {
        this.expense_amount = expense_amount;
    }

    public String getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(String expense_date) {
        this.expense_date = expense_date;
    }

    public String getExpense_category() {
        return expense_category;
    }

    public void setExpense_category(String expense_category) {
        this.expense_category = expense_category;
    }

    public String getExpense_source() {
        return expense_source;
    }

    public void setExpense_source(String expense_source) {
        this.expense_source = expense_source;
    }

    public String getReference_num() {
        return reference_num;
    }

    public void setReference_num(String reference_num) {
        this.reference_num = reference_num;
    }

    public String getExpense_attachment() {
        return imageURL;
    }

    public void setExpense_attachment(String imageURL) {
        this.imageURL = imageURL;
    }


    public ModelExpense(int sys_id, String expense_name, String expense_amount, String expense_date,
			String expense_category, String expense_source, String reference_num, String approver_comments,
			boolean approval_staus, String approval_date, String imageURL, Date created, int created_by, Date updated,
			int updated_by) {
		super();
		this.sys_id = sys_id;
		this.expense_name = expense_name;
		this.expense_amount = expense_amount;
		this.expense_date = expense_date;
		this.expense_category = expense_category;
		this.expense_source = expense_source;
		this.reference_num = reference_num;
		this.approver_comments = approver_comments;
		this.approval_staus = approval_staus;
		this.approval_date = approval_date;
		this.imageURL = imageURL;
		this.created = created;
		this.created_by = created_by;
		this.updated = updated;
		this.updated_by = updated_by;
	}

	public ModelExpense() {

    }
}
