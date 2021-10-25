
package mcdonalds;

import javax.swing.JFrame;
import java.awt.Container;


public class McDonalds {

   
    public static void main(String[] args) 
    {
        JFrame fenetre=new JFrame();
        
        
        fenetre.setTitle("McDonalds");
        fenetre.setSize(900,900);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        PanelLog pan1=new PanelLog(fenetre.getContentPane());
        pan1.paintlog();
        
        
        
       
       
      
    }
    
}
