package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Room;
import org.hotel_manegement.services.RoomService;

import javax.swing.*;
import java.awt.*;

public class UpdateRoomUI {
    private final RoomService roomService=new RoomService();
    Room room=new Room();
    public UpdateRoomUI(){
        {
            JFrame frame= new JFrame("Room UI-Update");
            JTextField idtf=new JTextField(String.valueOf(room.getId()));
            JLabel categorylb=new JLabel("CATEGORY");
            JTextField categorytf=new JTextField(room.getCategory());
            JLabel roomFloorlb=new JLabel("ROOM FLOOR");
            JTextField roomFloortf=new JTextField(room.getRoom_floor());
            JLabel pricelb=new JLabel("PRICE");
            JTextField pricetf=new JTextField(String.valueOf(room.getPrice()));
            JLabel hotel_idlb=new JLabel("HOTEL ID");
            JTextField hoteltf=new JTextField(Math.toIntExact(room.getHotel_id()));
            JLabel urllb=new JLabel("URL");
            JTextField urltf=new JTextField(room.getUrl());
            JButton save=new JButton("Save");
            JButton back=new JButton("Back");



            frame.setLayout(new GridLayout(6,2,10,10));

            frame.add(categorylb);
            frame.add(categorytf);
            frame.add(roomFloorlb);
            frame.add(roomFloortf);
            frame.add(pricelb);
            frame.add(pricetf);
            frame.add(hotel_idlb);
            frame.add(hoteltf);
            frame.add(urllb);
            frame.add(urltf);
            frame.add(save);
            frame.add(back);
            save.addActionListener((e)->{
                try {
                    double price= Double.parseDouble(pricetf.getText());
                    int hotel_id=Integer.parseInt(hoteltf.getText());
//                int phLength=100;
                    roomService.update(categorytf.getText(),roomFloortf.getText(),hotel_id,price, urltf.getText(), Integer.parseInt(idtf.getText()));
                    frame.dispose();
                    new RoomUI();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(frame,"Unable to Save");
                }
            });

            back.addActionListener((e)->{
                frame.dispose();
                new CustomerUI();
            });

            frame.setSize(1500,1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
    }
}
