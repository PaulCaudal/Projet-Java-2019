
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static mcdonalds.DBActionItem.getnames;
import static mcdonalds.DBActionItem.settrans;
import static mcdonalds.DBActionItem.setsell;
import static mcdonalds.DBAction.getdayofchange;
import static mcdonalds.DBAction.setaccount;
import static mcdonalds.DBAction.settdaywork;
/**
 *
 * @author paulc & xaviera
 */
public class Manager extends User{

    //first constructeur 
    public Manager(String login, String password, String j, Container c) 
    {
        super(login, password, j, c);
    }
    //secound one
    public Manager(Container c, String nam, String lastnam, String j) 
    {
        super(c, nam, lastnam, j);
    }
    public Container getcontenu()
    {
        //return the container
        return contenu;
    }
    @Override
    public void setoffood ()
    {
        ///get the date of the day
        Date actual=new Date();
        //get the day, the month and the year 
        final int day=actual.getDate();
        final int month=actual.getMonth()+1;
        int year=actual.getYear()+1900;
        //creat a string
        final String date2=(day+"/"+month+"/"+year);
        ///get the date of the day
        int day2=getdayofchange(day);
        if(day>day2)
        {
            settdaywork();
        }
        //creat an array of item
        final Item[] Items=new Item[10];
        String[] names;
        
        ///Label for images and information about the user
        JLabel rect = new JLabel(new ImageIcon("rect.jpg"));
        JLabel logo = new JLabel(new ImageIcon("McDo.jpg"));
        JLabel nam=new JLabel(name);
        JLabel lastnam=new JLabel(lastname);
        JLabel date=new JLabel(day+"/"+month+"/"+year);
        JLabel jobe=new JLabel(job);
        ///Label for images and information about the user
        
        ///bouton
        JButton finish=new JButton("Finish");
        JButton inv=new JButton("Inventory info");
        JButton cash=new JButton("Cashier info");
        JButton ac=new JButton("Account info");
        JButton dis=new JButton("Disconnect");
        ///bouton
        
        ///
        Font font=new Font(Font.SERIF,Font.BOLD,15);
        Color a=new Color(31,83,47);
        nam.setFont(font);
        lastnam.setFont(font);
        jobe.setFont(font);
        date.setFont(font);
        names=getnames();
        Item j;
        int x=100;
        int y=240;
        for(int i=0;i<10;i++)
        {
            j=new Item(names[i],contenu);
            j.drawItem(x, y);
            Items[i]=j;
            x=x+140;
            if(i==4)
            {
                x=100;
                y=520;
            }
        }
        contenu.add(nam);
        contenu.add(lastnam);
        contenu.add(jobe);
        contenu.add(date);
        contenu.add(dis);
        contenu.add(rect);
        contenu.add(logo);
        contenu.add(finish);
        contenu.add(inv);
        contenu.add(cash);
        contenu.add(ac);
        dis.setBounds(750, 46, 100, 20);
        rect.setBounds(650, 0, 250, 100);
        logo.setBounds(0, 0, 150, 150);
        nam.setBounds(660, 0, 150, 20);
        lastnam.setBounds(660, 23, 150, 20);
        jobe.setBounds(660, 46, 150, 20);
        finish.setBounds(700, 750, 150, 40);
        inv.setBounds(500, 750, 150, 40);
        cash.setBounds(300, 750, 150, 40);
        ac.setBounds(100, 750, 150, 40);
        date.setBounds(790,0,150,20);
        contenu.setBackground(a);
        finish.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Receipt r=new Receipt(Items,contenu);
                float totale=r.printReceipt(job,name,lastname);
                contenu=r.getcontenu();
                contenu.repaint();
                if(totale!=0)
                {
                    settrans(name,lastname,date2,totale);
                    setaccount(totale);
                }
                for(int i=0;i<10;i++)
                {
                    if(Items[i].getnb()>0)
                    {
                        setsell(day,month,Items[i].getname(),Items[i].getnb());
                    }
                    Items[i].resetnb();
                    if(Items[i].getQt()<5)
                    {
                        JOptionPane.showMessageDialog(null, "the number of "+Items[i].getname()+" is low");
                    }
                }
            }
            
        }
        );
        inv.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                inventoryinfo r=new inventoryinfo(Items,contenu,day,month,name,lastname,job);
                r.print();
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        cash.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Cashierinfo r=new Cashierinfo(contenu);
                r.print(name,lastname,job,day,month);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        ac.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Accountinfo r=new Accountinfo(contenu);
                r.print(name,lastname,job);
                contenu=r.getcontenu();
                contenu.repaint();
            }
            
        }
        );
        
        dis.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                PanelLog pan1=new PanelLog(contenu);
                pan1.paintlog();
                contenu=pan1.getcontenu();
                contenu.repaint();
                
            }
            
        }
        );
        
    }
    }
    

