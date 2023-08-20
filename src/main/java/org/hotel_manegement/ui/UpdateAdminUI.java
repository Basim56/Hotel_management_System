package org.hotel_manegement.ui;

import org.hotel_manegement.dao.Hotel_AdminDAO;
import org.hotel_manegement.dao.ICrud;
import org.hotel_manegement.domain.Admin;
import org.hotel_manegement.domain.Booking;
import org.hotel_manegement.services.AdminService;
import org.hotel_manegement.services.BookingService;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Properties;

public class UpdateAdminUI {
        private final BookingService bookingService=new BookingService();
        Booking booking=new Booking();
        public UpdateAdminUI(){
            UtilDateModel model = new UtilDateModel();
            Properties p1 = new Properties();
            p1.put("text.today", "Today");
            p1.put("text.month", "Month");
            p1.put("text.year", "Year");
            JDatePanelImpl datePanel = new JDatePanelImpl(model, p1);

            UtilDateModel model1 = new UtilDateModel();
            Properties p2 = new Properties();
            p2.put("text.today", "Today");
            p2.put("text.month", "Month");
            p2.put("text.year", "Year");
            JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p2);




            JFrame frame= new JFrame("Booking UI-UPDATE");
            JTextField bid=new JTextField(booking.getBooking_id());
            JLabel hotel_idlb=new JLabel("HOTEL ID");
            String[] hotels= bookingService.Addhotel();
            JComboBox hotelbox=new JComboBox<>(hotels);

            JLabel room_idlb=new JLabel("ROOM ID");
            String[] rooms= bookingService.AddRoom();
            JComboBox roombox=new JComboBox<>(rooms);

            JLabel customer_idlb=new JLabel("CUSTOMER ID");
            String[] customers= bookingService.AddCustomer();
            JComboBox customerbox=new JComboBox<>(customers);

            JLabel arrivalDateLbl = new JLabel("ARRIVAL DATE: ");
            JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
            int year = (int) model.getYear();
            int month = model.getMonth() + 1;
            int day = model.getDay();
            String arrival_date = String.format("%04d-%02d-%02d", year, month, day);

            JLabel departureDateLbl = new JLabel("DEPARTURE DATE: ");
            JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel1, new DateComponentFormatter());
            int year1 = (int) model1.getYear();
            int month1 = model1.getMonth() + 1; // Adding 1 because months are zero-based
            int day1 = model1.getDay();
            String departure_date = String.format("%04d-%02d-%02d", year1, month1, day1);


            JLabel statuslb=new JLabel("STATUS");
            JTextField statustf=new JTextField(booking.getB_status());
            JButton save=new JButton("SAVE");
            JButton back=new JButton("BACK");



            frame.setLayout(new GridLayout(6,2,10,10));

            frame.add(hotel_idlb);
            frame.add(hotelbox);
            frame.add(room_idlb);
            frame.add(roombox);
            frame.add(customer_idlb);
            frame.add(customerbox);
            frame.add(arrivalDateLbl);
            frame.add(datePicker);
            frame.add(departureDateLbl);
            frame.add(datePicker2);
            frame.add(statuslb);
            frame.add(statustf);
            frame.add(save);
            frame.add(back);

            save.addActionListener((e)->{

                String hotel_id= (String) hotelbox.getSelectedItem();
                String[] val = hotel_id.split(",");
                Integer hid = Integer.valueOf(val[0]);
                String room_id=(String) roombox.getSelectedItem();
                String[] val1=room_id.split(",");
                Integer rid=Integer.valueOf(val1[0]);
                String customer_id=(String) customerbox.getSelectedItem();
                String[] val2=customer_id.split(",");
                Integer cid=Integer.valueOf(val2[0]);
//                System.out.println(room_id);
//                System.out.println(customer_id);
                String arrivalDate= arrival_date;
                String departureDate= departure_date;

//                double price=Integer.parseInt(pricetf.getText());

//                int phLength=100;
                try {
                    bookingService.save(hid,rid,cid, arrivalDate,departureDate) ;
                    frame.dispose();
                    new BookingUI();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,"Unable to Save");
                }

            });

            back.addActionListener((e)->{
                frame.dispose();
                new BookingUI();
            });

            frame.setSize(1500,1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
    }


