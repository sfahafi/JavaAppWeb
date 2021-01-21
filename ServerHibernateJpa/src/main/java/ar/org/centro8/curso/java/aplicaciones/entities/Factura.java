package ar.org.centro8.curso.java.aplicaciones.entities;

import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
    @NamedQuery(name = "Factura.findByLetra", query = "SELECT f FROM Factura f WHERE f.letra = :letra"),
    @NamedQuery(name = "Factura.findByNumero", query = "SELECT f FROM Factura f WHERE f.numero = :numero"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByMonto", query = "SELECT f FROM Factura f WHERE f.monto = :monto"),
    @NamedQuery(name = "Factura.findByIdCliente", query = "SELECT f FROM Factura f WHERE f.idCliente = :idCliente")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "letra")
    @Enumerated(value = EnumType.STRING)
    private Letra letra;
    @Size(max = 1)
    
    @Column(name = "numero")
    private int numero;
    @Size(max = 10)
    @Column(name = "fecha")
    private String fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<Detalle> detalleCollection;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, Letra letra, int numero, int idCliente) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.idCliente = idCliente;
    }

    public Factura(Letra letra, int numero, String fecha, Double monto, int idCliente) {
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    public Factura(Integer id, Letra letra, int numero, String fecha, Double monto, int idCliente) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", letra=" + letra + ", numero=" + numero + ", fecha=" + fecha + ", monto=" + monto + ", idCliente=" + idCliente + '}';
    }

    
    
}
