package dao;

import model.Categoria;

/**
 *
 * @author icaro
 */
public class CategoriaDAO extends GenericDAO<Categoria, Integer> {

    public CategoriaDAO() {
        super(Categoria.class);
    }
}
