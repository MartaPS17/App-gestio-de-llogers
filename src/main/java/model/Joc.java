package model;
import java.util.Map;
import java.util.EnumMap;

/**
 *
 * @author mpers
 */
public class Joc {
    private String nom;
    private String genere;
    private final Map<Plataforma, Integer> estocPerPlataforma;
    
    public Joc(String nom, String genere){
        this.nom= nom;
        this.genere = genere;
        this.estocPerPlataforma = new EnumMap<>(Plataforma.class);
        for(Plataforma p : Plataforma.values()){
            estocPerPlataforma.put(p,0);
        }
        
    }
    
    //getter

    public String getNom() {return nom;}
    public String getGenere() { return genere; }
    
    public Map<Plataforma, Integer> getEstocPerPlataforma() {
        return estocPerPlataforma;
    }
    
    public int getEstoc(Plataforma plataforma){
        return estocPerPlataforma.getOrDefault(plataforma,0);
    }
    
    //setters

    public void setNom(String nom) {this.nom = nom;}
    public void setGenere(String genere) {this.genere = genere; }
    public void setEstoc(Plataforma plataforma, int quantitat){
        estocPerPlataforma.put(plataforma, Math.max(0, quantitat));
    }

}
