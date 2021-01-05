import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class DeleteEmployee
{
DeleteEmployee()
{
JFrame f= new JFrame("Delete Employee Details");
f.setVisible(true);
f.setLayout(new FlowLayout());
f.setSize(400,800);
JLabel idLabel= new JLabel("Enter Employee Id: ");
f.add(idLabel);
JTextField idTextField= new JTextField(8);
f.add(idTextField);
JButton delete= new JButton("Delete");
f.add(delete);
delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
try
    {
        Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
        int rs= stmt.executeUpdate("delete from Employee where eId = '"+idTextField.getText()+"'");
        if(rs==1)
        {
            JOptionPane.showMessageDialog(null,"Employee Record Deleted.");
            f.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Wrong Customer Id.");
        }
        } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AddRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
}});
}
DeleteEmployee(String eId)
{
try
    {
        Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
        int rs= stmt.executeUpdate("delete from Employee where eId = '"+eId+"'");
        if(rs==1)
        {
            JOptionPane.showMessageDialog(null,"Employee Record Deleted.");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Wrong Customer Id.");
        }
        } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AddRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}