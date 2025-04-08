package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientModel;

import java.util.List;

public interface ClientService {
    void createClientModel(ClientModel clientModel);
    List<ClientModel> getAllClientModels();
    ClientModel getClientModelById(String clientId);
    void updateClientModelById(String clientId, ClientModel clientModel);
    void deleteClientModelById(String clientId);
}
