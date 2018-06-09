package br.com.agenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.contact.Contact;
import br.com.agenda.contact.ContactService;
import br.com.agenda.core.user.UserService;
import br.com.agenda.response.ApiResponse;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	ApiResponse<Contact> response;


	
	@GetMapping
	public ResponseEntity<List<Contact>> find() {
		
		return null; //ResponseEntity.ok().body(contactService.findAllContactByUsername(username));
	}
	

	@PostMapping
	public ResponseEntity<ApiResponse<Contact>> save(@Valid @RequestBody Contact contact,@PathVariable String username, BindingResult result) {
		
		if(result.hasErrors()) {
			response.getErrors().clear();
        	result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
        }
    	
	
		contact.setUser(userService.findUserByUsername(username));
    	response.setData(contactService.save(contact));
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping
	public void delete(@PathVariable(value = "id") Long id) {
		contactService.delete(id);
    }

	@PutMapping
	public ResponseEntity<ApiResponse<Contact>> update(@Valid @RequestBody Contact contact, BindingResult result) {
		
		if(result.hasErrors()) {
			response.getErrors().clear();
        	result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
        }
    	
	
		//contact.setUser(userService.findUserByUsername(username));
    	response.setData(contactService.save(contact));
    	
		return ResponseEntity.ok().body(response);
	}
}
