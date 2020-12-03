package dao;

import model.Medico;

/**
 *
 * @author icaro
 */
public class MedicoDAO extends GenericDAO<Medico, Integer> {

    public MedicoDAO() {
        super(Medico.class);
    }
}
