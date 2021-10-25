
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static mcdonalds.DBActionItem.getsell;

/**
 *
 * @author paulc
 */
public class Sellinv 
{
    private Container contenu;
    private final Item[] Items;
    private final int day;
    private final int month;
    public Sellinv(Item[] Item,Container c,int d,int m)
    {
        //initialise the values
        contenu=c;
        Items=Item;
        day=d;
        month=m;
    }
    public Container getcontenu()
    {
        // return the container
        return contenu;
    }
    public void printinv(final String nam,final String lastname,final String job)
    {
        final JComboBox<String> textname=new JComboBox<>();
        final JComboBox<String> days=new JComboBox<>();
        
        final JButton ok=new JButton("ok");
        final JButton finish=new JButton("finish");
        for(int i=0;i<10;i++)
        {
            textname.addItem(Items[i].getname());
            days.addItem(""+i);
        }
        contenu.add(ok);
        contenu.add(days);
        contenu.add(finish);
        contenu.add(textname);
        days.setBounds(650,10,50,50);
        ok.setBounds(500, 750, 150, 40);
        finish.setBounds(700, 750, 150, 40);
        textname.setBounds(300,10,300,50);
        ok.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               int j=textname.getSelectedIndex();
               int m=days.getSelectedIndex();
               JLabel qt;
               JLabel name;
               int y=100;
               Font font=new Font(Font.SERIF,Font.BOLD,20);
               Color b=new Color(255,223,35);
               contenu.removeAll();
               int daytemp=day;
               int monthtemp=month;
               for(int i=0;i<m;i++)
               {
                   if(i!=0)
                   {
                       daytemp=daytemp-1;
                   }
                   if(daytemp==0)
                   {
                       monthtemp=monthtemp-1;
                       if(monthtemp==1 || monthtemp==3 || monthtemp==5 ||monthtemp==7 ||monthtemp==8 ||monthtemp==10 ||monthtemp==12)
                       {
                           daytemp=31;
                       }
                       if(monthtemp==4 || monthtemp==6 || monthtemp==9 ||monthtemp==11)
                       {
                           daytemp=30;
                       }
                       if(monthtemp==4)
                       {
                           daytemp=29;
                       }
                   }
                   name=new JLabel(daytemp+"/"+monthtemp);
                   int k=getsell(daytemp,monthtemp,Items[j].getname());
                   qt=new JLabel(k+"");
                   name.setForeground(b);
                   name.setFont(font);
                   qt.setForeground(b);
                   qt.setFont(font);
                   contenu.add(name);
                   contenu.add(qt);
                   name.setBounds(20, y, 150, 40);
                   qt.setBounds(700, y, 150, 40);
                   y=y+60;
               }
               contenu.add(ok);
               contenu.add(finish);
               contenu.add(textname);
               contenu.add(days);
               days.setBounds(650,10,50,50);
               ok.setBounds(500, 750, 150, 40);
               finish.setBounds(700, 750, 150, 40);
               textname.setBounds(300,10,300,50);
               contenu.repaint();
            }
            
        }
        );
        finish.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ///return on the manager screen
                contenu.removeAll();
                Manager c= new Manager(contenu,nam,lastname,job);
                c.setoffood();
                contenu=c.getcontenu();
                contenu.repaint();
                ///return on the manager screen 
            }
            
        }
        );
    }
}
