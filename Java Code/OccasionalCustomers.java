import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class OccasionalCustomers
{
OccasionalCustomers()
{
JFrame f= new JFrame("Occasional Customers");
f.setVisible(true);
f.setLayout(new FlowLayout());
f.setSize(400,800);
JButton view= new JButton("View Customer Details");
f.add(view);
JButton add= new JButton("Add New Customer");
f.add(add);
JButton edit= new JButton("Edit Customer Details");
f.add(edit);
JButton delete= new JButton("Delete Customer Details");
f.add(delete);
view.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
ViewOccCustomerDet v = new ViewOccCustomerDet();
}});
add.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
AddOccCustomerDet a = new AddOccCustomerDet();
}});
edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
EditOccCustomerDet e = new EditOccCustomerDet();
}});
delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
DeleteOccCustomerDet d = new DeleteOccCustomerDet();
}});
}
}