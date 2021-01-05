import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Vehicle
{
Vehicle()
{
JFrame f= new JFrame("Vehicle");
f.setVisible(true);
f.setSize(400,800);
f.setLayout(new FlowLayout());
JButton view= new JButton("View Vehicle's Details");
f.add(view);
JButton add= new JButton("Add New Vehicle");
f.add(add);
JButton edit= new JButton("Edit Vehicle Details");
f.add(edit);
JButton delete= new JButton("Delete Vehicle");
f.add(delete);
view.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
ViewVehicleDet v = new ViewVehicleDet();
}});
add.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
AddVehicle a = new AddVehicle();
}});
edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
EditVehicleDet e = new EditVehicleDet();
}});
delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
DeleteVehicle d = new DeleteVehicle();
}});
}
}