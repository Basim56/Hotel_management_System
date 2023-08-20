package org.hotel_manegement.ui;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.hotel_manegement.services.AdminService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.hotel_manegement.ui.AddCustomerUI;
public class AdminUI {
    public final AdminService adminService=new AdminService();
public AdminUI(){
    JFrame frame= new JFrame("Customer UI");
    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
    String data[][]=adminService.getAllAdminsForJtable();
    String column[]={"ID","FIRST NAME","LAST NAME","EMAIL","PASSWORD"};
    JTable table= new JTable(data,column);
    JButton insert=new JButton("Insert");
    JButton update=new JButton("Update");
    JButton delete=new JButton("Delete");
    JButton back=new JButton("Back");
    JTextField search=new JTextField("Search");
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


    panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel2.setLayout(new FlowLayout(FlowLayout.LEFT,25,25));
    panel2.setBackground(Color.GRAY);
    frame.add(panel1);
    frame.add(panel2);
    insert.addActionListener((e->{
        frame.dispose();
        new AddAdminUI();

    }));
    update.addActionListener((e -> {
        if(table.getSelectedRow()!=-1){
            String row1= (String) table.getValueAt(table.getSelectedRow(),0);
            frame.dispose();
            new UpdateAdminUI();
        }
        else {
            JOptionPane.showMessageDialog(frame,"You must select a row");
        }
    }));

    delete.addActionListener((e->{
        if(table.getSelectedRow()!=-1){
            Integer id= table.getSelectedRow();
            String adminid= (String) table.getValueAt(id,0);
            adminService.delete(Integer.parseInt(adminid));
            JOptionPane.showMessageDialog(frame,"Deleted!!!");
            frame.dispose();
            new AdminUI();
        }
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
            String[][] data= adminService.searchAdminByName(search.getText());
            DefaultTableModel dtm=new DefaultTableModel(data,column);
            table.setModel(dtm);

        }
    });
    back.addActionListener(e->{
        frame.dispose();
        new HomeUI();
    });


    frame.setSize(1000,1500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);





}
}
