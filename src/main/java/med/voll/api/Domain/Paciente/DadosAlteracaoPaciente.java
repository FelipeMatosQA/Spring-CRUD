package med.voll.api.Domain.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Domain.Endereco.Endereco;

public record DadosAlteracaoPaciente(

        @NotNull
        Long id,
        String nome,
        Endereco endereco,
        String telefone) {
}
