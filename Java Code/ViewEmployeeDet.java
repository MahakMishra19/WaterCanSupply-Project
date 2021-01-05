import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class ViewEmployeeDet
{
ViewEmployeeDet()
{
JFrame f= new JFrame("Employee Details");
f.setVisible(true);
f.setLayout(new FlowLayout());
f.setSize(400,800);
JLabel idLabel= new JLabel("Enter Employee Id: ");
f.add(idLabel);
JTextField idTextField= new JTextField(8);
f.add(idTextField);
JButton view= new JButton("View Employee Details");
f.add(view);
view.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
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
        String eId= rs.getString("eId");
        count=1;
	DetailsE d= new DetailsE(eId);
	}
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No such Employee Exists.");
        }
	} catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
}});
JButton viewAll= new JButton("View All Employee's Details");
f.add(viewAll);
viewAll.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
{
    JFrame f1=new JFrame("Employee");
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
        model.addColumn("Employee Id");
        model.addColumn("Name");
        model.addColumn("Mobile");
        model.addColumn("Address");
        model.addColumn("Salary");
        model.addColumn("Position");
        model.addColumn("Date of Joining");
        //model.addRow(new Object[]{"Customer Id","Name","Mobile","Address","Payment Status","Billing Amount","Requirement","Cancelled","Vehicle"});
	ResultSet rs= stmt.executeQuery("Select * from Employee");
	while(rs.next()){
        String eId= rs.getString("eId");
	String eName= rs.getString("eName");
	String eMobile= rs.getString("eMobile");
	String eAddress= rs.getString("eAddress");
	String eSalary= rs.getString("eSalary");
	String ePosition= rs.getString("ePosition");	
	String eJoining= rs.getString("eDOJ");
        model.addRow(new Object[]{eId,eName,eMobile,eAddress,eSalary,ePosition,eJoining});
        count=1;
        }
	if(count==0)
        {
        JOptionPane.showMessageDialog(null,"No Employee Exists.");
        }
        }   catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ViewRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);}
}});
}
}