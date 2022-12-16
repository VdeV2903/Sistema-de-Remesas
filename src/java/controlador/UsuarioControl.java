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
import modelo.dao.UsuarioDao;
import modelo.entidad.Usuario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Aquintanilla
 */
//@Named(value = "usuarioControl")
//@Dependent

@ManagedBean
@ViewScoped
public class UsuarioControl implements Serializable{
        private List<Usuario> listaUsuarios;
        private Usuario usuario;
    /**
     * Creates a new instance of UsuarioControl
     */
    public UsuarioControl() {
    }

    public List<Usuario> getListaUsuarios() {
        UsuarioDao ed= new UsuarioDao();
        listaUsuarios= ed.listarUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   
    public void limpiarUsuario() {
        usuario = new Usuario();
    }

    public void agregarUsuario() {
        try{
            UsuarioDao ed = new UsuarioDao();
            usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));
            ed.agregar(usuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage().toString());
        }
    }

    public void modificarUsuario() {
        UsuarioDao ed = new UsuarioDao();
        ed.modificar(usuario);
        limpiarUsuario();
    }

    public void eliminarUsuario() {
        UsuarioDao ed = new UsuarioDao();
        ed.eliminar(usuario);
        limpiarUsuario();
    }
}