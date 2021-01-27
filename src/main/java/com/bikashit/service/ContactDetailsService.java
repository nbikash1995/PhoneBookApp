package com.bikashit.service;

import java.util.List;

import com.bikashit.model.Contact;

public interface ContactDetailsService {
	public boolean saveContact(Contact c);
	public List<Contact> getAllContacts();
	public Contact GetContactById(Integer cid);
	public boolean deleteContact(Integer cid);

}
