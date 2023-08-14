package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerUI {
         public CustomerUI(){
             JFrame frame= new JFrame("Customer UI");
             JPanel panel1=new JPanel();
             JPanel panel2=new JPanel();
             JPanel panel3=new JPanel();
             String data[][]={ {"101","Amit","670000"},
                     {"102","Jai","780000"},
                     {"101","Sachin","700000"}};
             String column[]={"ID","NAME","SALARY"};
             JTable table= new JTable(data,column);
             JButton insert=new JButton("Insert");
             JButton edit=new JButton("Edit");
             JButton update=new JButton("Update");
             JButton delete=new JButton("Delete");
             JButton search=new JButton("Search");
             search.setText("Search");
             JScrollPane scrollPane=new JScrollPane(table);
             scrollPane.setBounds(1000,10,450,450);
             frame.setLayout(new BorderLayout());

             panel1.add(scrollPane);
             panel2.add(insert);
             panel2.add(edit);
             panel2.add(update);
             panel2.add(delete);
             insert.setPreferredSize(new Dimension(200,100));
             delete.setPreferredSize(new Dimension(200,100));
             update.setPreferredSize(new Dimension(200,100));
             edit.setPreferredSize(new Dimension(200,100));

             panel3.add(search);
             panel1.setLayout(new GridLayout());
             panel2.setLayout(new FlowLayout(FlowLayout.LEFT,25,25));
             frame.add(panel1,BorderLayout.EAST);
             frame.add(panel2,BorderLayout.WEST);
             frame.add(panel3,BorderLayout.NORTH);
             frame.setSize(1000,1500);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);







         }
}
