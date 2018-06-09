package br.com.agenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.core.user.User;
import br.com.agenda.core.user.UserService;
import br.com.agenda.response.ApiResponse;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ApiResponse<User> response;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
      	return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> save(@Valid @RequestBody  User user,  BindingResult result){
        
    	if(result.hasErrors()) {
    		response.getErrors().clear();
        	result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
        }
    	
    	
    	response.setData(userService.save(user));
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(response); 
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }
    
    
    @PutMapping
    public User update(@RequestBody User user){
        return userService.save(user);
    }

}