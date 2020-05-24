package com.company.service;

import java.util.List;
import java.util.Optional;

import com.company.entities.Client;

public interface ClientService {
	public List<Client> findAllClients();
	public Client findClientById(String id);
	public Client createClient(Client client);
	public Client updateClient(Client client);
	public void deleteClient(Client client);
}
