/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.FormaPagoDao;
import modelo.entidad.FormaPago;

/**
 *
 * @author Aquintanilla
 */
//@Named(value = "formaPagoControl")
//@Dependent

@ManagedBean
@ViewScoped
public class FormaPagoControl implements Serializable{
        private List<FormaPago> listaFormaPagos;
        private FormaPago formaPago;
    /**
     * Creates a new instance of FormaPagoControl
     */
    public FormaPagoControl() {
    }

    public List<FormaPago> getListaFormaPagos() {
        FormaPagoDao ed= new FormaPagoDao();
        listaFormaPagos= ed.listarFormaPagos();
        return listaFormaPagos;
    }

    public void setListaFormaPagos(List<FormaPago> listaFormaPagos) {
        this.listaFormaPagos = listaFormaPagos;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    
   
    public void limpiarFormaPago() {
        formaPago = new FormaPago();
    }

    public void agregarFormaPago() {
        FormaPagoDao ed = new FormaPagoDao();
        ed.agregar(formaPago);
    }

    public void modificarFormaPago() {
        FormaPagoDao ed = new FormaPagoDao();
        ed.modificar(formaPago);
        limpiarFormaPago();
    }

    public void eliminarFormaPago() {
        FormaPagoDao ed = new FormaPagoDao();
        ed.eliminar(formaPago);
        limpiarFormaPago();
    }
}