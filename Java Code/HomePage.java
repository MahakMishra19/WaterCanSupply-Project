import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class HomePage
{
HomePage()
{
JFrame f= new JFrame("Home Page");
f.setVisible(true);
f.setSize(800,400);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(new FlowLayout());
JLabel title= new JLabel("Mahak Water Can Supply");
f.add(title);
JButton regularCustomers= new JButton("Regular Customers");
JButton occasionalCustomers= new JButton("Occasional Customers");
JButton employeeDetails= new JButton("Employee Details");
JButton vehicleDetails= new JButton("Vehicle Details");
f.add(regularCustomers);
f.add(occasionalCustomers);
f.add(employeeDetails);
f.add(vehicleDetails);
regularCustomers.addActionListener(new ActionListener() {@Override
public void actionPerformed(ActionEvent ae)
{
RegularCustomers rc= new RegularCustomers();
}});
occasionalCustomers.addActionListener(new ActionListener() {@Override
public void actionPerformed(ActionEvent ae)
{
OccasionalCustomers oc= new OccasionalCustomers();
}});
employeeDetails.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae)
{
Employee ro= new Employee();
}});
vehicleDetails.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae)
{
Vehicle ro= new Vehicle();
}});
}
}