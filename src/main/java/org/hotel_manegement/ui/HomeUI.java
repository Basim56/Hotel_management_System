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
                JButton report=new JButton("Reports");
                admin.setPreferredSize(new Dimension(350,150));
                hotel.setPreferredSize(new Dimension(350,150));
                customer.setPreferredSize(new Dimension(350,150));
                room.setPreferredSize(new Dimension(350,150));
                booking.setPreferredSize(new Dimension(350,150));
                report.setPreferredSize(new Dimension(350,150));


                frame.setLayout(new GridLayout(2,3,25,25));
                panel.setLayout(new FlowLayout(FlowLayout.CENTER));
                panel.add(admin);
                panel.add(hotel);
                panel.add(customer);
                panel.add(room);
                panel.add(booking);
                panel.add(report);
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
                report.addActionListener(e->{
                    frame.dispose();
                    new ReportUI();
                });
                frame.add(panel);
                frame.setSize(1500,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

            }
    }

