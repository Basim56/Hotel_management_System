package org.hotel_manegement.ui;

import org.hotel_manegement.services.HotelService;

import javax.swing.*;
import java.awt.*;

public class AddHotelUI {
    private final HotelService hotelService=new HotelService();
    public AddHotelUI(){
        {
            JFrame frame= new JFrame("Customer UI-ADD");
            JLabel namelb=new JLabel("NAME");
            JTextField nametf=new JTextField(20);
            JLabel locationlb=new JLabel("LOCATION");
            JTextField locationtf=new JTextField(20);
            JLabel urllb=new JLabel("URL");
            JTextField urltf=new JTextField(20);
            JLabel adminIdlb=new JLabel("ADMIN ID");
            JTextField adminIdtf=new JTextField(20);
            JButton save=new JButton("Save");
            JButton back=new JButton("Back");



            frame.setLayout(new GridLayout(6,2,10,10));

            frame.add(namelb);
            frame.add(nametf);
            frame.add(locationlb);
            frame.add(locationtf);
            frame.add(urllb);
            frame.add(urltf);
            frame.add(adminIdlb);
            frame.add(adminIdtf);
            frame.add(save);
            frame.add(back);
            save.addActionListener((e)->{
                try {
//                int phLength=100;
                    hotelService.insert(nametf.getText(),locationtf.getText(), urltf.getText(), Integer.parseInt(adminIdtf.getText()));
                    frame.dispose();
                    new HotelUI();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(frame,"Unable to Save");
                }
            });

            back.addActionListener((e)->{
                frame.dispose();
                new HotelUI();
            });

            frame.setSize(1500,1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }

    }

}
