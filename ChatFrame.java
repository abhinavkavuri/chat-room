import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
class ChatFrame extends JFrame
{
JButton jb1;
JTextField jtf;
JTextArea  jta;
Socket s;
ObjectOutputStream os;
ChatFrame(Socket s)
{
super("Chat Frame");
this.s=s;
jtf=new JTextField();
jb1=new JButton("Send");
jta=new JTextArea();
try
{
os=new ObjectOutputStream(s.getOutputStream());
}
catch(Exception e)
{
}
jb1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
JOptionPane.showMessageDialog(null,"Hello");
String text=jtf.getText().toString();

jta.setText(jta.getText()+"\n(me):"+text);

try
{
os.writeObject(text);
}
catch(Exception e)
{
}

}
});
setLayout(null);

jta.setBounds(0,0,400,300);
jtf.setBounds(0,320,300,25);

jb1.setBounds(320,320,80,25);
add(jb1);
add(jtf);
add(jta);
//add(jb2,BorderLayout.SOUTH);
//setSize(400,400);
Thread t=new ServerThread();
t.start();
setBounds(300,200,500,400);
setVisible(true);
}
class ServerThread extends Thread
{
public void run()
{
try
{

ObjectInputStream is=new ObjectInputStream(s.getInputStream());
for(;;)
{

String rtext=(String)is.readObject();

jta.setText(jta.getText()+"\n(User):"+rtext);
System.out.println(rtext);
}

}
catch(Exception e)
{
e.printStackTrace();
}
}
}

public static void main(String ar[])
{
//new ChatFrame();
}

}