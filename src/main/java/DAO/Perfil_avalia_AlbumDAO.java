package DAO;

import Model.Perfil_avalia_Album;

import java.sql.SQLException;
import java.util.ArrayList;

public class Perfil_avalia_AlbumDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPerfil_avalia_Album(Perfil_avalia_Album perfil_avalia_Album) {

        connectToDB();

        String sql = "INSERT INTO Perfil_avalia_Album (Perfil_username, Album_idAlbum) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, perfil_avalia_Album.getPerfil_username());
            pst.setInt(2, perfil_avalia_Album.getAlbum_idAlbum());
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


    public ArrayList<Perfil_avalia_Album> selectPerfil_avalia_Album() {
        ArrayList<Perfil_avalia_Album> Perfil_avalia_Album = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Perfil_avalia_Album";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Perfis que avaliam: ");

            while (rs.next()) {

                Perfil_avalia_Album avaliadorAux = new Perfil_avalia_Album(rs.getString("Perfil_username"), rs.getInt("Album_idAlbum"));

                System.out.println("Nome do avaliador: " + avaliadorAux.getPerfil_username());
                System.out.println("Id do album avaliado: " + avaliadorAux.getAlbum_idAlbum());
                System.out.println("--------------------------------");

                Perfil_avalia_Album.add(avaliadorAux);
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
        return Perfil_avalia_Album;
    }
}
