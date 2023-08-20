package org.hotel_manegement.ui;

import org.hotel_manegement.services.HotelService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HotelUI {
    private final HotelService hotelService=new HotelService();
    public HotelUI(){
        JFrame frame= new JFrame("Hotel UI");
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        String data[][]=hotelService.getAllhotelsforJtable();
        String column[]={"HOTEL ID","NAME","LOCATION","URL","ADMIN ID"};
        DefaultTableModel dtm=new DefaultTableModel(data,column);
        JTable table= new JTable(dtm);
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
        search.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String[][] data= hotelService.getHotelbyname(search.getText());
                DefaultTableModel dtm=new DefaultTableModel(data,column);
                table.setModel(dtm);
            }
        });
        insert.addActionListener(e -> {
            frame.dispose();
            new AddHotelUI();
        });
        update.addActionListener(e->{
            if(table.getSelectedRow()!=-1) {
                frame.dispose();
                new UpdateHotelUI();
            }
            else {
                JOptionPane.showMessageDialog(frame,"You must select a row");
            }
        });
        delete.addActionListener(e->{
            if (table.getSelectedRow()!=-1){
                int id= table.getSelectedRow();
                String hotelid= (String) table.getValueAt(id,0);
                hotelService.delete(Integer.parseInt(hotelid));
                JOptionPane.showMessageDialog(frame,"Deleted!!!");
                frame.dispose();
                new HotelUI();
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
