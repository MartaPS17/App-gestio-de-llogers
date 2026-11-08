package controller;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorDades {
    private static GestorDades instancia;
    
    private final List<Lloguer> lloguers;
    private final List<Usuari> usuaris;
    private final List<Joc> jocs;
    
    //constructor 
    private GestorDades(){
        this.lloguers = new ArrayList<>();
        this.usuaris = new ArrayList<>();
        this.jocs = new ArrayList<>();
    
        carregarDadesInicials();
    
    }
    
    //per la taula obtendre sa instancia
    public static GestorDades getInstancia(){
        if(instancia == null){
            instancia = new GestorDades();
        }
        return instancia;
        
    }
    
    //getters
    public List<Lloguer> getLloguers(){ return lloguers; }
       
    public int getSeguentNumRegistre(){
        int maxNum = 0;
        for (Lloguer l : lloguers){
            if (l.getNumRegistre() > maxNum){
                maxNum = l.getNumRegistre();
            }
        }
        return maxNum + 1;
    }
    
       public void afegirLloguer(Lloguer nouLloguer){this.lloguers.add(nouLloguer);}
 
       //metode per crear les dades inicials (de exemple)
       private void carregarDadesInicials(){
              Usuari u1 = new Usuari("Pilar", "Sureda", "Pons", "22695312DS", "Deià", 677549825, "piliS@gmail.com");
            Usuari u2 = new Usuari("Joel", "Aguiló", "Marques", "20675348G", "Palma", 677549825, "joelA@gmail.com");
            usuaris.add(u1);
            usuaris.add(u2);
            
            Joc j1 = new Joc("Naruto Shippuden Storm Connections", "Aventura" );
            j1.setEstoc(Plataforma.Switch_2, 3);
            j1.setEstoc(Plataforma.PS5, 1);
            
            Joc j2 = new Joc("The Last of Us - Part II", "Survival Horror");
            j2.setEstoc(Plataforma.PS5, 2);
            j2.setEstoc(Plataforma.PC,0);
            
            jocs.add(j1);
            jocs.add(j2);
            
            //crear lloguer prova
            Lloguer l1 = new Lloguer(1, u1, j1, Plataforma.Switch_2, LocalDate.now().minusDays(2), false, 7); 
            lloguers.add(l1);
            
       }
   
}
