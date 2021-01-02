package com.NthSolution;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;*/

@RestController
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/members")
	public List<Members> list(){
		return service.listAll();
	}
	
	@GetMapping("/members/{id}")
	public ResponseEntity<Members> get(@PathVariable Integer id) {
		try {
		Members members = service.get(id);
		return new ResponseEntity<Members>(members, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Members>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("/members")
	public void add(@RequestBody Members members) {
		service.save(members);
	}
	
	@PutMapping("/members/{id}")
	public ResponseEntity<?> update(@RequestBody Members members,
			@PathVariable Integer id) {
		try {
		Members existMembers = service.get(id);
		service.save(members);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	@DeleteMapping("/members/{id}")
	  public void delete(@PathVariable Integer id) {
		  service.delete(id);
	  }
	
}
