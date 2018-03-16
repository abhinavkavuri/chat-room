import java.net.*;
import java.io.*;
import java.util.*;
class Server
{
public static void main(String ar[]) throws
 Exception
{
ServerSocket ss=new ServerSocket(3000);
while(true)
{
System.out.println("waiting...");
Socket s=ss.accept();
System.out.println("Connected...");
new ChatFrame(s);
//Thread t=new ServerThread(s);
//t.start();
}
}
}
class ServerThread extends Thread
{
Socket s;
ServerThread(Socket s)
{
this.s=s;
}
public void run()
{
try
{
Scanner sc=new Scanner(System.in);

ObjectInputStream is=new ObjectInputStream(s.getInputStream());
ObjectOutputStream os=new ObjectOutputStream(s.getOutputStream());
for(int i=0;i<4;i++)
{
System.out.println(s+"->"+is.readObject());
os.writeObject(sc.nextLine());
}

}
catch(Exception e)
{
}
}
}

