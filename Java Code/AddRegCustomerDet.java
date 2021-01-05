import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class AddRegCustomerDet
{
AddRegCustomerDet()
{
    JFrame f= new JFrame("Add Regular Customer");
    f.setVisible(true);
    f.setSize(800,800);
    f.setLayout(new FlowLayout());
    JLabel entername= new JLabel("Customer's Name:");
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
    JLabel enterrq= new JLabel("Requirement:");
    f.add(enterrq);
    JTextField req= new JTextField(2);
    f.add(req);
    JLabel entervid= new JLabel("Vehicle :");
    f.add(entervid);
    JTextField vid= new JTextField(10);
    f.add(vid);
    JButton save= new JButton("Save");
    f.add(save);
    save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
    {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WaterCanSupply","root","root");
	Statement stmt= con.createStatement();
        int rs= stmt.executeUpdate("insert into RegularCustomers set cName='"+name.getText()+"',cMobile='"+mob.getText()+"', cAddress='"+address.getText()+"', cRq='"+req.getText()+"', vId='"+vid.getText()+"';");
        if(rs==1)
        {
            JOptionPane.showMessageDialog(null,"New Customer Added.");
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
