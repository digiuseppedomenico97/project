package model.session;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Docente")
public class Docente {

	@OneToMany(mappedBy = "oDocente")
	private List<Corso> oCorso;

	@Column(name="iddocente")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chiave;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="nome")
	private String nome;
	
	public Docente() {
		this.nome = "";
		this.cognome = "";
	}

	public int getChiave() {
		return chiave;
	}

	public void setChiave(int chiave) {
		this.chiave = chiave;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
