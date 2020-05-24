package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Client;
import com.company.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public java.util.List<Client> findAllClients() {

		return this.clientRepository.findAll();
	}

	@Override
	public Client findClientById(String id) {
		return this.clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public Client createClient(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public void deleteClientById(String id) {
		clientRepository.deleteById(id);
	}

}
