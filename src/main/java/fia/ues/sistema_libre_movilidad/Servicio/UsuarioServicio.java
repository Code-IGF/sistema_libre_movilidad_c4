package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;

public interface UsuarioServicio {
    
    public List<Usuario> listarUsuarios();

    public Usuario guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioPorId(Long Id);

    public Usuario actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Long Id); 

    public Usuario buscarPorEmail(String email);
}
