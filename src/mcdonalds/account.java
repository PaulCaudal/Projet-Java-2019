
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import static mcdonalds.DBAction.getaccount;


public class account 
{
    private Container contenu;
     
     public account(Container c)
     {
         contenu=c;
         
     }
     public Container getcontenu()
    {
        // return the container
        return contenu;
    }
     public void print(final String name,final String lastname,final String job)
     {
        JLabel k=new JLabel("Account:");
        final JButton finish=new JButton("Finish");
        final Font font=new Font(Font.SERIF,Font.BOLD,20);
        final Color b=new Color(255,223,35);
        float a=getaccount();
        JLabel ac=new JLabel("£"+a);
        k.setForeground(b);
        k.setFont(font);
        ac.setForeground(b);
        ac.setFont(font);
        contenu.add(finish);
        contenu.add(k);
        contenu.add(ac);
        finish.setBounds(700,750,150,50);
        k.setBounds(350,50,350,50);
        ac.setBounds(350,150,350,50);
        finish.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ///return on the manager screen
                contenu.removeAll();
                Manager c= new Manager(contenu,name,lastname,job);
                c.setoffood();
                contenu=c.getcontenu();
                contenu.repaint();
                ///return on the manager screen 
            }
            
        }
        );
     }
}
