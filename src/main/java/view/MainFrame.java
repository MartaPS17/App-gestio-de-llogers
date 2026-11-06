
package view;
import java.awt.Color;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.JMenuBar;

/**
 *
 * @author mpers
 */
public class MainFrame extends JFrame{
    
    public MainFrame(){
        
        setTitle("Aplicació de Gestió Lloguer de Videojocs");
        setSize(600,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //MenuBar
        setJMenuBar(crearBarraMenus());
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
    

    
    
    
    
    public static void main(String[] args){
        UIManager.put("MenuBar.background", new Color(200,220,240));
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
       
    }
    
}
