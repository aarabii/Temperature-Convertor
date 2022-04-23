
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConvertor {
    public static void main(String[] args) {

        JFrame f=new JFrame("Temperature Converter");

        String[] temp = {"Celsius", "Fahrenheit", "Kelvin"};

        JLabel l1;  // Label
        JTextField t1,t2; // Text Field
        JComboBox cb1, cb2; // Combo Box
        JButton b1; // Button

        //Fonts
        Font font1 = new Font("Serif", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD , 15);
        Font font3 = new Font("Serif", Font.BOLD, 24);
        Font font4 = new Font("Arial", Font.BOLD , 20);


        l1 = new JLabel("Temperature Converter"); // Title
        l1.setBounds(175, 30, 500, 100);
        l1.setFont(font1);


        t1 = new JTextField("0"); // Text Field 1
        t1.setBounds(50, 150, 150, 30);
        t1.setFont(font2);

        t2 = new JTextField("0 °C"); // Text Field 2
        t2.setBounds(500, 150, 150, 30);
        t2.setFont(font4);
        t2.setEnabled(false);


        cb1 = new JComboBox(temp); // Combo Box 1
        cb1.setBounds(50, 180, 150, 30);

        cb2 = new JComboBox(temp); // Combo Box 2
        cb2.setBounds(500, 180, 150, 30);


        b1 = new JButton("Convert"); // Button
        b1.setBackground(Color.GREEN);
        b1.setBounds(275, 250, 120, 50);
        b1.setFont(font3);

        f.add(l1); // adding label
        f.add(t1); f.add(t2); // adding textField
        f.add(cb1); f.add(cb2); // adding combo box
        f.add(b1); // adding buttons
        f.setSize(700,400);//700 width and 400 height
        f.setLayout(null);//using no layout managers
        f.setResizable(false); // disabling resizing
        f.setVisible(true); // turning on the visibility

        // Adding Event
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int tempValue = Integer.parseInt(t1.getText());

                Object tempScaleFrom = cb1.getItemAt(cb1.getSelectedIndex());
                Object tempScaleTo = cb2.getItemAt(cb2.getSelectedIndex());

                try {


                    if (tempScaleFrom == "Celsius" & tempScaleTo == "Celsius") {
                        t2.setText(tempValue + " °C");
                    } else if (tempScaleFrom == "Celsius" & tempScaleTo == "Fahrenheit") {
                        float c2f = (tempValue * 9 / 5) + 32;
                        t2.setText(c2f + " °F");
                    } else if (tempScaleFrom == "Celsius" & tempScaleTo == "Kelvin") {
                        float c2k = (float) (tempValue + 273.15);
                        t2.setText(c2k + " K");
                    } else if (tempScaleFrom == "Fahrenheit" & tempScaleTo == "Celsius") {
                        float f2c = ((tempValue - 32) * 5) / 9;
                        t2.setText(f2c + " °C");
                    } else if (tempScaleFrom == "Fahrenheit" & tempScaleTo == "Kelvin") {
                        float f2k = (float) ((((tempValue - 32) * 5) / 9) + 273.15);
                        t2.setText(f2k + " K");
                    } else if (tempScaleFrom == "Fahrenheit" & tempScaleTo == "Fahrenheit") {
                        t2.setText(tempValue + " °F");
                    } else if (tempScaleFrom == "Kelvin" & tempScaleTo == "Celsius") {
                        float k2c = (float) (tempValue - 273.15);
                        t2.setText(k2c + " °C");
                    } else if (tempScaleFrom == "Kelvin" & tempScaleTo == "Fahrenheit") {
                        float k2f = (float) (((tempValue - 273.15) * 9 / 5) + 32);
                        t2.setText(k2f + " °F");
                    } else if (tempScaleFrom == "Kelvin" & tempScaleTo == "Kelvin") {
                        t2.setText(tempValue + " K");
                    }

                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, err);
                }

            }
        });
    }
}
