package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Room;

import javax.swing.*;
import java.awt.*;

public class HomeUI {
    public HomeUI(){
                JFrame frame = new JFrame("Hotel Management App");
                JPanel panel = new JPanel();
                JButton admin = new JButton("Admin");
                JButton hotel = new JButton("Hotel");
                JButton customer = new JButton("Customer");
                JButton room = new JButton("Room");
                JButton booking = new JButton("Booking");


                frame.setLayout(new BorderLayout());
                panel.add(admin);
                panel.add(hotel);
                panel.add(customer);
                panel.add(room);
                panel.add(booking);
                panel.setLayout(new FlowLayout(FlowLayout.CENTER,25,25));
                admin.addActionListener((e)->{
                    frame.dispose();
                    new AdminUI();
                });
                hotel.addActionListener((e)->{
                    frame.dispose();
                    new HotelUI();
                });
                customer.addActionListener((e)->{
                   frame.dispose();
                   new CustomerUI();
                });
                room.addActionListener((e)->{
                    frame.dispose();
                    new RoomUI();
                });
                booking.addActionListener((e)->{
                    frame.dispose();
                    new BookingUI();
                });
                frame.add(panel,BorderLayout.NORTH);
                frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

            }
    }

