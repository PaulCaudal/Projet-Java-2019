
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import static mcdonalds.DBAction.getinfo;
import static mcdonalds.DBAction.firecashier;

public class Fire 
{
    private Container contenu;
    private String[]names=new String[6];
    private String[]lastnames=new String[6];
    private int j;
     public Fire(Container c)
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
         
         final JComboBox<String> cb=new JComboBox<>();
         
         JButton finish=new JButton("Finish");
         JButton ok=new JButton("Ok");
        final Font font=new Font(Font.SERIF,Font.BOLD,20);
        final Color b=new Color(255,223,35);
         names=getinfo("name");
        lastnames=getinfo("lastname");
        for(int i=0;i<6;i++)
        {
            if(names[i]!=null && lastnames[i]!=null)
            {
                cb.addItem(names[i]+" "+lastnames[i]);
            }
        }
        contenu.add(finish);
        contenu.add(ok);
        contenu.add(cb);
        finish.setBounds(700,750,150,50);
        ok.setBounds(500,750,150,50);
        cb.setBounds(350,50,150,50);
        ok.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                j=cb.getSelectedIndex();
                firecashier(names[j],lastnames[j]);
            }
            
        }
        );
        finish.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
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
