package entities;

public class Chambre {
    private int id;
    private String type;
    private boolean available;
    private int number;
    private String description;
    private int categorieId;
    public static int count = 0;

    public Chambre(int id, String type, boolean available, int number, String description, int categorieId) {
        this.id = id;
        this.type = type;
        this.available = available;
        this.number = number;
        this.description = description;
        this.categorieId = categorieId;
    }

	public Chambre(String type, boolean available, int number, String description, int categorieId) {
		this.id =++count;
		this.type = type;
		this.available = available;
		this.number = number;
		this.description = description;
		this.categorieId = categorieId;
	}
	public Chambre(int id) {	
		this.id = id;
	}

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public int getCategorieId() {
        return categorieId;
    }

	public void setType(String type) {
		this.type = type;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	@Override
	public String toString() {
		return "Chambre{" + "type='" + type + '\'' + '}';
	}

	public void setId(int id) {
		this.id = id;
	}
	
}


