package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static mcdonalds.DBAction.Researchlog;
import static mcdonalds.DBAction.ResearchinfoString;
import static mcdonalds.DBAction.gettdaywork;
/**
 *
 * @author paulc
 */
public class PanelLog 
{
    
   private Container contenu;
   
   public PanelLog(Container c)
   {
       contenu=c;
       contenu.setLayout(null);
   }
    public Container getcontenu()
    {
         return contenu;
    }
   
    
    public void paintlog()
    {
       
        
         
         Color a=new Color(31,83,47);
         Color b=new Color(255,223,35);
         JLabel log=new JLabel("Login:");
         JLabel pass=new JLabel("password:");
        JButton logb=new JButton("Login");
        
        final JPasswordField textpass=new JPasswordField();
        final JTextField textlog=new JTextField();
        JLabel img = new JLabel(new ImageIcon("McDo.jpg"));
        Font font1=new Font(Font.SERIF,Font.BOLD,25);
        textlog.setFont(font1);
        textpass.setFont(font1);
        log.setForeground(b);
        pass.setForeground(b);
        textpass.setEchoChar('*');
        Font font=new Font(Font.SERIF,Font.BOLD,45);
        log.setFont(font);
        pass.setFont(font);
        contenu.add(log);
        contenu.add(pass);
        contenu.add(logb);
        
        contenu.add(textlog);
        contenu.add(textpass);
        contenu.add(img);
        textlog.setBounds(350, 360, 300, 50);
        textpass.setBounds(350, 460, 300, 50);
        logb.setBounds(300, 570, 250, 60);
        
        log.setBounds(120, 360, 200, 60);
        pass.setBounds(120, 460, 200, 60);
        img.setBounds(0, 0, 150, 150);
        contenu.setBackground(a);
        logb.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String login=textlog.getText();
                String password=textpass.getText();
                 int i=Researchlog(login,password);
                 String job=ResearchinfoString(login,password,"job");
                String name=ResearchinfoString(login,password,"name");
                 String lastname=ResearchinfoString(login,password,"lastname");
                 int j=gettdaywork(name,lastname);
                 if(i==1 && "cashier".equals(job) && j==1)
                 {
                    contenu.removeAll();
                    Cashier c= new Cashier(login,password,job,contenu);
                    c.setoffood();
                    contenu=c.getcontenu();
                    contenu.repaint();
                 }
                 if(i==1 && "manager".equals(job))
                 {
                    contenu.removeAll();
                    Manager c= new Manager(login,password,job,contenu);
                    c.setoffood();
                    contenu=c.getcontenu();
                    contenu.repaint();
                 }
                 if(j==0)
                 {
                     JOptionPane.showMessageDialog(null, "your not supposed to work today");
                 }
            }
            
        }
        );
        
        
   
  }
    
    
}
