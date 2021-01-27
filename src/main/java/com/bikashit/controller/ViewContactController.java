package com.bikashit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikashit.model.Contact;
import com.bikashit.service.ContactDetailsService;

@Controller
public class ViewContactController {
	@Autowired
	private ContactDetailsService contactDetailsService;
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) {
		Contact c = contactDetailsService.GetContactById(contactId);
		model.addAttribute("contact", c);
		return "viewContact";
	}
	@RequestMapping("/deleteContact")
	public String deleteContactById(@RequestParam("cid") Integer contactId,Model model) {
		boolean isDeleted = contactDetailsService.deleteContact(contactId);
		if(isDeleted) {
			return "redirect:/viewContact";
		}
		return null;
	}

}
