package dao;

import model.Receita;

/**
 *
 * @author icaro
 */
public class ReceitaDAO extends GenericDAO<Receita, Integer> {

    public ReceitaDAO() {
        super(Receita.class);
    }
}
