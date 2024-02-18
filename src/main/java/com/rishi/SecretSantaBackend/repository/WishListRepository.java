package com.rishi.SecretSantaBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rishi.SecretSantaBackend.Entity.Child;
import com.rishi.SecretSantaBackend.Entity.WishList;

public interface WishListRepository extends JpaRepository<Child,Integer> {

	Child findByUsername(Integer username);
	
	
	@Query("INSERT INTO wish_list (name,link,pic_data,child_id)"
			+ "VALUES"+
			"(:wishList.name,:wishList.link,:wishList.pic_data,:wishList.child_id)")
	void savechild(WishList wishList);
	
	
}