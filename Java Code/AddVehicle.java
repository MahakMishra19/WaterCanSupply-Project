import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class AddVehicle
{
AddVehicle()
{
    JFrame f= new JFrame("Add Vehicle");
    f.setVisible(true);
    f.setSize(800,800);
    f.setLayout(new FlowLayout());
    JLabel enterid= new JLabel("Vehicle Id:");
    f.add(enterid);
    JTextField vId= new JTextField(10);
    f.add(vId);
    JLabel entername= new JLabel("Driver's Name:");
    f.add(entername);
    JTextField driver= new JTextField(40);
    f.add(driver);
    JButton save= new JButton("Save");
    f.add(save);
    save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
    {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
        int rs= stmt.executeUpdate("insert into Vehicle values('"+vId.getText()+"','"+driver.getText()+"')");
        if(rs==1)
        {
            JOptionPane.showMessageDialog(null,"New Customer Added.");
            f.dispose();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"ooops!! Something went WRONG.");
        }
        } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AddRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }});
}}
