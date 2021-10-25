
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static mcdonalds.DBAction.getinfo;
import static mcdonalds.DBAction.setdayofwork;

public class work 
{
     private Container contenu;
     private String[]names=new String[10];
         private String[]lastnames=new String[10];
         private int s;
     public work(Container c)
     {
         contenu=c;
     }
     public Container getcontenu()
    {
        // return the container
        return contenu;
    }
     public void print(final String name,final String lastname,final String job,int day,int month)
     {
         JLabel cashier;
         final JComboBox<String> cb=new JComboBox<>();
         final JComboBox<String> cb0 =new JComboBox<>() ;
         final JComboBox<String> cb1 =new JComboBox<>();
         final JComboBox<String> cb2 =new JComboBox<>();
         final JComboBox<String> cb3=new JComboBox<>();
         final JComboBox<String> cb4=new JComboBox<>();
         final JComboBox<String> cb5 =new JComboBox<>();
        day=day+1;
        JLabel day1=new JLabel(day+"/"+month);
        day=day+1;
        JLabel day2=new JLabel(day+"/"+month);
        day=day+1;
        JLabel day3=new JLabel(day+"/"+month);
        day=day+1;
        JLabel day4=new JLabel(day+"/"+month);
        day=day+1;
        JLabel day5=new JLabel(day+"/"+month);
        day=day+1;
        JLabel day6=new JLabel(day+"/"+month);
         
         JButton finish=new JButton("Finish");
         JButton ok=new JButton("Ok");
        Font font=new Font(Font.SERIF,Font.BOLD,20);
        Color b=new Color(255,223,35);
         names=getinfo("name");
        lastnames=getinfo("lastname");
        for(int i=0;i<6;i++)
        {
            if(names[i]!=null && lastnames[i]!=null)
            {
                cb.addItem(names[i]+" "+lastnames[i]);
            }
        }
        s=names.length;
        int y=120;
        
        contenu.add(finish);
       
        finish.setBounds(700,750,150,50);
       
        day1.setFont(font);
        day1.setForeground(b);
        day2.setFont(font);
        day2.setForeground(b);
        day3.setFont(font);
        day3.setForeground(b);
        day4.setFont(font);
        day4.setForeground(b);
        day5.setFont(font);
        day5.setForeground(b);
        day6.setFont(font);
        day6.setForeground(b);
        contenu.add(finish);
        contenu.add(cb);
        contenu.add(ok);
        contenu.add(day1);
        contenu.add(day2);
        contenu.add(day3);
        contenu.add(day4);
        contenu.add(day5);
        contenu.add(day6);
        //contenu.add(k);
        finish.setBounds(700,750,150,50);
        ok.setBounds(500,750,150,50);
        cb.setBounds(300,50,350,50);
        day1.setBounds(50,150,100,50);
        day2.setBounds(200,150,100,50);
        day3.setBounds(350,150,100,50);
        day4.setBounds(500,150,100,50);
        day5.setBounds(650,150,100,50);
        day6.setBounds(800,150,100,50);
        
        y=210;
       
        cb0.addItem("no");
        cb0.addItem("yes");
        contenu.add(cb0);
        cb0.setBounds(50, y, 100, 50);
        cb1.addItem("no");
        cb1.addItem("yes");
        contenu.add(cb1);
        cb1.setBounds(200, y, 100, 50);
        cb2.addItem("no");
        cb2.addItem("yes");
        contenu.add(cb2);
        cb2.setBounds(350, y, 100, 50);
        cb3.addItem("no");
        cb3.addItem("yes");
        contenu.add(cb3);
        cb3.setBounds(500, y, 100, 50);
        cb4.addItem("no");
        cb4.addItem("yes");
        contenu.add(cb4);
        cb4.setBounds(650, y, 100, 50);
        cb5.addItem("no");
        cb5.addItem("yes");
        contenu.add(cb5);
        cb5.setBounds(800, y, 100, 50);
        ok.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int r0,r1,r2,r3,r4,r5;    
                int j=cb.getSelectedIndex();
                r0 = cb0.getSelectedIndex();
                r1 = cb1.getSelectedIndex();
                r2 = cb2.getSelectedIndex();
                r3 = cb3.getSelectedIndex();
                r4 = cb4.getSelectedIndex();
                r5 = cb5.getSelectedIndex();
                setdayofwork(names[j],lastnames[j],r0,r1,r2,r3,r4,r5);
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
