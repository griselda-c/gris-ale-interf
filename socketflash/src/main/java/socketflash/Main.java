package socketflash;

import org.xsocket.connection.IServer;
import org.xsocket.connection.Server;


public class Main
{
    protected static IServer srv = null;
            
    public static void main(String[] args) 
    {
        try
        {
            srv = new Server(8090, new xSocketDataHandler()); 
            srv.run();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    protected static void shutdownServer()
    {
        try
        {
            srv.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }        
    }
}
