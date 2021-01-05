import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class EditVehicleDet
{
EditVehicleDet()
{
JFrame f= new JFrame("Edit Vehicle Details");
f.setVisible(true);
f.setSize(800,800);
f.setLayout(new FlowLayout());
JLabel idLabel= new JLabel("Enter Vehicle Id: ");
f.add(idLabel);
JTextField idTextField= new JTextField(8);
f.add(idTextField);
JButton edit= new JButton("Edit");
f.add(edit);
edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
	int count=0;
        
	ResultSet rs= stmt.executeQuery("Select * from RegularCustomers where cId='"+idTextField.getText()+"'");
	while(rs.next())
	{
        String cId= rs.getString("cId");
        count=1;
	Details d= new Details(cId);
	}
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No such Customer Exists.");
        }
	} catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
EditVehicle e= new EditVehicle(idTextField.getText());
}});
}
EditVehicleDet(String vId)
{
EditVehicle e= new EditVehicle(vId);
}
}