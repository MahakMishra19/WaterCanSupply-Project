import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class ViewVehicleDet
{
ViewVehicleDet()
{
JFrame f= new JFrame("Vehicle Details");
f.setVisible(true);
f.setLayout(new FlowLayout());
f.setSize(400,800);
JLabel idLabel= new JLabel("Enter Vehicle Id: ");
f.add(idLabel);
JTextField idTextField= new JTextField(8);
f.add(idTextField);
JButton view= new JButton("View Vehicle Details");
f.add(view);
view.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
	int count=0;
        
	ResultSet rs= stmt.executeQuery("Select * from Vehicle where vId='"+idTextField.getText()+"'");
	while(rs.next())
	{
        String vId= rs.getString("vId");
        count=1;
	DetailsV d= new DetailsV(vId);
	}
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No such Customer Exists.");
        }
	} catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
}});
JButton viewAll= new JButton("View All Vehicle Details");
f.add(viewAll);
viewAll.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
    JFrame f1=new JFrame("Vehicles");
    f1.setVisible(true);
    f1.setLayout(new FlowLayout());
    f1.setSize(800,800);
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
	int count=0;
        DefaultTableModel model=new DefaultTableModel();
        JTable table =new JTable(model); 
        f1.add(table);
        JScrollPane sp= new JScrollPane(table);
        f1.add(sp);
        model.addColumn("Vehicle Id");
        model.addColumn("Driver");
        //model.addRow(new Object[]{"Customer Id","Name","Mobile","Address","Payment Status","Billing Amount","Requirement","Cancelled","Vehicle"});
	ResultSet rs= stmt.executeQuery("Select * from Vehicle");
	while(rs.next()){
        String vId= rs.getString("vId");
	String driver= rs.getString("Driver");
        model.addRow(new Object[]{vId,driver});
        count=1;
        }
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No Vehicle Exists.");
        }
        }   catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);}
}});
}
}