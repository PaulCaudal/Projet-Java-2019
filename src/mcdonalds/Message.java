/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static mcdonalds.DBAction.getinfo;
import static mcdonalds.DBAction.setMessage;
/**
 *
 * @author paulc
 */
public class Message 
{
    private Container contenu;
    private String[]names=new String[10];
    private String[]lastnames=new String[10];
     public Message(Container c)
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
         JButton finish=new JButton("Finish");
         final JTextField message=new JTextField();
         JLabel msg=new JLabel("Enter your message and say who will receive it");
         JLabel send=new JLabel("send");
         JLabel to=new JLabel("to");
         Font font=new Font(Font.SERIF,Font.BOLD,20);
        Color b=new Color(255,223,35);
         final JComboBox<String> cb=new JComboBox<>();
        names=getinfo("name");
        lastnames=getinfo("lastname");
        send.setFont(font);
        msg.setFont(font);
        to.setFont(font);
        send.setForeground(b);
        msg.setForeground(b);
        to.setForeground(b);
        for(int i=0;i<6;i++)
        {
            if(names[i]!=null && lastnames[i]!=null)
            {
                cb.addItem(names[i]+" "+lastnames[i]);
            }
        }
         contenu.add(finish);
         contenu.add(message);
         contenu.add(msg);
         contenu.add(cb);
         contenu.add(send);
         contenu.add(to);
         msg.setBounds(50,10,450,50);
         send.setBounds(150,150,50,50);
         message.setBounds(220,150,200,50);
         to.setBounds(450,150,50,50);
         cb.setBounds(510,150,150,50);
         finish.setBounds(700,750,150,50);
         finish.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int i=cb.getSelectedIndex();
                String messg=message.getText();
                setMessage(name,lastname,messg,names[i],lastnames[i]);
                contenu.removeAll();
                Manager c= new Manager(contenu,name,lastname,job);
                c.setoffood();
                contenu=c.getcontenu();
                contenu.repaint();
            }
        }
         );
     }
}
