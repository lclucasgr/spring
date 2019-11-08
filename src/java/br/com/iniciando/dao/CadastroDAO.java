/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.dao;

import br.com.iniciando.dominio.Cadastro;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author lcluc
 */
public class CadastroDAO {
    
    public EntityManager getEM()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("IniciandoComSpringPU");
        return factory.createEntityManager();
    }
    
    public void adiciona(Cadastro cadastro) throws SQLException
    {
        EntityManager em = getEM();
        
        em.getTransaction().begin();
        em.persist(cadastro);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Cadastro> buscar() throws SQLException
    {
        EntityManager em = getEM();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Cadastro.class));
        List<Cadastro> lista = em.createQuery(criteria).getResultList();
        
        return lista;
    }
}
