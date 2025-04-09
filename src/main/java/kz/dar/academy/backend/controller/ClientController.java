package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/check")
    public ResponseEntity<String> checkClient(){
        return ResponseEntity.ok("client-core-api is working");
    }

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping
    public ClientResponse getClientByClientId(@RequestParam String clientId) {
        return clientService.getClientByClientId(clientId);
    }

    @PutMapping
    public ClientResponse  updateClient(@RequestParam String clientId,
                                        @RequestBody ClientRequest clientRequest) {
        return clientService.updateClientByClientId(clientId, clientRequest);
    }

    @DeleteMapping
    public void deleteClientByClientId(@RequestParam String clientId) {
        clientService.deleteClientByClientId(clientId);
    }

}
