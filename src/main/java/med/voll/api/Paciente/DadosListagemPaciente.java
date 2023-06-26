package med.voll.api.Paciente;

public record DadosListagemPaciente(
        String nome,
        String email,
        String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
