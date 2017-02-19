package com.ashu.rms.api.common.model;


import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;


@Entity
@Table(name="invoicemaster")

public class InvoiceMaster extends CoreEntity {
	
	public String getGenerated_by() {
		return generated_by;
	}

	public void setGenerated_by(String generated_by) {
		this.generated_by = generated_by;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getApplication_id() {
		return application_id;
	}

	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_on() {
		return modified_on;
	}

	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIs_deleted() {
		return is_deleted;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "generated_by")
	private String generated_by;
	
	@Column(name = "total_amount")
	private String total_amount;
	
	@Column(name = "customer_id")
	private String customer_id;
	
	@Column(name = "application_id")
	private String application_id;
	
	@Column(name = "store_id")
	private String store_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_on")
	private String created_on;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "modified_on")
	private String modified_on;
	
	@Column(name = "modified_by")
	private String modified_by;
	
	@Column(name = "is_deleted")
	private String is_deleted;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getis_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	

	
	

}
