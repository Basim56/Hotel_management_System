package org.hotel_manegement.ui;

import org.hotel_manegement.services.ReportService;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class MonthlyReportUI {
    private final ReportService reportService=new ReportService();
    public  MonthlyReportUI(){
        JFrame frame=new JFrame("Monthly Report");
        UtilDateModel utm=new UtilDateModel();
        Properties p1=new Properties();
        p1.put("text.today","Today");
        p1.put("text.month","Month");
        p1.put("text.year","Year");
        JDatePanelImpl panel=new JDatePanelImpl(utm,p1);

        UtilDateModel utm1=new UtilDateModel();
        Properties p2=new Properties();
        p2.put("text.today","Today");
        p2.put("text.month","Month");
        p2.put("text.year","Year");
        JDatePanelImpl panel1=new JDatePanelImpl(utm1,p2);

        JLabel startDate=new JLabel("Start Date");
        int year= utm.getYear();
        int month=utm.getMonth()+1;
        int day= utm.getDay();
        String startDatedp = String.format("%04d-%02d-%02d", year, month, day);

        JLabel endDate=new JLabel("End Date");
        int year1= utm1.getYear();
        int month1= utm.getMonth()+1;
        int day1= utm.getDay();
        String endDatedp=String.format("%04d-%02d-%02d",year1,month1,day1);

        JDatePickerImpl datePicker1 = new JDatePickerImpl(panel, new DateComponentFormatter());
        JDatePickerImpl datePicker2 = new JDatePickerImpl(panel1, new DateComponentFormatter());

        JLabel hotel1=new JLabel("Select Hotel") ;
        String[] hotel=reportService.Addhotel();
        JComboBox hotelbox=new JComboBox<>(hotel);

        JButton check=new JButton("Check");

        frame.add(startDate);
        frame.add(datePicker1);
        frame.add(endDate);
        frame.add(datePicker2);
        frame.add(hotel1);
        frame.add(hotelbox);
        frame.add(check);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(4,2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }
}
