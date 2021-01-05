import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class EditEmp
{
EditEmp(String eId)
{
JFrame f= new JFrame("Edit");
f.setVisible(true);
f.setSize(800,800);
f.setLayout(new FlowLayout());
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
	ResultSet rs= stmt.executeQuery("Select * from Employee where eId='"+eId+"'");
        while(rs.next()){
	String eName= rs.getString("eName");
	String eMobile= rs.getString("eMobile");
	String eAddress= rs.getString("eAddress");
	String eSalary= rs.getString("eSalary");
	String ePosition= rs.getString("ePosition");	
	String eJoining= rs.getString("eDOJ");
	JLabel title= new JLabel("Employee Details:");
	f.add(title);

	JLabel eid= new JLabel("Employee Id:");
	f.add(eid);
	JLabel eidVal= new JLabel(eId);
	f.add(eidVal);

        JLabel ename= new JLabel("Name:");
	f.add(ename);
	JLabel enameVal= new JLabel(eName);
	f.add(enameVal);
	JTextField enameChange= new JTextField(40);
	f.add(enameChange);

        JLabel emob= new JLabel("Mobile Number:");
	f.add(emob);
	JLabel emobVal= new JLabel(eMobile);
	f.add(emobVal);
	JTextField emobChange= new JTextField(10);
	f.add(emobChange);

        JLabel eadd= new JLabel("Address:");
	f.add(eadd);
	JLabel eaddVal= new JLabel(eAddress);
	f.add(eaddVal);
	JTextField eaddChange= new JTextField(100);
	f.add(eaddChange);

	JLabel esal= new JLabel("Salary:");
	f.add(esal);
        JLabel esalVal= new JLabel(eSalary);
	f.add(esalVal);
	JTextField esalChange= new JTextField(6);
	f.add(esalChange);

        JLabel epos= new JLabel("Position");
	f.add(epos);
	JLabel eposVal= new JLabel(ePosition);
	f.add(eposVal);
	JTextField eposChange= new JTextField(4);
	f.add(eposChange);

        JLabel ejoin= new JLabel("Joining Date");
	f.add(ejoin);
	JLabel ejoinVal= new JLabel(eJoining);
	f.add(ejoinVal);
	JTextField ejoinChange= new JTextField(18);
	f.add(ejoinChange);
        
        JButton save= new JButton("Save");
        f.add(save);
        save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
	{
	if(eName.equals(enameChange.getText()) | enameChange.getText().isEmpty())
        {
        } else {
            try {
                int rs= stmt.executeUpdate("Update Employee set eName = '"+enameChange.getText()+"' where eId="+Integer.parseInt(eId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	if(eMobile.equals(emobChange.getText()) | emobChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update Employee set eMobile = "+emobChange.getText()+" where eId="+Integer.parseInt(eId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	if(eAddress.equals(eaddChange.getText()) | eaddChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update Employee set eAddress = "+eaddChange.getText()+" where eId="+Integer.parseInt(eId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	if(eSalary.equals(esalChange.getText()) | esalChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update Employee set eSalary = "+esalChange.getText()+" where eId="+Integer.parseInt(eId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	if(ePosition.equals(eposChange.getText()) | eposChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update Employee set ePosition = "+eposChange.getText()+" where eId="+Integer.parseInt(eId));
            } catch (SQLException ex) {
                Logger.getLogger(EditEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	DetailsE d= new DetailsE(eId);
	}	
});
}
}   catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
    }

}
}