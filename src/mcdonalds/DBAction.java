
package mcdonalds;
import java.sql.*;
import static mcdonalds.Connexion.connecterDB;
import javax.swing.JOptionPane;
public class DBAction 
{
    private static Connection cnx;
    private static Statement st;
    private static ResultSet rst;
    public static int Researchlog(String login,String password)
    {
         int i=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `log` WHERE `login`='"+login+"' AND `password`='"+password+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int n=rst.getRow();
            if(n!=0)
            {
                
                i=1;
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Error with the information");
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return i;
    }
     public static String ResearchinfoString(String login,String password,String info)
    {
         int i=0;
         String result=null;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT `id` FROM `log` WHERE `login`='"+login+"' AND `password`='"+password+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int n=rst.getInt("id");
            //System.out.println("\n"+n);
            query="SELECT `"+info+"` FROM `user` WHERE `id`="+n;
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            result=rst.getString(info);
            //System.out.println(result);
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return result;
    }
    public static void creatuser(String login,String password,int id,String name,String lastname, String job)
    {
        try
        {    
        
            cnx=connecterDB();
            String query="INSERT INTO `log` VALUES('"+login+"','"+password+"',"+id+")";
            String query2="INSERT INTO `user` VALUES("+id+",'"+lastname+"','"+name+"','"+job+"',1200,true)";
            String query3="INSERT INTO `schedule` VALUES('"+name+"','"+lastname+"',true,true,true,true,true,true)";
            st=cnx.createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
            st.executeUpdate(query3);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static void setMessage(String name,String lastname,String message,String namec,String lastnamec)
    {
        try
        {    
        
            cnx=connecterDB();
            String namm=name+" "+lastname;
            String namc=namec+" "+lastnamec;
            String query="INSERT INTO `message` VALUES('"+namm+"','"+namc+"','"+message+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static String getMessage(String name,String lastname)
    {
       
        
        String msg=null;
        try
        {    
        
            cnx=connecterDB();
            String namc=name+" "+lastname;
            String query="SELECT `message` FROM `message` WHERE `receive`='"+namc+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            boolean c=rst.last();
            if(c==true)
            {
                msg=rst.getString("Message");
                query="DELETE FROM `message` WHERE `Message`='"+msg+"'";
                st=cnx.createStatement();
                st.executeUpdate(query);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return msg;
    }
    public static String[] getinfo(String info)
    {
        String[]name=new String[6];
        boolean b;
        int i=0;
        try
        {    
        
            cnx=connecterDB();
            String query="SELECT `"+info+"` FROM `user` WHERE `job`='cashier'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
           
            boolean c=rst.first();
            if(c==true)
            {
                do
                {
                    name[i]=rst.getString(info);
                    b=rst.next();
                    i=i+1;
                }
                while(b==true);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return name;
    }
     public static int getnbofcashier()
    {
       
        int i=0;
        try
        {    
        
            cnx=connecterDB();
            String query="SELECT * FROM `user` WHERE `job`='cashier'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            i=rst.getRow();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return i;
    }
    public static void setdayofwork(String name,String lastname,int r0,int r1,int r2,int r3,int r4,int r5)
    {
        
        boolean b;
        
        try
        {    
            
            cnx=connecterDB();
            String query="UPDATE `schedule` SET `day+1`="+r0+",`day+2`="+r1+",`day+3`="+r2+",`day+4`="+r3+",`day+5`="+r4+",`day+6`="+r5+" WHERE `name`='"+name+"'AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("fghjkl");
           
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        
    }
        public static String getdayofwork(String name,String lastname,String info)
    {
        String work=null;
        
        try
        {    
        
            cnx=connecterDB();
            String query="SELECT `"+info+"` FROM `schedule` WHERE `name`='"+name+"' AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
           int i=rst.getInt(info);
           
           if(i==1)
           {work="yes";}
           else
           {work="no";}
           
           
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage()+"    "+work);
            
        }
        return work;
    }
        public static int gettdaywork(String name,String lastname)
    {
        int i=0;
        
        try
        {    
        
            cnx=connecterDB();
            String query="SELECT `today` FROM `user` WHERE `name`='"+name+"' AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            i=rst.getInt("today");
           
           
           
           
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return i;
    }
         public static void settdaywork()
    {
        int i=0;
        
        try
        {    
            boolean b;
            int r0,r1,r2,r3,r4,r5;
            String name,lastname;
            cnx=connecterDB();
            String query="SELECT * FROM `user` WHERE `job`='cashier'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            ResultSet rst2;
            rst.first();
            i=rst.getInt("today");
            do
            {
                name=rst.getString("name");
                lastname=rst.getString("lastname");
                query="SELECT * FROM `schedule` WHERE `name`='"+name+"' AND `lastname`='"+lastname+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                rst2.last();
                r0=rst2.getInt("day+1");
                r1=rst2.getInt("day+2");
                r2=rst2.getInt("day+3");
                r3=rst2.getInt("day+4");
                r4=rst2.getInt("day+5");
                r5=rst2.getInt("day+6");
                query="UPDATE `user` SET `today`="+r0+" WHERE `name`='"+name+"'AND `lastname`='"+lastname+"'";
                st=cnx.createStatement();
                st.executeUpdate(query);
                query="UPDATE `schedule` SET `day+1`="+r1+",`day+2`="+r2+",`day+3`="+r3+",`day+4`="+r4+",`day+5`="+r5+",`day+6`=1 WHERE `name`='"+name+"' AND `lastname`='"+lastname+"'";
                st=cnx.createStatement();
                st.executeUpdate(query);
                b=rst.next();
            }
            while(b==true);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        
    }
         public static int getdayofchange(int day)
    {
        int i=0;
        
        try
        {    
        
            cnx=connecterDB();
            String query="SELECT * FROM `dayofchange`";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            i=rst.getInt("day");
            query="UPDATE `dayofchange` SET `day`="+day;
            st=cnx.createStatement();
            st.executeUpdate(query);
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return i;
    }
          public static void setaccount(float p)
    {
        float i=0;
        
        try
        {    
            
            cnx=connecterDB();
            String query="SELECT `price` FROM `account`";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            i=rst.getFloat("price");
            i=i+p;
            query="UPDATE `account` SET `price`="+i;
            st=cnx.createStatement();
            st.executeUpdate(query);
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        
    }
          public static float getaccount()
    {
        float i=0;
        
        try
        {    
            cnx=connecterDB();
            String query="SELECT `price` FROM `account`";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            i=rst.getFloat("price");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return i;
        
    }
    public static int getsalary(String name,String lastname)
    {
        int i=0;
        
        try
        {    
            cnx=connecterDB();
            String query="SELECT `salary` FROM `user` WHERE `name`='"+name+"'AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            i=rst.getInt("salary");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return i;
        
    }
    public static void setsalary(String name,String lastname,float newsal)
    {
        
        try
        {    
            cnx=connecterDB();
            String query="UPDATE `user` SET `salary`="+newsal+"WHERE `name`='"+name+"'AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
    }
    public static void firecashier(String name,String lastname)
    {
        
        try
        {    
            cnx=connecterDB();
            String query="DELETE FROM `schedule` WHERE `name`='"+name+"' AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
            query="SELECT `id` FROM `user` WHERE `name`='"+name+"'AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int id=rst.getInt("id");
            query="DELETE FROM `log` WHERE `id`="+id;
            st=cnx.createStatement();
            st.executeUpdate(query);
            query="DELETE FROM `user` WHERE `name`='"+name+"' AND `lastname`='"+lastname+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
    }
}
