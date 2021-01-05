import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class DetailsE
{
DetailsE(String eId)
{
JFrame f= new JFrame("Details");
f.setVisible(true);
f.setLayout(new FlowLayout());
f.setSize(800,800);
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
        JLabel emob= new JLabel("Mobile Number:");
	f.add(emob);
	JLabel emobVal= new JLabel(eMobile);
	f.add(emobVal);
        JLabel eadd= new JLabel("Address:");
	f.add(eadd);
	JLabel eaddVal= new JLabel(eAddress);
	f.add(eaddVal);
	JLabel csalary= new JLabel("Salary");
	f.add(csalary);
        JLabel esalVal= new JLabel(eSalary);
	f.add(esalVal);
        JLabel epos= new JLabel("Position:");
	f.add(epos);
	JLabel eposVal= new JLabel(ePosition);
	f.add(eposVal);
        JLabel ejoin= new JLabel("Joining Date");
	f.add(ejoin);
	JLabel ejoinVal= new JLabel(eJoining);
	f.add(ejoinVal);
        JButton edit= new JButton("Edit");
        f.add(edit);
        edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
        {
            EditEmployee e= new EditEmployee(eId);
        }});
        }
        JButton delete= new JButton("Delete");
        f.add(delete);
        delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
        {
            DeleteEmployee e= new DeleteEmployee(eId);
            f.dispose();
        }});
} catch (SQLException | ClassNotFoundException ex) 
{
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
}
}
}