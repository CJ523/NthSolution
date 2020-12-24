package com.NthSolution;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Integer>{
	//public List<Members> findAll();

}
