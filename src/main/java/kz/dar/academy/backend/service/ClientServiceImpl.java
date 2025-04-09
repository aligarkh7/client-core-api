package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.repository.ClientEntity;
import kz.dar.academy.backend.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientId(UUID.randomUUID().toString());
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        clientRepository.save(clientEntity);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientRepository.findClientEntitiesBy().stream().map(clientEntity -> modelMapper.map(clientEntity, ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClientByClientId(String clientId) {
        ClientEntity clientEntity = clientRepository.findClientEntityByClientId(clientId);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse updateClientByClientId(String clientId, ClientRequest clientRequest) {
        clientRequest.setClientId(clientId);
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);

        ClientEntity dbClientEntity = clientRepository.findClientEntityByClientId(clientRequest.getClientId());

        clientEntity.setId(dbClientEntity.getId());

        clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public void deleteClientByClientId(String clientId) {
        clientRepository.deleteClientEntityByClientId(clientId);
    }
}
