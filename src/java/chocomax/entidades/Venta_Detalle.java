/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.entidades;

/**
 *
 * @author USER
 */
public class Venta_Detalle {
 
    private String consventa,codprod,cantidad,valor;

    public Venta_Detalle(String consventa, String codprod, String cantidad, String valor) {
        this.consventa = consventa;
        this.codprod = codprod;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public String getConsventa() {
        return consventa;
    }

    public void setConsventa(String consventa) {
        this.consventa = consventa;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
