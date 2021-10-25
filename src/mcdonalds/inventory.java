
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;


public class inventory 
{
    private final Item[] Items;
    private Container contenu;
    public inventory (Item[] Item,Container c)
    {
        //initialise the values
        contenu=c;
        Items=Item;
    }
    public Container getcontenu()
    {
        //return the container
        return contenu;
    }
    public void printInventory(final String nam,final String lastname,final String job)
    {
        ///Label to dysplay the neme and the quantity of eich item
        JLabel name;
        JLabel Qt;
        ///Label to dysplay the neme and the quantity of eich item
        
        ///bouton
        JButton ok=new JButton("OK");
        ///bouton
        
        ///creat a font and a color
        int y=20;
        Font font=new Font(Font.SERIF,Font.BOLD,20);
        Color b=new Color(255,223,35);
        ///creat a font and a color
        
        ///exctrate and display the information of the item 
        for(int i=0;i<10;i++)
        {
            name=new JLabel(Items[i].getname());
            Qt=new JLabel(""+Items[i].getQt());
            //set the color and the font
            name.setForeground(b);
            Qt.setForeground(b);
            name.setFont(font);
            Qt.setFont(font);
            //add to to container
            contenu.add(name);
            contenu.add(Qt);
            //place it on the window
            Qt.setBounds(700,y,100,50);
            name.setBounds(10,y,300,50);
            y=y+60;
        }
        ///exctrate and display the information of the item 
        
        ///add and place the bouton on the window 
        contenu.add(ok);
        ok.setBounds(400,y,100,50);
        ///add and place the bouton on the window 
        
        ////creat an action on the boutton "ok"
        ok.addActionListener(new ActionListener ()
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
        ////create an action on the boutton "ok"
    }
}
