
package mcdonalds;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Accountinfo
{
    private Container contenu;
     public Accountinfo(Container c)
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
         JButton info=new JButton("view account");
         JButton sal=new JButton("view salary");
         JButton setsal=new JButton("set the salary");
         contenu.add(info);
        contenu.add(sal);
        contenu.add(setsal);
        info.setBounds(550, 450, 150, 40);
        sal.setBounds(350, 450, 150, 40);
        setsal.setBounds(150, 450, 150, 40);
        info.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                account r=new account(contenu);
                r.print(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        sal.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Salaryinfo r=new Salaryinfo(contenu);
                r.print(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        setsal.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Salaryset r=new Salaryset(contenu);
                r.print(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
     }
}
