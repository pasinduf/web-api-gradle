package com.webapi.main.services.domain;

import org.springframework.data.domain.Persistable;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;

public abstract class BaseEntity implements Persistable<String>{

	@Id
	protected String id;
	
	@CreatedDate
	protected Date createdDate;
	
	@CreatedBy
	protected String createdBy;
	
	@LastModifiedDate
	protected Date lastModifiedDate;
	
	@LastModifiedBy
	protected String lastModifiedBy;

	protected boolean deleted=false;
	
	public BaseEntity() {		
	}
	
	public BaseEntity(String id, Date createdDate, String createdBy, Date lastModifiedDate, String lastModifiedBy) {
		this.id = id;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	@Override
	  public boolean isNew() {
	    return (null == createdDate || null == createdBy);
	  }
	
	
}
