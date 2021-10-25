
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import static mcdonalds.DBAction.getinfo;
import static mcdonalds.DBAction.getsalary;


public class Salaryinfo 
{
     private Container contenu;
     private String[]names=new String[10];
     private String[]lastnames=new String[10];
     
     public Salaryinfo(Container c)
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
        JLabel nam;
        JLabel sal;
        JLabel k=new JLabel("Salary:");
         final Font font=new Font(Font.SERIF,Font.BOLD,20);
        final Color b=new Color(255,223,35);
        final JButton finish=new JButton("Finish");
        names=getinfo("name");
        lastnames=getinfo("lastname");
        k.setForeground(b);
        k.setFont(font);
        int s;
        int y=120;
        for(int i=0;i<6;i++)
        {
            if(names[i]!=null && lastnames[i]!=null)
            {
                nam=new JLabel(names[i]+" "+lastnames[i]+" :");
                s=getsalary(names[i],lastnames[i]);
                sal=new JLabel("£"+s);
                contenu.add(nam);
                contenu.add(sal);
                nam.setForeground(b);
                nam.setFont(font);
                sal.setForeground(b);
                sal.setFont(font);
                nam.setBounds(50,y,170,50);
                sal.setBounds(750,y,150,50);
                y=y+60;
            }
        }
        contenu.add(finish);
        contenu.add(k);
        finish.setBounds(700,750,150,50);
        k.setBounds(350,50,150,50);
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
