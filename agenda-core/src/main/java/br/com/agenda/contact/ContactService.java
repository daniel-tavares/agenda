package br.com.agenda.contact;

import java.util.List;

public interface ContactService {
	Contact save(Contact user);
    List<Contact> findAllContactByUsername(String username);
    void delete(long id);
}