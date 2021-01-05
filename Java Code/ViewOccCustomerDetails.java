import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class ViewOccCustomerDet
{
ViewOccCustomerDet()
{
JFrame f= new JFrame("Customer Details");
f.setVisible(true);
f.setLayout(new FlowLayout());
f.setSize(400,800);
JLabel idLabel= new JLabel("Enter Customer Id: ");
f.add(idLabel);
JTextField idTextField= new JTextField(8);
f.add(idTextField);
JButton view= new JButton("View Customer Details");
f.add(view);
view.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
	int count=0;
        
	ResultSet rs= stmt.executeQuery("Select * from OccasionalCustomers where cId='"+idTextField.getText()+"'");
	while(rs.next())
	{
        String cId= rs.getString("cId");
        count=1;
	DetailsO d= new DetailsO(cId);
	}
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No such Customer Exists.");
        }
	} catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
}});
JButton viewAll= new JButton("View All Customer Details");
f.add(viewAll);
viewAll.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
    JFrame f1=new JFrame("Occasional Customers");
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
        model.addColumn("Customer Id");
        model.addColumn("Name");
        model.addColumn("Mobile");
        model.addColumn("Address");
        model.addColumn("Billing Amount");
        model.addColumn("Requirement");
        model.addColumn("Date of Dilevery");
        model.addColumn("Vehicle");
        //model.addRow(new Object[]{"Customer Id","Name","Mobile","Address","Payment Status","Billing Amount","Requirement","Cancelled","Vehicle"});
	ResultSet rs= stmt.executeQuery("Select * from OccasionalCustomers");
	while(rs.next()){
        String cId= rs.getString("cId");
	String cName= rs.getString("cName");
	String cMobile= rs.getString("cMobile");
	String cAddress= rs.getString("cAddress");
	String cBAmount= rs.getString("cBAmount");	
	String cRq= rs.getString("cRq");
	String cDOD= rs.getString("cDOD");
	String vId= rs.getString("vId");
        model.addRow(new Object[]{cId,cName,cMobile,cAddress,cBAmount,cRq,cDOD,vId});
        count=1;
        }
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No Customer Exists.");
        }
        }   catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);}
}});
}
}