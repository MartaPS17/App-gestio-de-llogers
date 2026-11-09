package controller;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import model.Joc;

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
    public void getUsuaris(Usuari nouUsuari){this.usuaris.add(nouUsuari);}
    public void getNomJoc(Joc nouJoc){this.jocs.add(nouJoc);}
       
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
           Joc j1 = new Joc("Naruto Shippuden Storm Connections", "Aventura", 2 );
           Joc j2 = new Joc("The Last of Us - Part II", "Survival Horror", 1);
           Joc j3 = new Joc("Valorant", "Shooter Tàctic / FPS", 4);
           Joc j4 = new Joc("Cities: Skylines", "Simulació / Construcció", 2);
           Joc j5 = new Joc("Pokemon X Y", "RPG", 0);
           Joc j6 = new Joc("Five Nights at Freddy's", "Survival Horror / Terror", 2); 
           Joc j7 = new Joc("Assassin's Creed Valhalla", "Acció / RPG", 3);
           
           j1.setEstoc(Plataforma.Switch_2,3);
           j2.setEstoc(Plataforma.PS5, 1);
           j3.setEstoc(Plataforma.PC, 4);
           
           jocs.add(j1);
           jocs.add(j2);
           jocs.add(j3);
           jocs.add(j4);
           jocs.add(j5);
           jocs.add(j6);
           jocs.add(j7);
           
           
            Usuari u1 = new Usuari("Pilar", "Sureda", "Pons", "22695312DS", "Deià", 677549825, "piliS@gmail.com");
            Usuari u2 = new Usuari("Joel", "Aguiló", "Marques", "20675348G", "Palma", 677549825, "joelA@gmail.com");
            usuaris.add(u1);
            usuaris.add(u2);
            
            
            j1.setEstoc(Plataforma.Switch_2, 3);
            j1.setEstoc(Plataforma.PS5, 1);

            j2.setEstoc(Plataforma.PS5, 2);
            j2.setEstoc(Plataforma.PC,4);
           
            j3.setEstoc(Plataforma.Switch_2, 4);
            j3.setEstoc(Plataforma.PC, 0);
            
 
            
            //crear lloguer prova
            Lloguer l1 = new Lloguer(1, u1, j1, Plataforma.Switch_2, LocalDate.now().minusDays(2), false, 7); 
            lloguers.add(l1);
            Lloguer l2 = new Lloguer(2, u2, j2, Plataforma.PC, LocalDate.now().minusDays(7), true, 1);
            lloguers.add(l2);
            
       }
       
       //metode retron llista usuaris
       public List<Usuari> getUsuaris(){
           return usuaris;
       }
       
       public List<Joc> getJocs(){
           return jocs;
       }
       public void afegirJocs(Joc nouJoc){
           this.jocs.add(nouJoc);
       }
   
}
