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
import modelo.dao.PersonaRecibeDao;
import modelo.entidad.PersonaRecibe;

/**
 *
 * @author Aquintanilla
 */
//@Named(value = "personaRecibeControl")
//@Dependent

@ManagedBean
@ViewScoped
public class PersonaRecibeControl implements Serializable{
        private List<PersonaRecibe> listaPersonaRecibes;
        private PersonaRecibe personaRecibe;
    /**
     * Creates a new instance of PersonaRecibeControl
     */
    public PersonaRecibeControl() {
    }

    public List<PersonaRecibe> getListaPersonaRecibes() {
        PersonaRecibeDao ed= new PersonaRecibeDao();
        listaPersonaRecibes= ed.listarPersonaRecibes();
        return listaPersonaRecibes;
    }

    public void setListaPersonaRecibes(List<PersonaRecibe> listaPersonaRecibes) {
        this.listaPersonaRecibes = listaPersonaRecibes;
    }

    public PersonaRecibe getPersonaRecibe() {
        return personaRecibe;
    }

    public void setPersonaRecibe(PersonaRecibe personaRecibe) {
        this.personaRecibe = personaRecibe;
    }
    
   
    public void limpiarPersonaRecibe() {
        personaRecibe = new PersonaRecibe();
    }

    public void agregarPersonaRecibe() {
        PersonaRecibeDao ed = new PersonaRecibeDao();
        ed.agregar(personaRecibe);
    }

    public void modificarPersonaRecibe() {
        PersonaRecibeDao ed = new PersonaRecibeDao();
        ed.modificar(personaRecibe);
        limpiarPersonaRecibe();
    }

    public void eliminarPersonaRecibe() {
        PersonaRecibeDao ed = new PersonaRecibeDao();
        ed.eliminar(personaRecibe);
        limpiarPersonaRecibe();
    }
}