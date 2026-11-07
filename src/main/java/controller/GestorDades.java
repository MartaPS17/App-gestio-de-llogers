
package controller;
import model.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mpers
 */
public class GestorDades {
    private static GestorDades instancia;
    private final List<Lloguer> lloguers;
    
    private GestorDades(){
        this.lloguers = new ArrayList<>();
    }
    //per la taula obtendre sa instancia
    public static GestorDades getInstancia(){
        if(instancia == null){
            instancia = new GestorDades();
        }
        return instancia;
        
    }
    
    public List<Lloguer> getLloguers(){
        return lloguers;
    }
    
    public void afegirLloguer(Lloguer nouLloguer){
        this.lloguers.add(nouLloguer);
    }
 
}
