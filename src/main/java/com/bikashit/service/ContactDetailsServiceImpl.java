package com.bikashit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bikashit.dao.ContactDetailsRepository;
import com.bikashit.enity.ContactEntity;
import com.bikashit.model.Contact;
@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {
	@Autowired
	private ContactDetailsRepository contactRepo;

	@Override
	@Transactional
	public boolean saveContact(Contact c) {
		ContactEntity entity=new ContactEntity();
	    BeanUtils.copyProperties(c, entity);
	    ContactEntity isSaved = contactRepo.save(entity);
		return isSaved!=null;
	}

	@Override
	@Transactional(readOnly =true)
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities=contactRepo.findAll();
		return entities.stream().map(entity->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Contact GetContactById(Integer cid) {
		Optional<ContactEntity> findById = contactRepo.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}

}
