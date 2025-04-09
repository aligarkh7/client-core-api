package kz.dar.academy.backend.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRequest {
    private String clientId;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Email
    private String email;
}
