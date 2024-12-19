
package entities;

public class Categorie {
    private int id;
    private String libelle;
    private String code ;
    public static int count = 0;

    public Categorie(String libelle, String code) {
        this.id = ++count;
        this.libelle = libelle;
        this.code = code;
    }

	public Categorie(int id, String libelle, String code) {
		this.id = id;
		this.libelle = libelle;
		this.code = code;
	}

	public Categorie(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

	public void setCode(String code) {
		this.code = code;
	}

    @Override
    public String toString() {
        return "Categorie{" + "libelle='" + libelle + '\'' + '}';
    }
}
