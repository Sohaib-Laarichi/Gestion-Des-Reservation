package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private Chambre chambre;
    private Client client;
    public static int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Reservation(Date dateDebut, Date dateFin, Chambre chambre, Client client) {
        this.id = ++count;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chambre = chambre;
        this.client = client;
    }

    public Reservation(int id, Date dateDebut, Date dateFin, Chambre chambre, Client client) {
        this.id = id;
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

    public String getDateDebutAsString() {
        return dateFormat.format(dateDebut);
    }

    public String getDateFinAsString() {
        return dateFormat.format(dateFin);
    }

    public void setDateDebutFromString(String dateDebutStr) throws ParseException {
        this.dateDebut = dateFormat.parse(dateDebutStr);
    }

    public void setDateFinFromString(String dateFinStr) throws ParseException {
        this.dateFin = dateFormat.parse(dateFinStr);
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
