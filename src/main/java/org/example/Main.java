package org.example;

import DAO.AlbumDAO;
import DAO.ArtistaDAO;
import DAO.PerfilDAO;
import DAO.UsuarioDAO;
import Model.Album;
import Model.Artista;
import Model.Perfil;
import Model.Usuario;

public class Main {
    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuario1 = new Usuario("petteco@gmail.com", "Petteco");
        Usuario usuario2 = new Usuario("aninha@hotmail.com", "Ana Louise");
        Usuario usuario3 = new Usuario("jorginho@hotmail.com", "Jorge");

        usuarioDAO.insertUsuario(usuario1);
        usuarioDAO.insertUsuario(usuario2);
        usuarioDAO.insertUsuario(usuario3);

        usuarioDAO.deleteUsuario("jorginho@hotmail.com");
        usuarioDAO.updateUsuarioNome("aninha@hotmail.com", "Ana Luisa");
        usuarioDAO.selectUsuario();

        PerfilDAO perfilDAO = new PerfilDAO();
        Perfil perfil1 = new Perfil("Nana", 2, "aninha@hotmail.com");
        perfilDAO.insertPerfil(perfil1);

        ArtistaDAO artistaDAO = new ArtistaDAO();
        Artista artista1 = new Artista(123, 34, "Taylor Swift");
        artistaDAO.insertArtista(artista1);

        AlbumDAO albumDAO = new AlbumDAO();
        Album album1 = new Album(12, "Midnights (3am Edition)",10, "Dream POP", "Your on your own, kid", 123);
        albumDAO.insertAlbum(album1);
    }
}