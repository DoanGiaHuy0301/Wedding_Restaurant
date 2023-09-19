/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "anh_sanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnhSanh.findAll", query = "SELECT a FROM AnhSanh a"),
    @NamedQuery(name = "AnhSanh.findById", query = "SELECT a FROM AnhSanh a WHERE a.id = :id"),
    @NamedQuery(name = "AnhSanh.findByAnhSanh", query = "SELECT a FROM AnhSanh a WHERE a.anhSanh = :anhSanh")})
public class AnhSanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "anh_sanh")
    @NotNull(message = "{anhSanh.anhSanh.notNullMsg}")
    private String anhSanh;
    @JoinColumn(name = "sanh_id", referencedColumnName = "id")
    @ManyToOne
    private ThongTinSanh sanhId;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public AnhSanh() {
    }

    public AnhSanh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnhSanh() {
        return anhSanh;
    }

    public void setAnhSanh(String anhSanh) {
        this.anhSanh = anhSanh;
    }

    public ThongTinSanh getSanhId() {
        return sanhId;
    }

    public void setSanhId(ThongTinSanh sanhId) {
        this.sanhId = sanhId;
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
        if (!(object instanceof AnhSanh)) {
            return false;
        }
        AnhSanh other = (AnhSanh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.AnhSanh[ id=" + id + " ]";
    }
    
}
