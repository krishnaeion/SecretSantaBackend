package com.rishi.SecretSantaBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rishi.SecretSantaBackend.Entity.Child;

public interface ChildRepository extends JpaRepository<Child,Integer> {

	Child findByUsername(Integer username);
	
	
	@Query("INSERT INTO child (full_name,city,santa_id,number,user_name,password,emailId,address)"
			+ "VALUES"+
			"(:child.name,:child.city,:child.santaId,child.number,:child.username,:child.password,:child.emailId,:child.address)")
	void savechild(Child  child);
	
	
}