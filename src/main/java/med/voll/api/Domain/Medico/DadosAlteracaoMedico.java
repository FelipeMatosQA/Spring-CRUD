package med.voll.api.Domain.Medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Domain.Endereco.DadosEndereco;

public record DadosAlteracaoMedico(
        @NotNull(message = "{id.obrigatorio}")
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
