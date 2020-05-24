package com.company.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.company.entities.Client;
import com.company.repository.ClientRepository;


public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public java.util.List<Client> findAllClients() {
	
		return this.clientRepository.findAll();
	}
	

	@Override
	public Client findClientById(String id) {
		// TODO Auto-generated method stub
		return this.clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public Client createClient(Client client) {
		return this.clientRepository.save(client);
	}


	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	
}
