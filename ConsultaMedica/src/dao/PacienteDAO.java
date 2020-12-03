package dao;

import model.Paciente;

/**
 *
 * @author icaro
 */
public class PacienteDAO extends GenericDAO<Paciente, Integer> {

    public PacienteDAO() {
        super(Paciente.class);
    }
}
