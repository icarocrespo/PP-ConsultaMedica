/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author icaro
 */
@Entity
@Table(name = "receita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findByConsulta", query = "SELECT r FROM Receita r WHERE r.receitaPK.consulta = :consulta")
    , @NamedQuery(name = "Receita.findByMedicamento", query = "SELECT r FROM Receita r WHERE r.receitaPK.medicamento = :medicamento")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceitaPK receitaPK;
    @JoinColumn(name = "consulta", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Consulta consulta1;
    @JoinColumn(name = "medicamento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicamento medicamento1;
    @JoinColumn(name = "medico", referencedColumnName = "crm")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medico medico;

    public Receita() {
    }

    public Receita(ReceitaPK receitaPK) {
        this.receitaPK = receitaPK;
    }

    public Receita(int consulta, int medicamento) {
        this.receitaPK = new ReceitaPK(consulta, medicamento);
    }

    public ReceitaPK getReceitaPK() {
        return receitaPK;
    }

    public void setReceitaPK(ReceitaPK receitaPK) {
        this.receitaPK = receitaPK;
    }

    public Consulta getConsulta1() {
        return consulta1;
    }

    public void setConsulta1(Consulta consulta1) {
        this.consulta1 = consulta1;
    }

    public Medicamento getMedicamento1() {
        return medicamento1;
    }

    public void setMedicamento1(Medicamento medicamento1) {
        this.medicamento1 = medicamento1;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receitaPK != null ? receitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.receitaPK == null && other.receitaPK != null) || (this.receitaPK != null && !this.receitaPK.equals(other.receitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Receita[ receitaPK=" + receitaPK + " ]";
    }
    
}
