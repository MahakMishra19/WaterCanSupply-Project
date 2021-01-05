import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class AddEmployee
{
AddEmployee()
{
    JFrame f= new JFrame("Add Employee");
    f.setVisible(true);
    f.setSize(800,800);
    f.setLayout(new FlowLayout());
    JLabel entername= new JLabel("Employee's Name:");
    f.add(entername);
    JTextField name= new JTextField(40);
    f.add(name);
    JLabel entermob= new JLabel("Mobile number:");
    f.add(entermob);
    JTextField mob= new JTextField(10);
    f.add(mob);
    JLabel enteradd= new JLabel("Address:");
    f.add(enteradd);
    JTextField address= new JTextField(100);
    f.add(address);
    JLabel entersal= new JLabel("Salary");
    f.add(entersal);
    JTextField esal= new JTextField(6);
    f.add(esal);
    JLabel enterpos= new JLabel("Position :");
    f.add(enterpos);
    JTextField epos= new JTextField(10);
    f.add(epos);
    JLabel enterdoj= new JLabel("Date of Joining :");
    f.add(enterdoj);
    JTextField edoj= new JTextField(18);
    f.add(edoj);
    JButton save= new JButton("Save");
    f.add(save);
    save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
    {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
        int rs= stmt.executeUpdate("insert into Employee set eName='"+name.getText()+"',eMobile='"+mob.getText()+"', eAddress='"+address.getText()+"', eSalary='"+esal.getText()+"', ePosition='"+epos.getText()+"', eDOJ='"+edoj.getText()+"';");
        if(rs==1)
        {
            JOptionPane.showMessageDialog(null,"New Employee Added.");
            f.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"ooops!! Something went WRONG.");
        }
        } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AddRegCustomerDet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }});
}}
