
package mcdonalds;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static mcdonalds.DBActionItem.UpdateDB;
import static mcdonalds.DBActionItem.getinfofloat;
import static mcdonalds.DBActionItem.getinfoint;


public class Item 
{
    private final String name;
    private int Qt;
    private final float price;
    private final Container contenu;
    private int nb;
    public Item(String nam,Container c)
    {
        name=nam;
        Qt=getinfoint(name,"qt");
        price=getinfofloat(name,"price");
        contenu=c;
        contenu.setLayout(null);
        nb=0;
    }
    public void resetnb()
    {
        nb=0;
    }
    public String getname()
    {
        return name;
    }
    public Container getcontenu()
    {
        return contenu;
    }
    public float getprice()
    {
        return price;
    }
    public void setqt(int nb)
    {
        Qt=Qt-nb;
        UpdateDB(name,Qt);
    }
     public int getQt()
    {
        return Qt;
    }
   
     public int getnb()
    {
        return nb;
    }
    public void drawItem(int x,int y)
    {
        JLabel img = new JLabel(new ImageIcon(name+".jpg"));
        JButton bouton=new JButton(name);
        contenu.add(img);
        contenu.add(bouton);
        img.setBounds(x, y, 100, 100);
        bouton.setBounds(x-10, y+115, 120, 40);
        bouton.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(Qt-nb>0)
                {
                    nb=nb+1;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "there is no more "+name);
                }
            }
            
        }
        );
    }
}
