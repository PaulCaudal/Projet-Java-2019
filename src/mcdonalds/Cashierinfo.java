
package mcdonalds;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import static mcdonalds.DBAction.ResearchinfoString;
import static mcdonalds.DBAction.Researchlog;
import static mcdonalds.DBAction.getinfo;


public class Cashierinfo 
{
     private Container contenu;
     public Cashierinfo(Container c)
     {
         contenu=c;
     }
     public Container getcontenu()
    {
        // return the container
        return contenu;
    }
     public void print(final String name,final String lastname,final String job,final int day,final int month)
     {
         JButton info=new JButton("view information");
         JButton send=new JButton("send information");
         JButton work=new JButton("say who work");
         JButton hire=new JButton("Hire");
         JButton fire=new JButton("Fire");
         contenu.add(info);
        contenu.add(send);
        contenu.add(work);
        contenu.add(hire);
        contenu.add(fire);
        info.setBounds(550, 450, 150, 40);
        send.setBounds(350, 450, 150, 40);
        work.setBounds(150, 450, 150, 40);
        hire.setBounds(350, 350, 150, 40);
        fire.setBounds(350, 550, 150, 40);
        info.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Names r=new Names(contenu,day);
                r.print(name,lastname,job,month);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        work.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                work r=new work(contenu);
                r.print(name,lastname,job,day,month);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        send.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Message r=new Message(contenu);
                r.print(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        hire.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                   contenu.removeAll();
                   PanelReg reg=new PanelReg(contenu);
                   reg.Paintreg(name,lastname,job);
                   contenu=reg.getcontenu();
                   contenu.repaint();
            }
        }
        );
        fire.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                   contenu.removeAll();
                   Fire reg=new Fire(contenu);
                   reg.print(name,lastname,job);
                   contenu=reg.getcontenu();
                   contenu.repaint();
            }
        }
        );
        
     }
}
