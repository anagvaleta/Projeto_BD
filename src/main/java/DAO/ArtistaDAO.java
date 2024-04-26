package DAO;
import Model.Artista;
import java.sql.SQLException;
import java.util.ArrayList;


public class ArtistaDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertArtista(Artista artista) {

        connectToDB();

        String sql = "INSERT INTO Artista (idArtista, idade, nome) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,artista.getIdArtista());
            pst.setString(2, artista.getNome());
            pst.setInt(3, artista.getIdade());
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

    public boolean updateArtistaNome(int idArtista, int idade, String nome) {
        connectToDB();
        String sql = "UPDATE Artista SET nome=?, idArtista=? where idade=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idArtista);
            pst.setString(2, nome);
            pst.setInt(3, idade);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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

    public boolean deleteArtista(int idArtista) {
        connectToDB();
        String sql = "DELETE FROM Artista where email=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idArtista);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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


    public ArrayList<Artista> selectArtista() {
        ArrayList<Artista> artistas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Artista";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de artistas: ");

            while (rs.next()) {

                Model.Artista artistaAux = new Artista(rs.getInt("idArtista"), rs.getInt("idade"), rs.getString("nome"));

                System.out.println("Id = " + artistaAux.getIdade());
                System.out.println("Idade = " + artistaAux.getIdade());
                System.out.println("Idade = " + artistaAux.getNome());
                System.out.println("--------------------------------");

                artistas.add(artistaAux);
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
        return artistas;
    }

}