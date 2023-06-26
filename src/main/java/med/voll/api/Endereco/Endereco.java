package med.voll.api.Endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.numero();
        this.numero = dados.numero();;
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(logradouro != null){
            this.logradouro = dados.logradouro();
        }
        if(bairro != null){
            this.bairro = dados.bairro();
        }
        if(numero != null){
            this.numero = dados.numero();
        }
        if(complemento!= null){
            this.complemento = dados.complemento();
        }
        if(cidade != null){
            this.cidade = dados.cidade();
        }
        if(uf != null){
            this.uf = dados.uf();
        }
        if(cep != null){
            this.cep = dados.cep();
        }
    }
}
