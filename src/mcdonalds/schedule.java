
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import static mcdonalds.DBAction.getdayofwork;


public class schedule 
{
     private Container contenu;
     private int day;
     public schedule(Container c,int d)
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
         final JButton finish=new JButton("Finish");
         final Font font=new Font(Font.SERIF,Font.BOLD,20);
        final Color b=new Color(255,223,35);
        
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
            ans=getdayofwork(name,lastname,temp);
            day=new JLabel(ans);
            day.setFont(font);
            day.setForeground(b);
            contenu.add(day);
            day.setBounds(x,210,100,50);
            x=x+150;
        }
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
        contenu.add(day1);
        contenu.add(day2);
        contenu.add(day3);
        contenu.add(day4);
        contenu.add(day5);
        contenu.add(day6);
        contenu.add(finish);
        finish.setBounds(700,750,150,50);
        day1.setBounds(50,150,100,50);
        day2.setBounds(200,150,100,50);
        day3.setBounds(350,150,100,50);
        day4.setBounds(500,150,100,50);
        day5.setBounds(650,150,100,50);
        day6.setBounds(800,150,100,50);
        finish.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ///return on the manager screen
                contenu.removeAll();
                Cashier c= new Cashier(contenu,name,lastname,job);
                c.setoffood();
                contenu=c.getcontenu();
                contenu.repaint();
                ///return on the manager screen 
            }
            
        }
        );
     }
}
