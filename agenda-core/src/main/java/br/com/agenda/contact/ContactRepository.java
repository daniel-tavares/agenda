package br.com.agenda.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    
	@Query(value="select * from tab_contact c join tab_user u on (u.id=c.fk_id_user) where u.username=?1" ,nativeQuery = true)
	List<Contact> findAllContactByUsername(String username);
}