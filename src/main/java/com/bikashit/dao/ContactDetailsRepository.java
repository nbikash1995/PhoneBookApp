package com.bikashit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikashit.enity.ContactEntity;

public interface ContactDetailsRepository extends JpaRepository<ContactEntity, Integer> {

}
