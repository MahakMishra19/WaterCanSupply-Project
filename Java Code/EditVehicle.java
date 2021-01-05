import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class EditVehicle
{
EditVehicle(String vId)
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
	ResultSet rs= stmt.executeQuery("Select * from Vehicle where vId='"+vId+"'");
        while(rs.next()){
	String driver= rs.getString("driver");
	JLabel title= new JLabel("Vehicle Details:");
	f.add(title);

	JLabel vid= new JLabel("Vehicle Id:");
	f.add(vid);
	JLabel vidVal= new JLabel(vId);
	f.add(vidVal);

        JLabel dri= new JLabel("Driver:");
	f.add(dri);
	JLabel driVal= new JLabel(driver);
	f.add(driVal);
	JTextField driChange= new JTextField(40);
	f.add(driChange);


        JButton save= new JButton("Save");
        f.add(save);
        save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
	{
	if(driver.equals(driChange.getText()))
	{
	} else {
            try {
                int rs= stmt.executeUpdate("Update Vehicle set Driver = '"+driChange.getText()+"' where vId='"+vId+"'");
            } catch (SQLException ex) {
                Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	DetailsV d= new DetailsV(vId);
	}	
});
}
}   catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(EditRegCus.class.getName()).log(Level.SEVERE, null, ex);
    }

}
}