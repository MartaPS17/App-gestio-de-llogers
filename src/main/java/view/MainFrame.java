
package view;

import controller.GestorDades;
import model.Lloguer;

import java.awt.Color;
import model.Lloguer;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.BorderLayout;



public class MainFrame extends JFrame {
    
    private JTable taulaLloguers;
    private DefaultTableModel modelTaula;
    
    public MainFrame(){
        setTitle("Aplicació de Gestió Lloguer de Videojocs");
        setSize(600,400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //MenuBar
        setJMenuBar(crearBarraMenus());
        inicialitzarTaula();
        add(new JScrollPane(taulaLloguers), BorderLayout.CENTER);
        carregarTotesLesFiles();
        setVisible(true);
    }
    
    private JMenuBar crearBarraMenus(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createLloguerMenu());
        menuBar.add(createUsuariMenu());
        menuBar.add(createJocMenu());
        return menuBar;   
    }
    
    //menu op principal
    private JMenu createLloguerMenu(){
        JMenu lloguerMenu = new JMenu("Lloguer"); 
        //submenu de lloguer
        JMenuItem lloguer1 = new JMenuItem("Registrar"); 
        JMenuItem lloguer2 = new JMenuItem("Tornar"); 
        
        lloguerMenu.add(lloguer1);
        lloguerMenu.add(lloguer2);
        return lloguerMenu;
   
        
    }
           
    private JMenu createUsuariMenu(){
        JMenu usuariMenu = new JMenu("Usuari");
        
        JMenuItem usuari1 = new JMenuItem("Crear"); 
        JMenuItem usuari2 = new JMenuItem("Borrar");
        
        usuariMenu.add(usuari1);
        usuariMenu.add(usuari2);
        return usuariMenu;
        
    }
    
    private JMenu createJocMenu(){
        JMenu jocMenu = new JMenu("Joc");     
        JMenuItem joc1 = new JMenuItem("Crear");
        JMenuItem joc2 = new JMenuItem("Borrar");
        
        jocMenu.add(joc1);
        jocMenu.add(joc2);
        return jocMenu;
    }
    
    //table 
         private void inicialitzarTaula() {
                String [] nomColumna = {"Núm.Registre", "Titil del Joc", "Usuari que l'ha llogat", 
                    "Plataforma", "Data d'inici", "Data de tornada", "Gènere"
                };   
                
                //DefaultTableModel buit inicial i evitar que s'usuari pugui editar ses taules
                
                modelTaula = new DefaultTableModel(nomColumna, 0){
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false; 
                    }
                };
               
                taulaLloguers = new JTable(modelTaula);
                taulaLloguers.setRowHeight(25);   
            }
         
         //fer net sa taula i carregar collguers del controlador
         
         public void carregarTotesLesFiles(){
             modelTaula.setRowCount(0);
             
             List<Lloguer> llista = GestorDades.getInstancia().getLloguers();
             for(Lloguer lloguer : llista){
                 afegirFila(lloguer);
             }
        }
         
         //afegir objecte lloguer com a nova fila (nomes 1)
         public void afegirFila(Lloguer lloguer){
             Object[] fila = new Object[]{
                 lloguer.getNumRegistre(),
                 lloguer.getJoc().getNom(),
                 lloguer.getUsuari().getNom() + " " + lloguer.getUsuari().getLlinatge1(),
                 lloguer.getPlataforma().name(),
                 lloguer.getDataInici().toString(),
                 lloguer.getDataPrevista().toString(),
                 lloguer.getJoc().getGenere()         
             };
             
             //inserir fila
             modelTaula.addRow(fila);
         }
    

    
    public static void main(String[] args){
        UIManager.put("MenuBar.background", new Color(200,220,240));
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
       
    }
    
}
