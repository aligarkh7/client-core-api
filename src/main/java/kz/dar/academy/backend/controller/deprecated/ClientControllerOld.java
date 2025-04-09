package kz.dar.academy.backend.controller.deprecated;

import jakarta.validation.Valid;
import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.service.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deprecated/client")
public class ClientControllerOld {

    @Autowired
    ClientServiceOld clientServiceOld;

    @GetMapping("/check")
    public ResponseEntity<String> checkClient(){
        return ResponseEntity.ok("client-core-api is working");
    }

    @PostMapping
    public ResponseEntity<String> createClientModel(@Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.createClientModel(clientModel);
        return ResponseEntity.ok("Client Model Created");
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClientModels() {
        return clientServiceOld.getAllClientModels();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientModel> getClientModelById(@PathVariable String clientId) {
        return ResponseEntity.ok(clientServiceOld.getClientModelById(clientId));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientModelById(@PathVariable String clientId,
                                                   @Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.updateClientModelById(clientId, clientModel);
        return ResponseEntity.ok("Client Model Updated");
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientModelById(@PathVariable String clientId) {
        clientServiceOld.deleteClientModelById(clientId);
        return ResponseEntity.ok("Client Model Deleted");
    }
}
