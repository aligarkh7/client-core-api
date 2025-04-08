package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{

    private static final HashMap<String, ClientModel> clientModelHashMap = new HashMap<>();

    @Override
    public void createClientModel(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientModelHashMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClientModels() {
        return new ArrayList<>(clientModelHashMap.values());
    }

    @Override
    public ClientModel getClientModelById(String clientId) {
        return clientModelHashMap.get(clientId);
    }

    @Override
    public void updateClientModelById(String clientId, ClientModel clientModel) {
        if (clientModelHashMap.containsKey(clientId)){
            clientModel.setClientId(clientId);
            clientModelHashMap.put(clientModel.getClientId(), clientModel);
        }
    }

    @Override
    public void deleteClientModelById(String clientId) {
        clientModelHashMap.remove(clientId);
    }
}
