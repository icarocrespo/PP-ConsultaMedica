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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "doenca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doenca.findAll", query = "SELECT d FROM Doenca d")
    , @NamedQuery(name = "Doenca.findById", query = "SELECT d FROM Doenca d WHERE d.id = :id")
    , @NamedQuery(name = "Doenca.findByNome", query = "SELECT d FROM Doenca d WHERE d.nome = :nome")
    , @NamedQuery(name = "Doenca.findByNomeCientifico", query = "SELECT d FROM Doenca d WHERE d.nomeCientifico = :nomeCientifico")})
public class Doenca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_cientifico")
    private String nomeCientifico;
    @JoinTable(name = "sintoma_doenca", joinColumns = {
        @JoinColumn(name = "doenca", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "sintoma", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Sintoma> sintomaList;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    public Doenca() {
    }

    public Doenca(Integer id) {
        this.id = id;
    }

    public Doenca(Integer id, String nome) {
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

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    @XmlTransient
    public List<Sintoma> getSintomaList() {
        return sintomaList;
    }

    public void setSintomaList(List<Sintoma> sintomaList) {
        this.sintomaList = sintomaList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Doenca)) {
            return false;
        }
        Doenca other = (Doenca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Doenca[ id=" + id + " ]";
    }
    
}
