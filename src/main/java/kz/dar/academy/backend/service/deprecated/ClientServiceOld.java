package kz.dar.academy.backend.service.deprecated;

import kz.dar.academy.backend.model.ClientModel;

import java.util.List;

public interface ClientServiceOld {
    void createClientModel(ClientModel clientModel);
    List<ClientModel> getAllClientModels();
    ClientModel getClientModelById(String clientId);
    void updateClientModelById(String clientId, ClientModel clientModel);
    void deleteClientModelById(String clientId);
}
