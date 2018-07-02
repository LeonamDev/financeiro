/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.financeiro;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

/**
 *
 * @author DesenvolvedorJava
 */
@ManagedBean
@ApplicationScoped
public class NomesBean {

    private String nome;
    private List<String> nomes = new ArrayList<>();

    private HtmlInputText inputNome;
    private HtmlCommandButton botaoAdicionar;

    public void adicionar() {
        this.nomes.add(nome);
        // desativa campo e botão quando mais que 3 nomes
        // forem adicionados
        if (this.nomes.size() > 3) {
            this.inputNome.setDisabled(true);
            this.botaoAdicionar.setDisabled(true);
            this.botaoAdicionar.setValue(
                    "Muitos nomes adicionados...");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getNomes() {
        return nomes;
    }

    public HtmlInputText getInputNome() {
        return inputNome;
    }

    public void setInputNome(HtmlInputText inputNome) {
        this.inputNome = inputNome;
    }

    public HtmlCommandButton getBotaoAdicionar() {
        return botaoAdicionar;
    }

    public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
        this.botaoAdicionar = botaoAdicionar;
    }
    
    
}
