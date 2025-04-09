package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    List<ClientResponse> getAllClients();
    ClientResponse getClientByClientId(String clientId);
    ClientResponse updateClientByClientId(String clientId, ClientRequest clientRequest);
    void deleteClientByClientId(String clientId);
}
