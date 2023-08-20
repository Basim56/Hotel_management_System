package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Customer;
import org.hotel_manegement.services.CustomerService;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.hotel_manegement.ui.AddCustomerUI;
import org.hotel_manegement.ui.UpdateCustomerUI;

public class CustomerUI {

    private final CustomerService customerService=new CustomerService();
    Customer customer=new Customer();
         public CustomerUI(){
             JFrame frame= new JFrame("Customer UI");
             JPanel panel1=new JPanel();
             JPanel panel2=new JPanel();
             String data[][]=customerService.getAllCustomersforJtable();
             String column[]={"ID","Name","Phone Number","CNIC"};
             DefaultTableModel dtm=new DefaultTableModel(data,column);
             JTable table= new JTable(dtm);
             JLabel idlb=new JLabel(String.valueOf(customer.getId()));
             JButton insert=new JButton("Insert");
             JButton update=new JButton("Update");
             JButton delete=new JButton("Delete");
             JButton back=new JButton("back");



             JTextField search=new JTextField(30);
             search.setBounds(250,10,150,50);
             JScrollPane scrollPane=new JScrollPane(table);
             scrollPane.setBounds(1000,10,450,450);
             frame.setLayout(new GridLayout());
             panel1.add(search);



             panel1.add(scrollPane);
             panel2.add(insert);
             panel2.add(update);
             panel2.add(delete);
             panel2.add(back);
             insert.setPreferredSize(new Dimension(400,100));
             delete.setPreferredSize(new Dimension(400,100));
             update.setPreferredSize(new Dimension(400,100));
             back.setPreferredSize(new Dimension(400,100));
             search.setPreferredSize(new Dimension(150,50));
             insert.addActionListener(e -> {
                 frame.dispose();
                 new AddCustomerUI();
             });

             update.addActionListener((e -> {
                 if(table.getSelectedRow()!=-1){
                     frame.dispose();
                     new UpdateCustomerUI();
                 }
                 else {
                     JOptionPane.showMessageDialog(frame,"You must select a row");
                 }
             }));
             delete.addActionListener((e -> {
                 if(table.getSelectedRow()!=-1){
//                     customerService.delete(customer.getId());
                     Integer id = table.getSelectedRow();

                     String cusId = (String) table.getValueAt(id, 0);


                     customerService.delete(Long.valueOf(cusId));
                     frame.dispose();
                     JOptionPane.showMessageDialog(frame, "Deleted!!!");
                     new CustomerUI();

                 }
             }));
             back.addActionListener((e->{
                 frame.dispose();
                 new HomeUI();
             }));


             search.addKeyListener(new KeyListener() {
                 @Override
                 public void keyTyped(KeyEvent e) {

                 }

                 @Override
                 public void keyPressed(KeyEvent e) {

                 }

                 @Override
                 public void keyReleased(KeyEvent e) {
                     String[][] data= customerService.searchCustomerbyname(search.getText());
                     DefaultTableModel dtm=new DefaultTableModel(data,column);
                     table.setModel(dtm);
                 }
             });




             panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
             panel2.setLayout(new FlowLayout(FlowLayout.LEFT,25,25));
             panel2.setBackground(Color.GRAY);
             frame.add(panel1);
             frame.add(panel2);

             frame.setSize(1000,1500);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);








         }
}
