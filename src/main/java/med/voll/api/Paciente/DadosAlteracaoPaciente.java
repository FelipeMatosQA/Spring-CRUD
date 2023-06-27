package med.voll.api.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.Endereco;

public record DadosAlteracaoPaciente(

        @NotNull
        Long id,
        String nome,
        Endereco endereco,
        String telefone) {
}
