package br.com.agenda.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {
  
	@Autowired
	ContactRepository contatoRepository;
	
	@Override
	public Contact save(Contact contato) {
		return contatoRepository.save(contato);
	}

	@Override
	public List<Contact> findAllContactByUsername(String username) {
		return contatoRepository.findAllContactByUsername(username);
	}

	@Override
	public void delete(long id) {
		contatoRepository.delete(id);
	}
}