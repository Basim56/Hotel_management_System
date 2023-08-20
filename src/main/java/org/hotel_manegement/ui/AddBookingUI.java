package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Booking;
import org.hotel_manegement.services.BookingService;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

public class AddBookingUI {
    private final BookingService bookingService=new BookingService();
    Booking booking=new Booking();
    public AddBookingUI(){
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




        JFrame frame= new JFrame("Booking UI-ADD");
        JLabel hotel_idlb=new JLabel("HOTEL ID");
        String[] hotels= bookingService.Addhotel();
        JComboBox hotelbox=new JComboBox<>(hotels);



        JLabel room_idlb=new JLabel("ROOM ID");
        String[] rooms= {};
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


        JTextField departureDatetf=new JTextField(20);
        JButton save=new JButton("SAVE");
        JButton back=new JButton("BACK");
        JButton check=new JButton("CHECK");



        frame.setLayout(new GridLayout(7,2,10,10));

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
        frame.add(save);
        frame.add(back);
        frame.add(check);

LocalDate localDate=LocalDate.now();
        check.addActionListener(e->{
            String inputAdmin1 = (String) hotelbox.getSelectedItem();
            String[] hotel = inputAdmin1.split(",");
            Integer hotel12 = Integer.valueOf(hotel[0]);

            LocalDate arrivalLocalDate = LocalDate.of(model.getYear(),model.getMonth()+1, model.getDay());
            LocalDate departureLocalDate = LocalDate.of(model.getYear(),model.getMonth()+1, model.getDay());
            if(arrivalLocalDate.isBefore(localDate) || departureLocalDate.isBefore(arrivalLocalDate)){
                JOptionPane.showMessageDialog(frame,"Invalid date");
            }else{
                String[] data4 = bookingService.getAvailableRoom(hotel12, arrivalLocalDate, departureLocalDate);
                if(data4==null){
                    JOptionPane.showMessageDialog(frame,"No room available");
                }
                roombox.removeAllItems();
                for(int i=0; i<data4.length; i++){
                    roombox.addItem(data4[i]);
                }
            }
        });

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

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
