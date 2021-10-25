
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static mcdonalds.DBActionItem.UpdateDB;


public class Order 
{
    private Container contenu;
    private final Item[] Items;
    public Order(Item[] Item,Container c)
    {
        //initialise the values
        contenu=c;
        Items=Item;
    }
    public Container getcontenu()
    {
        // return the container
        return contenu;
    }
    public void printOrder(final String nam,final String lastname,final String job)
    {
        ///text feild for the quantity
        final JTextField Qt1=new JTextField("0");
        final JTextField Qt2=new JTextField("0");
        final JTextField Qt3=new JTextField("0");
        final JTextField Qt4=new JTextField("0");
        final JTextField Qt5=new JTextField("0");
        final JTextField Qt6=new JTextField("0");
        final JTextField Qt7=new JTextField("0");
        final JTextField Qt8=new JTextField("0");
        final JTextField Qt9=new JTextField("0");
        final JTextField Qt10=new JTextField("0");
        ///text feild for the quantity
        
        ///bouton
        JButton finish=new JButton("finish");
        ///bouton
        
        ///Label
        JLabel name;
        JLabel itemtext=new JLabel("Item:");
        JLabel Qttext=new JLabel("Qt:");
        ///Label
        
        ///color and size of the Labels
        Font font=new Font(Font.SERIF,Font.BOLD,20);
        Color b=new Color(255,223,35);
        itemtext.setForeground(b);
        Qttext.setForeground(b);
        itemtext.setFont(font);
        Qttext.setFont(font);
        ///color and size of the Labels
        
        ///put every things,exept the nams, in the container and place them on the window
        int y=150;
        contenu.add(Qt1);
        contenu.add(Qt2);
        contenu.add(Qt3);
        contenu.add(Qt4);
        contenu.add(Qt5);
        contenu.add(Qt6);
        contenu.add(Qt7);
        contenu.add(Qt8);
        contenu.add(Qt9);
        contenu.add(Qt10);
        contenu.add(Qttext);
        contenu.add(itemtext);
        contenu.add(finish);
        finish.setBounds(450,770,100,50);
        itemtext.setBounds(100, 90, 100, 20);
        Qttext.setBounds(650, 90, 40, 20);
        Qt1.setBounds(650,y,100,50);
        y=y+60;
        Qt2.setBounds(650,y,100,50);
        y=y+60;
        Qt3.setBounds(650,y,100,50);
        y=y+60;
        Qt4.setBounds(650,y,100,50);
        y=y+60;
        Qt5.setBounds(650,y,100,50);
        y=y+60;
        Qt6.setBounds(650,y,100,50);
        y=y+60;
        Qt7.setBounds(650,y,100,50);
        y=y+60;
        Qt8.setBounds(650,y,100,50);
        y=y+60;
        Qt9.setBounds(650,y,100,50);
        y=y+60;
        Qt10.setBounds(650,y,100,50);
        ///put every things,exept the nams, in the container and place them on the window
        
        ///put the names in the container and place them on the window
        y=150;
        for(int i=0;i<10;i++)
        {
            name=new JLabel(Items[i].getname());
            name.setForeground(b);
            name.setFont(font);
            contenu.add(name);
            name.setBounds(100,y,300,50);
            y=y+60;
        }
        ///put the names in the container and place them on the window
        
        ////creat an action on the bouton "finish"
        finish.addActionListener(new ActionListener ()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ///get all the quantity that the user select for the items and Update the data base
                    int qt;
                    qt=Items[0].getQt()+Integer.parseInt(Qt1.getText());
                    UpdateDB(Items[0].getname(),qt);
                    qt=Items[1].getQt()+Integer.parseInt(Qt2.getText());
                    UpdateDB(Items[1].getname(),qt);
                    qt=Items[2].getQt()+Integer.parseInt(Qt3.getText());
                    UpdateDB(Items[2].getname(),qt);
                    qt=Items[3].getQt()+Integer.parseInt(Qt4.getText());
                    UpdateDB(Items[3].getname(),qt);
                    qt=Items[4].getQt()+Integer.parseInt(Qt5.getText());
                    UpdateDB(Items[4].getname(),qt);
                    qt=Items[5].getQt()+Integer.parseInt(Qt6.getText());
                    UpdateDB(Items[5].getname(),qt);
                    qt=Items[6].getQt()+Integer.parseInt(Qt7.getText());
                    UpdateDB(Items[6].getname(),qt);
                    qt=Items[7].getQt()+Integer.parseInt(Qt8.getText());
                    UpdateDB(Items[7].getname(),qt);
                    qt=Items[8].getQt()+Integer.parseInt(Qt9.getText());
                    UpdateDB(Items[8].getname(),qt);
                    qt=Items[9].getQt()+Integer.parseInt(Qt10.getText());
                    UpdateDB(Items[9].getname(),qt);
                    ///get all the quantity that the user select for the items and Update the data base
                    
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
        ////create an action on the bouton "finish"
    }
}
