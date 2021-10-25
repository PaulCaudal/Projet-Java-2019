
package mcdonalds;
import java.sql.*;
import static mcdonalds.Connexion.connecterDB;

public class DBActionItem 
{
    private static Connection cnx;
    private static Statement st;
    private static ResultSet rst;
    public static int getinfoint(String name, String info)
    {
        int result=0;
        try
        {
            cnx=connecterDB();
            String query="SELECT `"+info+"` FROM `inventory` WHERE `name`='"+name+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             result=rst.getInt(info);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return result;
    }
    public static void settrans(String name,String lastname,String date,float price)
    {
        try
        {    
        
            cnx=connecterDB();
            String query="INSERT INTO `transaction` VALUES ('"+name+"','"+lastname+"','"+date+"',"+price+")";
            st=cnx.createStatement();
            st.executeUpdate(query);
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static void setsell(int day,int month,String name,int qt)
    {
        try
        {    
        
            cnx=connecterDB();
            String query="INSERT INTO `sell` VALUES ("+day+","+month+",'"+name+"',"+qt+")";
            st=cnx.createStatement();
            st.executeUpdate(query);
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static int getsell(int day,int month,String name)
    {
        int n=0;
        boolean b;
        try
        {    
            cnx=connecterDB();
            String query="SELECT `qt` FROM `sell` WHERE `name`='"+name+"' AND `day`="+day+" AND `month`="+month;
            st=cnx.createStatement();
            rst=st.executeQuery(query);
           
            boolean c=rst.first();
            if(c==true)
            {
                do
                {
                    n+=rst.getInt("qt");
                    b=rst.next();
                }
                while(b==true);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return n;
    }
    public static String[] getnames()
    {
        String[]name=new String[10];
        boolean b;
        int i=0;
        try
        {    
        
            cnx=connecterDB();
            String query="SELECT `name` FROM `inventory` ";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
           
            boolean c=rst.first();
            if(c==true)
            {
                do
                {
                    name[i]=rst.getString("name");
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
    public static void UpdateDB(String name,int qt)
    {
        try
        {    
        
            cnx=connecterDB();
            String query="UPDATE `inventory` SET `qt`="+qt+" WHERE `name`='"+name+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            
        }
    }
    public static float getinfofloat(String name, String info)
    {
        float result=0;
        try
        {
            cnx=connecterDB();
            String query="SELECT `"+info+"` FROM `inventory` WHERE `name`='"+name+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
           
            result=rst.getFloat(info);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return result;
    }
}
