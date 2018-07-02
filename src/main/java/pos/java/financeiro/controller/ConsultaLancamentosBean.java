/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.financeiro.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import pos.java.financeiro.model.Lancamento;
import pos.java.financeiro.repository.Lancamentos;
import pos.java.financeiro.util.JpaUtil;

/**
 *
 * @author DesenvolvedorJava
 */
@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Lancamento> lancamentos;

    public void consultar() {
        EntityManager manager = JpaUtil.getEntityManager();
        
        Lancamentos lancamentos = new Lancamentos(manager);
        this.lancamentos = lancamentos.todos();
        
        manager.close();
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }
}
