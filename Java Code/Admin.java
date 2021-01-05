import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Admin
{
Admin()
{
JFrame f= new JFrame("Admin");
f.setVisible(true);
f.setSize(800,400);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(new FlowLayout());
JLabel loginPage= new JLabel("This is a LogIn Page:");
f.add(loginPage);
JLabel enterPassword= new JLabel("Enter Password:");
f.add(enterPassword);
JTextField password= new JTextField(9);
f.add(password);
password.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae)
{
String val=password.getText();
System.out.println(val);
String correctPassword="Mahak@123";
if(val.equals(correctPassword))
{
new HomePage();
System.out.println("Successful Login");
f.dispose();
}
else
{
new WrongPassword();
System.out.println("UnSuccessful Login");
}
}});
}
}
