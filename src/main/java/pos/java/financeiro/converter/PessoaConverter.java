/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import pos.java.financeiro.model.Pessoa;
import pos.java.financeiro.repository.Pessoas;
import pos.java.financeiro.util.JpaUtil;

/**
 *
 * @author DesenvolvedorJava
 */
@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
        Pessoa retorno = null;
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            if (value != null && !"".equals(value)) {
                Pessoas pessoas = new Pessoas(manager);
                retorno = pessoas.porId(new Long(value));
            }
            return retorno;
        } finally {
            manager.close();
        }
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        if (value != null) {
            return ((Pessoa) value).getId().toString();
        }
        return null;
    }
}
