package Model;

public class Artista {
    private int idArtista;
    private int idade;
    private String nome;

    public Artista (int idArtista, int idade, String nome) {
        this.idArtista = idArtista;
        this.idade = idade;
        this.nome = nome;
    }

    public int getIdArtista () {
        return idArtista;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

}
