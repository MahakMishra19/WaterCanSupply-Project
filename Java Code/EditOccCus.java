import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class EditOccCus
{
EditOccCus(String cId)
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
	ResultSet rs= stmt.executeQuery("Select * from OccasionalCustomers where cId='"+cId+"'");
        while(rs.next()){
	String cName= rs.getString("cName");
	String cMobile= rs.getString("cMobile");
	String cAddress= rs.getString("cAddress");
	String cBAmount= rs.getString("cBAmount");	
	String cRq= rs.getString("cRq");
	String cDOD= rs.getString("cDOD");
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
	JTextField cnameChange= new JTextField(40);
	f.add(cnameChange);

        JLabel cmob= new JLabel("Mobile Number:");
	f.add(cmob);
	JLabel cmobVal= new JLabel(cMobile);
	f.add(cmobVal);
	JTextField cmobChange= new JTextField(10);
	f.add(cmobChange);

        JLabel cadd= new JLabel("Address:");
	f.add(cadd);
	JLabel caddVal= new JLabel(cAddress);
	f.add(caddVal);
	JTextField caddChange= new JTextField(100);
	f.add(caddChange);

        JLabel creq= new JLabel("No. of Cans Required:");
	f.add(creq);
	JLabel creqVal= new JLabel(cRq);
	f.add(creqVal);
	JTextField creqChange= new JTextField(2);
	f.add(creqChange);

        JLabel cdod= new JLabel("Date of Delivery:");
	f.add(cdod);
	JLabel cdodVal= new JLabel(cDOD);
	f.add(cdodVal);
	JTextField cdodChange= new JTextField(18);
	f.add(cdodChange);

        JLabel vid= new JLabel("Vehicle Assigned:");
	f.add(vid);
	JLabel vidVal= new JLabel(vId);
	f.add(vidVal);
	JTextField vidChange= new JTextField(10);
	f.add(vidChange);

        JButton save= new JButton("Save");
        f.add(save);
        save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
	{
	if(cName.equals(cnameChange.getText()) | cnameChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update OccasionalCustomers set cName = '"+cnameChange.getText()+"' where cId="+Integer.parseInt(cId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	if(cMobile.equals(cmobChange.getText()) | cmobChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update OccasionalCustomers set cMobile = '"+cmobChange.getText()+"' where cId="+Integer.parseInt(cId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	if(cAddress.equals(caddChange.getText()) | caddChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update OccasionalCustomers set cAddress = '"+caddChange.getText()+"' where cId="+Integer.parseInt(cId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	if(cRq.equals(creqChange.getText()) | creqChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update OccasionalCustomers set cRq = '"+creqChange.getText()+"' where cId="+Integer.parseInt(cId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        if(cDOD.equals(cdodChange.getText()) | cdodChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update OccasionalCustomers set cDOD = '"+cdodChange.getText()+"' where cId="+Integer.parseInt(cId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	if(vId.equals(vidChange.getText()) | vidChange.getText().isEmpty())
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update OccasionalCustomers set vId = '"+vidChange.getText()+"' where cId="+Integer.parseInt(cId));
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	DetailsO d= new DetailsO(cId);
        f.dispose();
	}	
});
}
}   catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
    }

}
}