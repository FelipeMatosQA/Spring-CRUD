package med.voll.api.Paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Endereco.DadosEndereco;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @Valid
        @NotNull
        DadosEndereco endereco) {
}
