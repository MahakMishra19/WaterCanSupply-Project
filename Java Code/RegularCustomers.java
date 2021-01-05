import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class RegularCustomers
{
RegularCustomers()
{
JFrame f= new JFrame("Regular Customers");
f.setVisible(true);
f.setSize(400,800);
f.setLayout(new FlowLayout());
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
ViewRegCustomerDet v = new ViewRegCustomerDet();
f.dispose();
}});
add.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
AddRegCustomerDet a = new AddRegCustomerDet();
}});
edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
EditRegCustomerDet e = new EditRegCustomerDet();
}});
delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
DeleteRegCustomerDet d = new DeleteRegCustomerDet();
}});
}
}