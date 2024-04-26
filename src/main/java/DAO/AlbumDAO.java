package DAO;

import Model.Album;

import java.sql.SQLException;
import java.util.ArrayList;


public class AlbumDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertAlbum(Album album) {

        connectToDB();

        String sql = "INSERT INTO Album (idAlbum, nome, nota, generoMusical, faixaFavorita, Artista_idArtista) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, album.getIdAlbum());
            pst.setString(2, album.getNome());
            pst.setInt(3, album.getNota());
            pst.setString(4, album.getGeneroMusical());
            pst.setString(5, album.getFaixaFavorita());
            pst.setInt(6, album.getArtista_idArtista());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }


    public ArrayList<Album> selectAlbum() {
        ArrayList<Album> albuns = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Album";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Albuns: ");

            while (rs.next()) {

                Album AlbunsAux = new Album(rs.getInt("IdAlbum"), rs.getString("Nome"), rs.getInt("Nota"), rs.getString("GeneroMusical"), rs.getString("FaixaFavorita"), rs.getInt("Artista_idArtista"));

                System.out.println("Id do Album = " + AlbunsAux.getIdAlbum());
                System.out.println("Nome do Album = " + AlbunsAux.getNome());
                System.out.println("Nota do Album = " + AlbunsAux.getNota());
                System.out.println("Genero musical do Album = " + AlbunsAux.getGeneroMusical());
                System.out.println("Faixa favorita do Album = " + AlbunsAux.getFaixaFavorita());
                System.out.println("--------------------------------");

                albuns.add(AlbunsAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return albuns;
    }


}

