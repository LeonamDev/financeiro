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
import pos.java.financeiro.model.Lancamento;

/**
 *
 * @author DesenvolvedorJava
 */
public class Lancamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    private EntityManager manager;

    public Lancamentos(EntityManager manager) {
        this.manager = manager;
    }

    public void adicionar(Lancamento lancamento) {
        this.manager.persist(lancamento);
    }

    public List<Lancamento> todos() {
        TypedQuery<Lancamento> query = manager.createQuery(
                "from Lancamento", Lancamento.class);
        return query.getResultList();
    }
}
