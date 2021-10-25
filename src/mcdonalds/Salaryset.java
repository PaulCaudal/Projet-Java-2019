
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static mcdonalds.DBAction.getinfo;
import static mcdonalds.DBAction.setsalary;


public class Salaryset 
{
    private Container contenu;
     private String[]names=new String[6];
         private String[]lastnames=new String[6];
         private JTextField newsal ;
         private int j;
     public Salaryset(Container c)
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
                JLabel cashier=new JLabel(names[j]+" "+lastnames[j]);
                JLabel p=new JLabel("£");
                newsal=new JTextField();
                contenu.add(cashier);
                contenu.add(newsal);
                contenu.add(p);
                cashier.setFont(font);
                cashier.setForeground(b);
                p.setFont(font);
                p.setForeground(b);
                cashier.setBounds(50,200,150,50);
                p.setBounds(580,200,10,50);
                newsal.setBounds(600,200,150,50);
                contenu.repaint();
                
            }
            
        }
        );
        finish.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String ns=newsal.getText();
                float sal=Float.parseFloat(ns);
                setsalary(names[j],lastnames[j],sal);
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
