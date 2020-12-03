/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author icaro
 */
@Embeddable
public class ReceitaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "consulta")
    private int consulta;
    @Basic(optional = false)
    @Column(name = "medicamento")
    private int medicamento;

    public ReceitaPK() {
    }

    public ReceitaPK(int consulta, int medicamento) {
        this.consulta = consulta;
        this.medicamento = medicamento;
    }

    public int getConsulta() {
        return consulta;
    }

    public void setConsulta(int consulta) {
        this.consulta = consulta;
    }

    public int getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(int medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consulta;
        hash += (int) medicamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceitaPK)) {
            return false;
        }
        ReceitaPK other = (ReceitaPK) object;
        if (this.consulta != other.consulta) {
            return false;
        }
        if (this.medicamento != other.medicamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReceitaPK[ consulta=" + consulta + ", medicamento=" + medicamento + " ]";
    }
    
}
