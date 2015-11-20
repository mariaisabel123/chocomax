/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.entidades;

/**
 *
 * @author MANU
 */
public class Producto {
private String codproducto,nombre,valor_venta,valor_compra,existencias,stock_min,stock_max,estado;

    public Producto() {}

    public Producto(String codproducto, String nombre, String valor_venta, String valor_compra, String existencias, String stock_min, String stock_max, String estado) {
        this.codproducto = codproducto;
        this.nombre = nombre;
        this.valor_venta = valor_venta;
        this.valor_compra = valor_compra;
        this.existencias = existencias;
        this.stock_min = stock_min;
        this.stock_max = stock_max;
        this.estado = estado;
    }

    public String getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(String valor_venta) {
        this.valor_venta = valor_venta;
    }

    public String getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(String valor_compra) {
        this.valor_compra = valor_compra;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }

    public String getStock_min() {
        return stock_min;
    }

    public void setStock_min(String stock_min) {
        this.stock_min = stock_min;
    }

    public String getStock_max() {
        return stock_max;
    }

    public void setStock_max(String stock_max) {
        this.stock_max = stock_max;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


  


    
}

