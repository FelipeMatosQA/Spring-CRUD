package med.voll.api.Domain.Paciente;

import med.voll.api.Domain.Endereco.Endereco;

public record DadosListagemPaciente(Long id,
                                    String nome,
                                    String email,
                                    String telefone,
                                    Endereco endereco) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }
}
