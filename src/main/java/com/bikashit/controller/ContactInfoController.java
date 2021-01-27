package com.bikashit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bikashit.model.Contact;
import com.bikashit.service.ContactDetailsService;


@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactDetailsService contactDetailsService;

	@GetMapping(value = "/addContact")
	public String loadForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";
	}
	@PostMapping(value = "/saveContact")
	public String handleSubmitButton(@ModelAttribute("contact") Contact c,Model model) {
		boolean isSaved = contactDetailsService.saveContact(c);
		if(isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		}else {
			model.addAttribute("errMsg", "Contact Not Saved");
		}
		return "contactInfo";
	}
	
	public String viewConteact(Model model) {
		List<Contact> allContacts = contactDetailsService.getAllContacts();
		model.addAllAttributes(allContacts);
		return "viewContact";
	}

}
