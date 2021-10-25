package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;



public class Receipt 
{
    private final Item[] Items;
    private Container contenu;
    public Receipt(Item[] I, Container c)
    {
        Items=I;
        contenu=c;
    }
    public Container getcontenu()
    {
         return contenu;
    }
    public float printReceipt(final String job,final String name, final String lastname)
    {
        int nb;
        float totaltl=0;
        float total;
        int y=20;
        JLabel item;
        JLabel price;
        JButton ok=new JButton("OK");
        Font font=new Font(Font.SERIF,Font.BOLD,20);
        Color b=new Color(255,223,35);
        for(int i=0; i<10; i++)
        {
            nb=Items[i].getnb();
            if(nb>0)
            {
                
               totaltl=totaltl+nb*Items[i].getprice();
               
               item=new JLabel(Items[i].getname());
               price=new JLabel("£ "+Items[i].getprice()+"  X  "+nb);
               item.setForeground(b);
               price.setForeground(b);
               contenu.add(price);
               contenu.add(item);
               item.setFont(font);
               price.setFont(font);
               price.setBounds(700,y,100,50);
               item.setBounds(10,y,300,50);
               y=y+60;
               Items[i].setqt(nb);
            }
            
        }
        total=(float) (totaltl*1.2);
        price=new JLabel("£ "+total);
        price.setFont(font);
        price.setForeground(b);
        contenu.add(price);
        contenu.add(ok);
        price.setBounds(400,y,100,50);
        y=y+60;
        ok.setBounds(400,y,100,50);
              ok.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                
                 if("cashier".equals(job))
                 {
                    contenu.removeAll();
                    Cashier c= new Cashier(contenu,name,lastname,job);
                    c.setoffood();
                    contenu=c.getcontenu();
                    contenu.repaint();
                 }
                 if( "manager".equals(job))
                 {
                    contenu.removeAll();
                    Manager c= new Manager(contenu,name,lastname,job);
                    c.setoffood();
                    contenu=c.getcontenu();
                    contenu.repaint();
                 }
            }
            
        }
        );
        return total;
    }
}
