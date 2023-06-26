package med.voll.api.Controller;


import jakarta.validation.Valid;
import med.voll.api.Medico.DadosCadastroMedico;
import med.voll.api.Medico.Medico;
import med.voll.api.Medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medicos")//Aponta qual será o endpoint de acesso à classe
public class MedicosController {

    @Autowired// Indica que é um objeto gerenciado pelo SpringBoot, não precisa instanciar as classes.
    private MedicoRepository repository;


    @PostMapping//Indica que é um método Post
    @Transactional//Anotação indica que serão feitas alterações no banco de dados come sse método.
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
