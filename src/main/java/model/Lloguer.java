package model;
import java.time.LocalDate;

/**
 *
 * @author mpers
 */
public class Lloguer {
    private int numRegistre;
    private Usuari usuari;
    private Joc joc;
    private Plataforma plataforma;
    private LocalDate dataInici;
    private LocalDate dataPrevista;
    private boolean retornat;
    
    public Lloguer (int numRegistre, Usuari usuari, Joc joc, Plataforma plataforma, LocalDate dataInici, LocalDate dataEntregaPrevista, boolean retornat, int diesLloguer){
        this.numRegistre = numRegistre;
        this.usuari = usuari;
        this.joc = joc;
        this.plataforma = plataforma;
        this.dataInici = dataInici;
        this.dataPrevista = dataInici.plusDays(diesLloguer);
        this.retornat= false;
    }

    //setter
    public void setNumRegistre(int numRegistre){this.numRegistre = numRegistre;}
    public void setJoc(Joc joc){this.joc = joc;}
    public void setPlataforma(Plataforma plataforma){this.plataforma = plataforma;}
    public void setDataInici(LocalDate dataInici){this.dataInici = dataInici;}
    public void setDataPrevista(LocalDate dataPrevista){this.dataPrevista = dataPrevista;}
    public void setUsuari(Usuari usuari) {this.usuari = usuari;}
    public void setRetornat(boolean retornat) {this.retornat = retornat;
    }
    
    //getter
    public int getNumRegistre(){return numRegistre;}
    public Usuari getUsuari(){return usuari;}
    public Joc getJoc(){return joc;}
    public Plataforma getPlataforma(){return plataforma;}
    public LocalDate getDataInici(){return dataInici;}
    public LocalDate getDataPrevista(){return dataPrevista;}
    public boolean isRetornat() {return retornat;}
    
    public boolean foraDeTermini(){
        return !retornat && LocalDate.now().isAfter(dataPrevista);
    }
    public String getEstatText(){
        if (retornat){
            return "Retornat";
        } else if (foraDeTermini()){
            return "No retornat";
        } else {
            return "Actiu";
        }
 
    }
    
    @Override 
    public String toString() { 
         return "Lloguer " + numRegistre + " - " +  usuari.getNomComplet() + " (" + joc.getNom() + ")"; 
    }
}
