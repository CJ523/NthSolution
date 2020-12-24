package com.NthSolution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/members")
	public List<Members> list(){
		return service.listAll();
	}
}
