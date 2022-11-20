package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<Usuario> listarUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);  
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long Id) {
        return repositorio.findById(Id).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long Id) {
        repositorio.deleteById(Id);
        
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String correo) {
        return repositorio.findByCorreo(correo);
    }
    public Usuario buscarPorEmail(String email){
        return repositorio.findByCorreo(email);
    }
    
}
