package com.Tcc.api.controller;

import com.Tcc.domain.model.Tarefa;
import com.Tcc.domain.model.Usuario;
import com.Tcc.domain.repository.LoginRepository;
import com.Tcc.domain.utils.SecurityUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLogin {

    @Autowired
    private LoginRepository LoginRepository;
    @Autowired
    private SecurityUtils securityUtils;

    //Validar Se existe o usuario 
    @GetMapping("/ValidarUsuario")
    public List<Usuario> Validar(
            @RequestHeader("Login") String login,
            @RequestHeader("senha") String senha) {
        return LoginRepository.ValidarUsuario(login, securityUtils.encodePass(senha));

    }

    @GetMapping("/TarefasUsuario")
    public List<Tarefa> TarefasUsuarioLogado(
            @RequestHeader("usuario_id") Integer usuario_id) {
        return LoginRepository.TarefasUsuarioLogado(usuario_id);
    }

    @GetMapping("/TarefasSolicitacao")
    public List<Tarefa> TarefasSolicitacao(
            @RequestHeader("solicitacao_id") Integer solicitacao_id) {
        return LoginRepository.TarefasSolicitacao(solicitacao_id);
    }

}
