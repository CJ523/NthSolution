package com.NthSolution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MembersRepository repo;
	
	public List<Members> listAll(){
		return repo.findAll();
	}
	
	public void save(Members members) {
		repo.save(members);
	}
	
	public Members get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
