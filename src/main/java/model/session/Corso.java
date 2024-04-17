package model.session;
import javax.persistence.*;



@Entity
@Table(name="Corso")
public class Corso {


    @ManyToOne
    @JoinColumn(name="iddocente")
    private Docente oDocente;

    @Column(name="idcorso")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int chiave;

    @Column(name="nome")
    private String nome;
    @Column(name="durata")
    private int durata;
    public Corso() {
        this.nome = "";
        this.durata = 0;
    }

    public int getChiave() {
        return chiave;
    }

    public void setChiave(int chiave) {
        this.chiave = chiave;
    }


    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setoDocente(Docente oDocente){
        this.oDocente = oDocente;

    }
    public Docente getoDocente(){
        return oDocente;
    }
}
