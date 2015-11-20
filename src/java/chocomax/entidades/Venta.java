/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.entidades;

/**
 *
 * @author USER
 */
public class Venta {
private String cons,idecliente,usuario,fecha,subtotal,iva,estado;

    public Venta(String cons, String idecliente, String usuario, String fecha, String subtotal, String iva, String estado) {
        this.cons = cons;
        this.idecliente = idecliente;
        this.usuario = usuario;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.estado = estado;
        
    }

    public Venta() {
 
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getIdecliente() {
        return idecliente;
    }

    public void setIdecliente(String idecliente) {
        this.idecliente = idecliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
  
    }



