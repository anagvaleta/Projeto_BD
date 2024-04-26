package Model;

public class Album {
    private int idAlbum;
    private String nome;
    private int nota;
    private  String generoMusical;
    private String faixaFavorita;
    private int Artista_idArtista;

    public Album(int idAlbum, String nome, int nota, String generoMusical, String faixaFavorita, int artista_idArtista) {
        this.idAlbum = idAlbum;
        this.nome = nome;
        this.nota = nota;
        this.generoMusical = generoMusical;
        this.faixaFavorita = faixaFavorita;
        this.Artista_idArtista = artista_idArtista;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public String getFaixaFavorita() {
        return faixaFavorita;
    }

    public int getArtista_idArtista() {
        return Artista_idArtista;
    }
}
