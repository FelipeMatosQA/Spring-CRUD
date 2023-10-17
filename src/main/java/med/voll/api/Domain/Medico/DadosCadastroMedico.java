package med.voll.api.Domain.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Domain.Endereco.DadosEndereco;

import java.beans.XMLEncoder;

public record DadosCadastroMedico(

        @NotBlank(message = "{nome.obrigatorio}")
        String nome,

        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,

        @NotBlank(message = "{telefone.obrigatorio}")
        String telefone,

        @NotBlank(message = "{cmr.obrigatorio}")
        @Pattern(regexp = "\\d{4,6}",message = "{crm.invalido}")
        String crm,

        @NotNull(message = "{especialidade.obrigatorio}")
        Especialidade especialidade,

        @NotNull(message = "{endereco.obrigatorio}")
        @Valid
        DadosEndereco endereco) {
}
