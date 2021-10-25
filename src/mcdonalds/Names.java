
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static mcdonalds.DBAction.getdayofwork;
import static mcdonalds.DBAction.getinfo;

public class Names 
{
     private Container contenu;
     private String[]names=new String[10];
     private String[]lastnames=new String[10];
     private int day;
     public Names(Container c,int d)
     {
         contenu=c;
         day=d;
     }
     public Container getcontenu()
    {
        // return the container
        return contenu;
    }
     public void print(final String name,final String lastname,final String job,final int month)
     {
         JLabel cashier;
         
         JLabel work;
         JLabel k=new JLabel("Who work thomorow");
         final JButton finish=new JButton("Finish");
         final JButton ok=new JButton("Ok");
        
        final JComboBox<String> cb=new JComboBox<>();
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
        int y=120;
       int tomorrow;
        k.setForeground(b);
        k.setFont(font);
        contenu.add(finish);
         contenu.add(cb);
         contenu.add(ok);
        //contenu.add(k);
        finish.setBounds(700,750,150,50);
        ok.setBounds(500,750,150,50);
        cb.setBounds(300,50,350,50);
        //k.setBounds(300,50,350,50);
        /*for(int i=0;i<6;i++)
        {
            if(names[i]!=null && lastnames[i]!=null)
            {
                cashier=new JLabel(names[i]+"  "+lastnames[i]);
                tomorrow=getdayofwork(names[i],lastnames[i]);
                if( tomorrow==1)
                {
                    work=new JLabel("Yes");
                }
                else
                {
                    work=new JLabel("No");
                }
                cashier.setFont(font);
                cashier.setForeground(b);
                work.setFont(font);
                work.setForeground(b);
                contenu.add(cashier);
                contenu.add(work);
                cashier.setBounds(50, y, 150, 50);
                work.setBounds(550, y, 150, 50);
                y=y+60;
            }
        }*/
        ok.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                int j=cb.getSelectedIndex();
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
                day=day-6;
                JLabel day=null;
                int x=50; 
                String temp;
                String ans;
                for(int i=1;i<7;i++)
                {
                    temp="day+"+i;
                    ans=getdayofwork(names[j],lastnames[j],temp);
                    day=new JLabel(ans);
                    day.setFont(font);
                    day.setForeground(b);
                    contenu.add(day);
                    day.setBounds(x,210,100,50);
                    x=x+150;
                }
               
                //System.out.println(temp);
                
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
                contenu.add(finish);
                contenu.add(cb);
                contenu.add(ok);
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
