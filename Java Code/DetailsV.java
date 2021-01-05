import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class DetailsV
{
DetailsV(String vId)
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
	ResultSet rs= stmt.executeQuery("Select * from Vehicle where vId='"+vId+"'");
        while(rs.next()){
	String driver= rs.getString("Driver");
	JLabel title= new JLabel("Vehicle:");
	f.add(title);
	JLabel vid= new JLabel("Vehicle Id:");
	f.add(vid);
	JLabel vidVal= new JLabel(vId);
	f.add(vidVal);
        JLabel vdriver= new JLabel("Driver:");
	f.add(vdriver);
	JLabel vdriverVal= new JLabel(driver);
	f.add(vdriverVal);
        JButton edit= new JButton("Edit");
        f.add(edit);
        edit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
        {
            EditVehicle e= new EditVehicle(vId);
        }});
        }
        JButton delete= new JButton("Delete");
        f.add(delete);
        delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
        {
            DeleteVehicle e= new DeleteVehicle(vId);
            f.dispose();
        }});
} catch (SQLException | ClassNotFoundException ex) 
{
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
}
}
}