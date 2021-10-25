
package mcdonalds;

import java.awt.Container;
import static mcdonalds.DBAction.ResearchinfoString;


public abstract class User 
{
    protected final String name;
    protected final String lastname;
    protected final String job;
    protected Container contenu;
    //first contructer with the login and the password
    public User(String login, String password,String j,Container c)
    {
        contenu=c;
        contenu.setLayout(null);
        job=j;
        name=ResearchinfoString(login,password,"name");
        lastname=ResearchinfoString(login,password,"lastname");
    }
    //second constructeur with the name 
    public User(Container c, String nam,String lastnam,String j)
    {
        contenu=c;
        job=j;
        name=nam;
        lastname=lastnam;
    }
    public abstract void setoffood();//display the user screen
}
