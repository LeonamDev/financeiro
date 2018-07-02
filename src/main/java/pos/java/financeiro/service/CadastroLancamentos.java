/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.financeiro.service;

import java.io.Serializable;
import java.util.Date;
import pos.java.financeiro.model.Lancamento;
import pos.java.financeiro.repository.Lancamentos;

/**
 *
 * @author DesenvolvedorJava
 */
public class CadastroLancamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Lancamentos lancamentos;

    public CadastroLancamentos(Lancamentos lancamentos) {
        this.lancamentos = lancamentos;
    }

    public void salvar(Lancamento lancamento) throws NegocioException {
        if (lancamento.getDataPagamento() != null
                && lancamento.getDataPagamento().after(new Date())) {
            throw new NegocioException(
                    "Data de pagamento não pode ser uma data futura.");
        }

        this.lancamentos.adicionar(lancamento);
    }
}
