package med.voll.api.Domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
