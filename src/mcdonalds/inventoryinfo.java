
package mcdonalds;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class inventoryinfo 
{
    private Container contenu;
    private final Item[] Items;
    private final int day;
    private final int month;
    private String name;
    private String lastname;
    private String job;
    public inventoryinfo(Item[] Item,Container c,int d,int m,String nom,String lnom,String jobe)
    {
        //initialise the values
        contenu=c;
        Items=Item;
        day=d;
        month=m;
        name=nom;
        lastname=lnom;
        job=jobe;
    }
    public Container getcontenu()
    {
        // return the container
        return contenu;
    }
    public void print()
    {
         JButton inventory=new JButton("Inventory lvl");
        JButton sendo=new JButton("Send order");
        JButton viewsell=new JButton("View sell");
        JButton ok=new JButton("finsh");
        contenu.add(inventory);
        contenu.add(sendo);
        contenu.add(viewsell);
        contenu.add(ok);
        inventory.setBounds(550, 450, 150, 40);
        sendo.setBounds(350, 450, 150, 40);
        viewsell.setBounds(150, 450, 150, 40);
        ok.setBounds(700, 750, 150, 40);
        inventory.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                inventory r=new inventory(Items,contenu);
                r.printInventory(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        sendo.addActionListener(new ActionListener ()
        {
             @Override
             public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Order r=new Order(Items,contenu);
                r.printOrder(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
        }
        );
        viewsell.addActionListener(new ActionListener ()
        {
             @Override
             public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Sellinv r=new Sellinv(Items,contenu,day,month);
                r.printinv(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
        }
        );
        ok.addActionListener(new ActionListener ()
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
