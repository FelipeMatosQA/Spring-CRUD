package med.voll.api.Infra.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//Indica para o Spring que é uma classe de configuração
@EnableWebSecurity//Indica para o Spring que serão alteradas as configurações de WebSecurity
public class SecurityConfigurations {


    //O método abaixo desabilitou o processo de autenticação nativo do spring(pedir email e senha), que precisará ser configurado para a forma desejada
    @Bean//o metodo precisa retornar a classe "SecurityFilterChain
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return http.csrf().disable()//desabilitando proteção para ataques csrf pois não é necessário
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().build();//informando que a politica de criação de session é STATELESS  e buildando o objeto.
    }

    @Bean //bean serve para exportar uma classe para o spring,fazendo com que ele consiga carrega-la e consiga injetar dependências em outras classes
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean//Esse método é uma configuração indicando o tipo de encriptação da senha, no casso é "bcrypt"
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
