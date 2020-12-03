/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author icaro
 */
@Entity
@Table(name = "sintoma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintoma.findAll", query = "SELECT s FROM Sintoma s")
    , @NamedQuery(name = "Sintoma.findById", query = "SELECT s FROM Sintoma s WHERE s.id = :id")
    , @NamedQuery(name = "Sintoma.findByNome", query = "SELECT s FROM Sintoma s WHERE s.nome = :nome")
    , @NamedQuery(name = "Sintoma.findByObservacoes", query = "SELECT s FROM Sintoma s WHERE s.observacoes = :observacoes")})
public class Sintoma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "observacoes")
    private String observacoes;
    @ManyToMany(mappedBy = "sintomaList", fetch = FetchType.EAGER)
    private List<Doenca> doencaList;

    public Sintoma() {
    }

    public Sintoma(Integer id) {
        this.id = id;
    }

    public Sintoma(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @XmlTransient
    public List<Doenca> getDoencaList() {
        return doencaList;
    }

    public void setDoencaList(List<Doenca> doencaList) {
        this.doencaList = doencaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintoma)) {
            return false;
        }
        Sintoma other = (Sintoma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sintoma[ id=" + id + " ]";
    }
    
}
