import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
class MyFrame extends JFrame
{
JButton jb1;
JTextField jtf;
MyFrame()
{
super("My");
jtf=new JTextField();
jb1=new JButton("Connect");
jb1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
JOptionPane.showMessageDialog(null,"Hello");
String ip=jtf.getText().toString();
try
{
Socket s=new Socket(ip,3000);
new ChatFrame(s);
}
catch(Exception e)
{
}

}
});
setLayout(null);
jtf.setBounds(45,50,200,25);
jb1.setBounds(255,50,100,25);
add(jb1);
add(jtf);
//add(jb2,BorderLayout.SOUTH);
//setSize(400,400);
setBounds(300,200,400,300);
setVisible(true);
}

public static void main(String ar[])
{
new MyFrame();
}
}