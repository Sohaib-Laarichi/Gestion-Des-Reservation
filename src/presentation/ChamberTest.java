
package presentation;

import service.ChamberService;
import entities.Chambre;

public class ChamberTest {

    public static void main(String[] args) {
        Chambre chamber1 = new Chambre(9, "hassan", true, 101, "A deluxe room", 2);
        ChamberService chamberService = new ChamberService();
        //chamberService.update(chamber1);
        chamberService.findAll();
        chamberService.findById(9);
    }
}
