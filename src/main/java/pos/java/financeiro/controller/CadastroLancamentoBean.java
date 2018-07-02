/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.financeiro.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pos.java.financeiro.model.Lancamento;
import pos.java.financeiro.model.Pessoa;
import pos.java.financeiro.model.TipoLancamento;
import pos.java.financeiro.repository.Lancamentos;
import pos.java.financeiro.repository.Pessoas;
import pos.java.financeiro.service.CadastroLancamentos;
import pos.java.financeiro.service.NegocioException;
import pos.java.financeiro.util.JpaUtil;

/**
 *
 * @author DesenvolvedorJava
 */
@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Lancamento lancamento = new Lancamento();
    private List<Pessoa> todasPessoas;

    public void prepararCadastro() {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Pessoas pessoas = new Pessoas(manager);
            this.todasPessoas = pessoas.todas();
        } finally {
            manager.close();
        }
    }

    public void salvar() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction trx = manager.getTransaction();
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            trx.begin();
            CadastroLancamentos cadastro = new CadastroLancamentos(
                    new Lancamentos(manager));
            cadastro.salvar(this.lancamento);
            this.lancamento = new Lancamento();
            context.addMessage(null, new FacesMessage(
                    "Lançamento salvo com sucesso!"));
            trx.commit();
        } catch (NegocioException e) {
            trx.rollback();
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        } finally {
            manager.close();
        }
    }

    public List<Pessoa> getTodasPessoas() {
        return this.todasPessoas;
    }

    public TipoLancamento[] getTiposLancamentos() {
        return TipoLancamento.values();
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }
}
