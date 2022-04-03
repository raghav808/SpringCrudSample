package com.raghavrs.contactbook.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raghavrs.contactbook.model.entity.Contact;
import com.raghavrs.contactbook.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getContancts(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("listOfContacts", contactService.getAllContancts());
		return "homePage";
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addCountry(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			bindingResult.resolveMessageCodes("Error message only");
			System.out.println(bindingResult.getAllErrors().toString()); 
			model.addAttribute("contact", contact);
			model.addAttribute("listOfContacts", contactService.getAllContancts());
			return "homePage";
		}

//		contactService.addContact(contact);
		
		if (contact.getId() == null) {
			contactService.addContact(contact);
		} else {
			contactService.updateContact(contact);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/updateContact/{id}", method = RequestMethod.GET)
	public String updateCountry(@PathVariable("id") String id, Model model) {
		model.addAttribute("contact", contactService.getContact(Long.parseLong(id)));
		model.addAttribute("listOfContacts", contactService.getAllContancts());
		return "homePage";
	}

	@RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.GET)
	public String deleteCountry(@PathVariable("id") String id) {
		contactService.deleteContact(Long.parseLong(id));
		return "redirect:/";

	}
}
