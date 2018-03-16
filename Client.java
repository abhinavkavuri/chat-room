import java.net.*;
import java.io.*;
import java.util.Scanner;
class Client
{
public static void main(String ar[]) throws Exception
{
Scanner sc=new Scanner(System.in);
Socket s=new Socket("localhost",3000);
ObjectOutputStream os=new ObjectOutputStream(s.getOutputStream());
ObjectInputStream is=new ObjectInputStream(s.getInputStream());
for(int i=0;i<4;i++)
{
os.writeObject(sc.nextLine());
System.out.println(is.readObject());
}
}
}