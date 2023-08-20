package org.hotel_manegement.ui;

import org.hotel_manegement.dao.CustomerDAO;
import org.hotel_manegement.dao.ICrud;
import org.hotel_manegement.domain.Customer;
import org.hotel_manegement.services.CustomerService;

import javax.swing.*;
import java.awt.*;

public class UpdateCustomerUI {
    private final CustomerService customerService=new CustomerService();
    ICrud<Customer> dao=new CustomerDAO();
    public UpdateCustomerUI() {
        Customer customer=new Customer();
        JFrame frame = new JFrame("Customer UI-ADD");

        JLabel idlb = new JLabel("ID");
        JTextField idtf = new JTextField(20);
        JLabel namelb = new JLabel("NAME");
        JTextField nametf = new JTextField(customer.getName());
        JLabel phonelb = new JLabel("PHONE");
        JTextField phonetf = new JTextField(customer.getPhone_number());
        JLabel cniclb = new JLabel("CNIC");
        JTextField cnictf = new JTextField(customer.getCnic());
        JButton save = new JButton("Save");
        JButton back = new JButton("Back");
        namelb.setPreferredSize(new Dimension(250, 100));
        phonelb.setPreferredSize(new Dimension(250, 100));
        cniclb.setPreferredSize(new Dimension(250, 100));


        frame.setLayout(new GridLayout(6, 2, 10, 10));

        frame.add(namelb);
        frame.add(nametf);
        frame.add(phonelb);
        frame.add(phonetf);
        frame.add(cniclb);
        frame.add(cnictf);
        frame.add(save);
        frame.add(back);

//        idtf.setText(row);

        back.addActionListener((e) -> {
            frame.dispose();
            new CustomerUI();
        });
        save.addActionListener((e -> {
            customerService.update(nametf.getText(),phonetf.getText(),cnictf.getText(), Integer.parseInt(idtf.getText()));
        }));

        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

