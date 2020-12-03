package dao;

import model.Sintoma;

/**
 *
 * @author icaro
 */
public class SintomaDAO extends GenericDAO<Sintoma, Integer> {

    public SintomaDAO() {
        super(Sintoma.class);
    }
}
