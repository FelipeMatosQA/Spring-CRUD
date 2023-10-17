package med.voll.api.Domain.Paciente;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Domain.Endereco.Endereco;

@Table(name ="pacientes")
@Entity(name ="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    @Embedded
    private Endereco endereco;
    @Digits(integer = 11, fraction = 0)
    private String telefone;
    private Boolean situacao;

    public Paciente(DadosCadastroPaciente dados){
        this.situacao = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
    }


    public void atualizarInformacoes(DadosAlteracaoPaciente dados) {
        if(nome != null){
            this.nome = dados.nome();
        }
        if(telefone != null){
            this.telefone = dados.telefone();
        }


    }

    public void excluir() {
        this.situacao = false;
        }
}

