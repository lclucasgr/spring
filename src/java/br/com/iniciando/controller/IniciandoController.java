/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CadastroDAO;
import br.com.iniciando.dominio.Cadastro;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lcluc
 */
@Controller
public class IniciandoController {
    
    
    @RequestMapping("/olaMundo")
    public String iniciando(Model model, Cadastro cadastro)
    {
        CadastroDAO dao = new CadastroDAO();
        
        try
        {
            dao.adiciona(cadastro);
            model.addAttribute("nome", cadastro.getNome());
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return "index";
    }
    
    @RequestMapping("/cadastro")
    public String cadastro()
    {
        return "cadastro";
    }
    
    @RequestMapping("/lista")
    public String lista(Model model)
    {
        
        return "exibir";
    }
    
    @RequestMapping("/retorno")
    public @ResponseBody String retorno() throws SQLException
    {
        CadastroDAO cd = new CadastroDAO();
        Gson gson = new Gson();
        
        String retorno = gson.toJson(cd.buscar());
        
        
        return retorno;
    }
}
