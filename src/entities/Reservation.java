package entities;

import java.util.Date;

public class Reservation {
	private int id;
	private Date dateDebut;
	private Date dateFin;
	private Chambre chambre;
    private Client client;
    public static int count = 0;
    
	public Reservation(Date dateDebut, Date dateFin, Chambre chambre, Client client) {
		this.id = ++count;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.chambre = chambre;
		this.client = client;
	}

	public int getId() {
		return id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public Client getClient() {
		return client;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
