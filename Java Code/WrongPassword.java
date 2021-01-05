import javax.swing.*;
import java.awt.*;
import java.awt.event.*;                                                            
class WrongPassword
{
WrongPassword()
{
JFrame f= new JFrame("Wrong Password...");
f.setVisible(true);
f.setSize(400,400);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(new FlowLayout());
JLabel l= new JLabel("You have entered a WRONG PASSWORD... Please EXIT");
f.add(l);
JButton b= new JButton("EXIT");
f.add(b);
b.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae){System.out.println("Successful Exit"); System.exit(0);}});
}
}
 