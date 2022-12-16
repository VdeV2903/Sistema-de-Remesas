/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.EstadoDao;
import modelo.dao.FormaPagoDao;
import modelo.dao.PaisDao;
import modelo.dao.PersonaEnviaDao;
import modelo.dao.PersonaRecibeDao;
import modelo.dao.RemesaDao;
import modelo.entidad.Estado;
import modelo.entidad.FormaPago;
import modelo.entidad.Pais;
import modelo.entidad.PersonaEnvia;
import modelo.entidad.PersonaRecibe;
import modelo.entidad.Remesa;

/**
 *
 * @author Aquintanilla
 */
//@Named(value = "remesaControl")
//@Dependent

@ManagedBean
@ViewScoped
public class RemesaControl implements Serializable{
        private List<Remesa> listaRemesas;
        private Remesa remesa;
 
        //agregar para los combos
    private List<SelectItem> listaPaises;
    private List<SelectItem> listaPersonasEnvian;
    private List<SelectItem> listaPersonasReciben;
    private List<SelectItem> listaFormasPago;
    private List<SelectItem> listaEstados;

    // agregado para capturar el id de usuario
    @ManagedProperty("#{loginControl}")
    private LoginControl loginControl;
    /**
     * Creates a new instance of RemesaControl
     */
    public RemesaControl() {
        // para combos
        remesa = new Remesa();
    }

    public List<Remesa> getListaRemesas() {
        RemesaDao ed= new RemesaDao();
        listaRemesas= ed.listarRemesas();
        return listaRemesas;
    }

    public void setListaRemesas(List<Remesa> listaRemesas) {
        this.listaRemesas = listaRemesas;
    }

    public Remesa getRemesa() {
        return remesa;
    }

    public void setRemesa(Remesa remesa) {
        this.remesa = remesa;
    }

    public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }
    
      
    public void limpiarRemesa() {
        remesa = new Remesa();
    }

    public void agregarRemesa() {
        RemesaDao ed = new RemesaDao();
        remesa.setUsuario(loginControl.getUsuario());
        remesa.getEstado().setIdEstado(1);
        ed.agregar(remesa);
    }

    public void modificarRemesa() {
        RemesaDao ed = new RemesaDao();
        ed.modificar(remesa);
        limpiarRemesa();
    }

    public void eliminarRemesa() {
        RemesaDao ed = new RemesaDao();
        ed.eliminar(remesa);
        limpiarRemesa();
    }
    // para combos
   public List<SelectItem> getListaPaises() {
        this.listaPaises = new ArrayList<SelectItem>();
        PaisDao pd = new PaisDao();
        List<Pais> paises = pd.listarPaises();
        listaPaises.clear();
        for (Pais pais : paises) {
            SelectItem paisItem = new SelectItem(pais.getIdPais(), pais.getNombre());
            listaPaises.add(paisItem);
        }
        return listaPaises;
    }
   public List<SelectItem> getListaEstados() {
        this.listaEstados = new ArrayList<SelectItem>();
        EstadoDao ed = new EstadoDao();
        List<Estado> estados = ed.listarEstados();
        listaEstados.clear();
        for (Estado estado : estados) {
            SelectItem estadoItem = new SelectItem(estado.getIdEstado(), estado.getNombre());
            listaEstados.add(estadoItem);
        }
        return listaEstados;
    }
    
    public List<SelectItem> getListaFormasPago() {
        this.listaFormasPago = new ArrayList<SelectItem>();
        FormaPagoDao fd = new FormaPagoDao();
        List<FormaPago> formasPago = fd.listarFormaPagos();
        listaFormasPago.clear();
        for (FormaPago formaPago : formasPago) {
            SelectItem formaPagoItem = new SelectItem(formaPago.getIdFormaPago(), formaPago.getNombre());
            listaFormasPago.add(formaPagoItem);
        }
        return listaFormasPago;
    }
    
    public List<SelectItem> getListaPersonaEnvia() {
        this.listaPersonasEnvian = new ArrayList<SelectItem>();
        PersonaEnviaDao pd = new PersonaEnviaDao();
        List<PersonaEnvia> personasEnvian = pd.listarPersonaEnvias();
        listaPersonasEnvian.clear();
        for (PersonaEnvia personaEnvia : personasEnvian) {
            SelectItem personaEnviaItem = new SelectItem(personaEnvia.getIdPersonaEnvia(), personaEnvia.getNombre() + " " + personaEnvia.getApellido());
            listaPersonasEnvian.add(personaEnviaItem);
        }
        return listaPersonasEnvian;
    }
    
    public List<SelectItem> getListaPersonaRecibe() {
        this.listaPersonasReciben = new ArrayList<SelectItem>();
        PersonaRecibeDao pr = new PersonaRecibeDao();
        List<PersonaRecibe> personasReciben = pr.listarPersonaRecibes();
        listaPersonasEnvian.clear();
        for (PersonaRecibe personaRecibe : personasReciben) {
            SelectItem personaRecibeItem = new SelectItem(personaRecibe.getIdPersonaRecibe(), personaRecibe.getNombre() + " " + personaRecibe.getApellido());
            listaPersonasReciben.add(personaRecibeItem);
        }
        return listaPersonasReciben;
    }    
}