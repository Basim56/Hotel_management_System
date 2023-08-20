package org.hotel_manegement.ui;

import org.hotel_manegement.services.BookingService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;

public class BookingUI {
   public final BookingService bookingService=new BookingService();
    public BookingUI() {
        JFrame frame = new JFrame("Booking UI");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        String[][] data =  bookingService.getAllbookingforJtable();
        String[] column = {"BOOKING ID","HOTEL NAME", "ROOM NAME", "CUSTOMER NAME","ARRIVAL DATE","DEPARTURE DATE","PRICE","STATUS"};
        DefaultTableModel dtm=new DefaultTableModel(data,column);
        JTable table = new JTable(dtm);
        JButton insert = new JButton("Insert");
        JButton delete = new JButton("Delete");
        JButton back=new JButton("Back");
        JTextField search = new JTextField("Search");
        search.setBounds(250, 10, 150, 50);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(1000, 10, 450, 450);
        frame.setLayout(new GridLayout());
        panel1.add(search);

        panel1.add(scrollPane);
        panel2.add(insert);
        panel2.add(delete);
        panel2.add(back);
        insert.setPreferredSize(new Dimension(400, 100));
        delete.setPreferredSize(new Dimension(400, 100));
        back.setPreferredSize(new Dimension(400, 100));
        search.setPreferredSize(new Dimension(150, 50));
        search.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                    String[][] data=bookingService.searchbyStatus(search.getText());
                    DefaultTableModel dtm=new DefaultTableModel(data,column);
                    table.setModel(dtm);

            }
        });
        back.addActionListener(e->{
            frame.dispose();
            new HomeUI();
        });

        insert.addActionListener((e->{
            frame.dispose();
            new AddBookingUI();
        }));

        delete.addActionListener(e->{
            if(table.getSelectedRow()!=-1){
                Integer id= table.getSelectedRow();
                String Bookid= (String) table.getValueAt(id,0);
                bookingService.delete(Integer.parseInt(Bookid));
                JOptionPane.showMessageDialog(frame,"Deleted!!!");
                frame.dispose();
                new BookingUI();
            }
        });



        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 25));
        panel2.setBackground(Color.GRAY);
        frame.add(panel1);
        frame.add(panel2);

        frame.setSize(1000, 1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



}
