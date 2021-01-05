import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class EditEmployee
{
EditEmployee()
{
JFrame f= new JFrame("Edit Employee Details");
f.setVisible(true);
f.setSize(800,800);
f.setLayout(new FlowLayout());
JLabel idLabel= new JLabel("Enter Employee Id: ");
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
        
	ResultSet rs= stmt.executeQuery("Select * from Employee where eId='"+idTextField.getText()+"'");
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
EditEmp e= new EditEmp(idTextField.getText());
}});
}
EditEmployee(String eId)
{
EditEmp e= new EditEmp(eId);
}
}