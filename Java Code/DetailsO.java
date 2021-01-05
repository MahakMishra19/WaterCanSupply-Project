import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class DetailsO
{
DetailsO(String cId)
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
	ResultSet rs= stmt.executeQuery("Select * from OccasionalCustomers where cId='"+cId+"'");
        while(rs.next()){
	String cName= rs.getString("cName");
	String cMobile= rs.getString("cMobile");
	String cAddress= rs.getString("cAddress");
	String cBAmount= rs.getString("cBAmount");	
	String cRq= rs.getString("cRq");
	String cCancelled= rs.getString("cDOD");
	String vId= rs.getString("vId");
	JLabel title= new JLabel("Customer Details:");
	f.add(title);
	JLabel cid= new JLabel("Customer Id:");
	f.add(cid);
	JLabel cidVal= new JLabel(cId);
	f.add(cidVal);
        JLabel cname= new JLabel("Name:");
	f.add(cname);
	JLabel cnameVal= new JLabel(cName);
	f.add(cnameVal);
        JLabel cmob= new JLabel("Mobile Number:");
	f.add(cmob);
	JLabel cmobVal= new JLabel(cMobile);
	f.add(cmobVal);
        JLabel cadd= new JLabel("Address:");
	f.add(cadd);
	JLabel caddVal= new JLabel(cAddress);
	f.add(caddVal);
        JLabel cbam= new JLabel("Bill Amount:");
	f.add(cbam);
	JLabel cbamVal= new JLabel(cBAmount);
	f.add(cbamVal);
        JLabel creq= new JLabel("No. of Cans Required:");
	f.add(creq);
	JLabel creqVal= new JLabel(cRq);
	f.add(creqVal);
        JLabel cdod= new JLabel("Date of Delivery:");
	f.add(cdod);
	JLabel cdodVal= new JLabel(cCancelled);
	f.add(cdodVal);
        JLabel vid= new JLabel("Vehicle Assigned:");
	f.add(vid);
	JLabel vidVal= new JLabel(vId);
	f.add(vidVal);
        JButton edit= new JButton("Edit");
        f.add(edit);
        edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
        {
            EditOccCus e= new EditOccCus(cId);
        }});
        }
        JButton delete= new JButton("Delete");
        f.add(delete);
        delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
        {
            DeleteOccCustomerDet d= new DeleteOccCustomerDet(cId);
            f.dispose();
        }});
} catch (SQLException | ClassNotFoundException ex) 
{
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
}
}
}