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
import modelo.dao.PersonaEnviaDao;
import modelo.entidad.PersonaEnvia;

/**
 *
 * @author Aquintanilla
 */
//@Named(value = "personaEnviaControl")
//@Dependent

@ManagedBean
@ViewScoped
public class PersonaEnviaControl implements Serializable{
        private List<PersonaEnvia> listaPersonaEnvias;
        private PersonaEnvia personaEnvia;
    /**
     * Creates a new instance of PersonaEnviaControl
     */
    public PersonaEnviaControl() {
    }

    public List<PersonaEnvia> getListaPersonaEnvias() {
        PersonaEnviaDao ed= new PersonaEnviaDao();
        listaPersonaEnvias= ed.listarPersonaEnvias();
        return listaPersonaEnvias;
    }

    public void setListaPersonaEnvias(List<PersonaEnvia> listaPersonaEnvias) {
        this.listaPersonaEnvias = listaPersonaEnvias;
    }

    public PersonaEnvia getPersonaEnvia() {
        return personaEnvia;
    }

    public void setPersonaEnvia(PersonaEnvia personaEnvia) {
        this.personaEnvia = personaEnvia;
    }
    
   
    public void limpiarPersonaEnvia() {
        personaEnvia = new PersonaEnvia();
    }

    public void agregarPersonaEnvia() {
        PersonaEnviaDao ed = new PersonaEnviaDao();
        ed.agregar(personaEnvia);
    }

    public void modificarPersonaEnvia() {
        PersonaEnviaDao ed = new PersonaEnviaDao();
        ed.modificar(personaEnvia);
        limpiarPersonaEnvia();
    }

    public void eliminarPersonaEnvia() {
        PersonaEnviaDao ed = new PersonaEnviaDao();
        ed.eliminar(personaEnvia);
        limpiarPersonaEnvia();
    }
}