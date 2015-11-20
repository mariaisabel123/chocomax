/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.entidades;

/**
 *
 * @author Mary
 */
public class Cliente {
    
String codcliente;
String nombre;
String primerapellido;
String segundoapellido;
String telefono;
String mail;
String direccion;
String estado;

public Cliente (){}

    public Cliente(String codcliente, String nombre, String primerapellido, String segundoapellido, String telefono, String mail, String direccion, String estado) {
        this.codcliente = codcliente;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
        this.estado = estado;
        
        
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
 }

