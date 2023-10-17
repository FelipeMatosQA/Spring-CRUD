package med.voll.api.Controller;


import jakarta.validation.Valid;
import med.voll.api.Domain.Usuario.AutenticacaoService;
import med.voll.api.Domain.Usuario.DadosAutenticacao;
import med.voll.api.Domain.Usuario.Usuario;
import med.voll.api.Domain.Usuario.UsuarioRepository;
import med.voll.api.Infra.Security.DadosTokenJWT;
import med.voll.api.Infra.Security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {


    @Autowired
    private AuthenticationManager menager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){

        var autenticationToken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var authentication = menager.authenticate(autenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());


        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
