package med.voll.api.Domain.Medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Domain.Endereco.Endereco;

@Table(name ="medicos")
@Entity(name ="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Digits(integer = 20, fraction = 0)
    private String telefone;
    private String crm;
    private Boolean situacao;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;



    public Medico(DadosCadastroMedico dados) {
        this.situacao = true;
        this.crm = dados.crm();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.nome = dados.nome();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAlteracaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void excluir() {
        this.situacao = false;
    }
}
