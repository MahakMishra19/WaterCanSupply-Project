import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Employee
{
Employee()
{
JFrame f= new JFrame("Employee");
f.setVisible(true);
f.setSize(400,800);
f.setLayout(new FlowLayout());
JButton view= new JButton("View Employee Details");
f.add(view);
JButton add= new JButton("Add New Employee");
f.add(add);
JButton edit= new JButton("Edit Employee Details");
f.add(edit);
JButton delete= new JButton("Delete Employee Details");
f.add(delete);
view.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
ViewEmployeeDet v = new ViewEmployeeDet();
}});
add.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
AddEmployee a = new AddEmployee();
}});
edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
EditEmployee e = new EditEmployee();
}});
delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
DeleteEmployee d = new DeleteEmployee();
}});
}
}