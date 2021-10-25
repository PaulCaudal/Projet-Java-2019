package mcdonalds;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static mcdonalds.DBAction.creatuser;
import static mcdonalds.DBAction.getnbofcashier;
/**
 *
 * @author paulc
 */
public class PanelReg extends JPanel
{
    private Container contenu;
     public PanelReg(Container c)
   {
       contenu=c;
       contenu.setLayout(null);
   }
    public Container getcontenu()
    {
         return contenu;
    }
    public void Paintreg(final String nam,final String lastnam,final String jobe)
    {
        Color a=new Color(31,83,47);
         Color b=new Color(255,223,35);
         JLabel log=new JLabel("Login:");
         JLabel pass=new JLabel("Password:");
         JLabel name=new JLabel("Name:");
         JLabel lastname=new JLabel("Last name:");
         JLabel id=new JLabel("ID:");
         JLabel job=new JLabel("Job:");
        JButton subb=new JButton("Submit");
        final JComboBox<String> textjob=new JComboBox<>();
        final JPasswordField textpass=new JPasswordField();
        final JTextField textlog=new JTextField();
        final JTextField textname=new JTextField();
        final JTextField textlastname=new JTextField();
        final JTextField textid=new JTextField();
        //final JTextField textjob=new JTextField();
        Font font1=new Font(Font.SERIF,Font.BOLD,25);
        textlog.setFont(font1);
        textpass.setFont(font1);
        textname.setFont(font1);
        textlastname.setFont(font1);
        textid.setFont(font1);
        textjob.setFont(font1);
        log.setForeground(b);
        pass.setForeground(b);
        name.setForeground(b);
        lastname.setForeground(b);
        id.setForeground(b);
        job.setForeground(b);
        textpass.setEchoChar('*');
        Font font=new Font(Font.SERIF,Font.BOLD,45);
        log.setFont(font);
        pass.setFont(font);
        name.setFont(font);
        lastname.setFont(font);
        id.setFont(font);
        textjob.addItem("cashier");
        textjob.addItem("manager");
        job.setFont(font);
        contenu.add(log);
        contenu.add(pass);
        contenu.add(name);
        contenu.add(lastname);
        contenu.add(id);
        contenu.add(job);
        contenu.add(subb);
        contenu.add(textlog);
        contenu.add(textpass);
        contenu.add(textname);
        contenu.add(textlastname);
        contenu.add(textid);
        contenu.add(textjob);
        textlog.setBounds(300, 10, 300, 50);
        textpass.setBounds(300, 80, 300, 50);
        textid.setBounds(300, 150, 300, 50);
        textname.setBounds(300, 220, 300, 50);
        textlastname.setBounds(300, 290, 300, 50);
        textjob.setBounds(300, 360, 300, 50);
        subb.setBounds(300, 450, 150, 40);
        log.setBounds(10, 10, 250, 60);
        pass.setBounds(10, 80, 250, 60);
        id.setBounds(10, 150, 250, 60);
        name.setBounds(10, 220, 250, 60);
        lastname.setBounds(10, 290, 250, 60);
        job.setBounds(10, 360, 250, 60);
        contenu.setBackground(a);
        subb.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int i=getnbofcashier();
                
                if(i<6)
                {String login=textlog.getText();
                String password=textpass.getText();
                String idt=textid.getText();
                String name=textname.getText();
                String lastname=textlastname.getText();
                String job;
                int j=textjob.getSelectedIndex();
                if(j==1)
                {
                    job="manager";
                }
                else
                {
                    job="cashier";
                }
                int id=Integer.parseInt(idt);
                creatuser(login,password,id,name,lastname,job);
               
                   contenu.removeAll();
                   Manager c= new Manager(contenu,nam,lastnam,jobe);
                c.setoffood();
                contenu=c.getcontenu();
                   contenu.repaint();
               
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "you can't have more than six cashier");
            }}
        }
        );
    }
}
