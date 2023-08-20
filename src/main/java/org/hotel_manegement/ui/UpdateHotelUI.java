package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Hotel;
import org.hotel_manegement.services.HotelService;

import javax.swing.*;
import java.awt.*;

public class UpdateHotelUI {
    private final HotelService hotelService=new HotelService();
    Hotel hotel=new Hotel();
    public UpdateHotelUI(){
        {
            JFrame frame= new JFrame("Hotel UI-Update");
            JTextField idtf=new JTextField(String.valueOf(hotel.getId()));
            JLabel namelb=new JLabel("NAME");
            JTextField nametf=new JTextField(hotel.getHotel_name());
            JLabel locationlb=new JLabel("LOCATION");
            JTextField locationtf=new JTextField(hotel.getLocation());
            JLabel urllb=new JLabel("URL");
            JTextField urltf=new JTextField(hotel.getUrl());
            JLabel adminIdlb=new JLabel("ADMIN ID");
            JTextField adminIdtf=new JTextField(String.valueOf(hotel.getAdmin_id()));
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
                    hotelService.update(nametf.getText(),locationtf.getText(), urltf.getText(), Integer.parseInt(adminIdtf.getText()), Integer.parseInt(idtf.getText()));
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
