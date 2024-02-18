package com.rishi.SecretSantaBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rishi.SecretSantaBackend.Entity.Santa;

public interface SantaRepository extends JpaRepository<Santa,Integer> {

	Santa findByUsername(Integer username);
	
	
	@Query("INSERT INTO santa (santa_name,city,number,user_name,password,emailId)"
			+ "VALUES"+
			"(:santa.name,:santa.city,:santa.number,:santa.username,:santa.password,:santa.emailId)")
	void saveSanta(Santa santa);
	
	
}
