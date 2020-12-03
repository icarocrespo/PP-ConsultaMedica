package dao;

import model.Medicamento;

/**
 *
 * @author icaro
 */
public class MedicamentoDAO extends GenericDAO<Medicamento, Integer> {

    public MedicamentoDAO() {
        super(Medicamento.class);
    }
}
