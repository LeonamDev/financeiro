/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.financeiro.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import pos.java.financeiro.model.Pessoa;

/**
 *
 * @author DesenvolvedorJava
 */
public class Pessoas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private EntityManager manager;

    public Pessoas(EntityManager manager) {
        this.manager = manager;
    }

    public Pessoa porId(Long id) {
        return manager.find(Pessoa.class, id);
    }

    public List<Pessoa> todas() {
        TypedQuery<Pessoa> query = manager.createQuery(
                "from Pessoa", Pessoa.class);
        return query.getResultList();

    }
}
