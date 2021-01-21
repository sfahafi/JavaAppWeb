package ar.org.centro8.curso.java.aplicaciones.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle")
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
    @NamedQuery(name = "Detalle.findByIdFactura", query = "SELECT d FROM Detalle d WHERE d.detallePK.idFactura = :idFactura"),
    @NamedQuery(name = "Detalle.findByIdArticulo", query = "SELECT d FROM Detalle d WHERE d.detallePK.idArticulo = :idArticulo"),
    @NamedQuery(name = "Detalle.findByPrecio", query = "SELECT d FROM Detalle d WHERE d.precio = :precio"),
    @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePK detallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idArticulo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;
    @JoinColumn(name = "idFactura", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public Detalle() {
    }

    public Detalle(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public Detalle(DetallePK detallePK, float precio, int cantidad) {
        this.detallePK = detallePK;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Detalle(int idFactura, int idArticulo) {
        this.detallePK = new DetallePK(idFactura, idArticulo);
    }

    public Detalle(DetallePK detallePK, float precio, int cantidad, Articulo articulo, Factura factura) {
        this.detallePK = detallePK;
        this.precio = precio;
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.factura = factura;
    }

    public Detalle(float precio, int cantidad, Articulo articulo, Factura factura) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.factura = factura;
    }
    
    

    public DetallePK getDetallePK() {
        return detallePK;
    }

    public void setDetallePK(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePK != null ? detallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.detallePK == null && other.detallePK != null) || (this.detallePK != null && !this.detallePK.equals(other.detallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detalle{" + "detallePK=" + detallePK + ", precio=" + precio + ", cantidad=" + cantidad + ", articulo=" + articulo + ", factura=" + factura + '}';
    }

    
    
}
