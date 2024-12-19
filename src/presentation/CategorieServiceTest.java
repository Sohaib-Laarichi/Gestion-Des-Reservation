package presentation;

import entities.Categorie;
import service.CategorieService;

public class CategorieServiceTest {
    public static void main(String[] args) {
        CategorieService categorieService = new CategorieService();

        // Test create
        Categorie categorie = new Categorie("ta3 laghniya", "end rooms with mjehd amenities");
        //categorieService.create(categorie);
        //categorieService.update(new Categorie(2, "ta3 laghniya", "end rooms with d3if amenities"));
        categorieService.delete(new Categorie(1, "ta3 lfo9ara", "end rooms with d3if amenities"));
        categorieService.findAll();
        categorieService.findById(2);
     
    }
}


