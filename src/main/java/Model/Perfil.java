package Model;

public class Perfil {
    private String username;
    private int qntAlbuns;
    private String Usuario_email;

    public Perfil (String username, int qntAlbuns, String Usuario_email) {
        this.username = username;
        this.qntAlbuns = qntAlbuns;
    }

    public String getUsername() {
        return username;
    }

    public int getQntAlbuns() {
        return qntAlbuns;
    }

    public String getUsuario_email() {
        return Usuario_email;
    }

}
