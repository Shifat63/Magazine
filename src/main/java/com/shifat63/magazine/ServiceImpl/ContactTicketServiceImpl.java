package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.ContactTicket;
import com.shifat63.magazine.Repositories.ContactTicketRepository;
import com.shifat63.magazine.Service.ContactTicketService;

@Service
@Profile({"springdatajpa"})
public class ContactTicketServiceImpl implements ContactTicketService{

	private ContactTicketRepository contactTicketRepository;
	
	public ContactTicketServiceImpl(ContactTicketRepository contactTicketRepository) {
		this.contactTicketRepository = contactTicketRepository;
	}
	
	@Override
	public Set<ContactTicket> findAll() throws Exception {
		Set<ContactTicket> contactTicketSet = new HashSet<>();
        contactTicketRepository.findAll().forEach(contactTicketSet::add);
        return contactTicketSet;
	}

	@Override
	public ContactTicket findById(Integer id) throws Exception {
		return contactTicketRepository.findById(id).get();
	}

	@Override
	public ContactTicket save(ContactTicket object) throws Exception {
		return contactTicketRepository.save(object);
	}

	@Override
	public void delete(ContactTicket object) throws Exception {
		contactTicketRepository.delete(object);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		contactTicketRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		contactTicketRepository.deleteAll();
	}

}
