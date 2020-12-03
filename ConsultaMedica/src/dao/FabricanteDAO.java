package dao;

import model.Fabricante;

/**
 *
 * @author icaro
 */
public class FabricanteDAO extends GenericDAO<Fabricante, Integer> {

    public FabricanteDAO() {
        super(Fabricante.class);
    }
}
