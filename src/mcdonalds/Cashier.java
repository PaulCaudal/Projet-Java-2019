
package mcdonalds;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.ImageIcon;
import static mcdonalds.DBActionItem.settrans;
import java.util.Date;
import javax.swing.JOptionPane;
import static mcdonalds.DBAction.getMessage;
import static mcdonalds.DBAction.getdayofwork;
import static mcdonalds.DBActionItem.getnames;
import static mcdonalds.DBAction.setaccount;
public class Cashier extends User
{
    
    public Cashier(String login, String password,String j,Container c)
    {
        super(login, password, j, c);
    }
    public Cashier(Container c, String nam, String lastnam, String j) 
    {
        super(c, nam, lastnam, j);
    }
    public Container getcontenu()
    {
         return contenu;
    }
    @Override
    public void setoffood ()
    {
        
        Date actual=new Date();
        final int day=actual.getDate();
        final int month=actual.getMonth();
        int year=actual.getYear()+2000-100;
        final String date2=(day+"/"+month+"/"+year);
        final Item[] Items=new Item[10];
        String[] names;
        Color a=new Color(31,83,47);
        JLabel rect = new JLabel(new ImageIcon("rect.jpg"));
        JLabel logo = new JLabel(new ImageIcon("McDo.jpg"));
        JLabel tomorrow;
        int w;
        JLabel nam=new JLabel(name);
        JLabel lastnam=new JLabel(lastname);
        JLabel date=new JLabel(day+"/"+month+"/"+year);
        JLabel jobe=new JLabel(job);
        JButton bouton=new JButton("Finish");
        JButton sch=new JButton("View my schedule");
        JButton dis=new JButton("Disconect");
        Font font=new Font(Font.SERIF,Font.BOLD,15);
        Font font1=new Font(Font.SERIF,Font.BOLD,20);
        Color b=new Color(255,223,35);
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
        contenu.add(bouton);
        contenu.add(sch);
        rect.setBounds(650, 0, 250, 100);
        logo.setBounds(0, 0, 150, 150);
        nam.setBounds(660, 0, 150, 20);
        lastnam.setBounds(660, 23, 150, 20);
        jobe.setBounds(660, 46, 150, 20);
        dis.setBounds(750, 46, 100, 20);
        bouton.setBounds(700, 750, 150, 40);
        sch.setBounds(500, 750, 150, 40);
        date.setBounds(790,0,150,20);
        String message=getMessage(name,lastname);
        if(message!=null)
        {
            JOptionPane.showMessageDialog(null, message);
        }
        contenu.setBackground(a);
        bouton.addActionListener(new ActionListener ()
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
                    Items[i].resetnb();
                }
            }
            
        }
        );
         sch.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                schedule r=new schedule(contenu,day);
                r.print(name,lastname,job,month);
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
