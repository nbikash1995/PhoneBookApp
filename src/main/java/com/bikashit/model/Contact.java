package com.bikashit.model;

import java.util.Date;

import lombok.Data;
@Data
public class Contact {
	private  static final long serialVersionUID=1L;
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private String contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
