package WordCounter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Launch extends JFrame implements ActionListener{
    JLabel text , result;       // Labels for Displaying Text and Result
    JTextField area;            // TextField for taking text as input
    JButton count , exit;       // Buttons for counting words and exiting

    // Constructor
    public Launch(){
        setTitle("Word Counter");
        setLayout(null);

        // Load and display a image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 500);
        add(image);

        // Indicating where to write the text
        text = new JLabel("Write Down Text");
        text.setFont(new Font("Osward", Font.BOLD, 26));
        text.setBounds(265, 30, 400, 25);
        image.add(text);

        // Text Field to write the text
        area = new JTextField();
        area.setBounds(130, 70, 500, 50);
        area.setFont(new Font("Arial", Font.BOLD, 17));
        image.add(area);

        // Button for counting words from the given text
        count = new JButton("COUNT WORDS");
        count.setBounds(280, 140, 180, 40);
        count.setFont(new Font("Arial", Font.BOLD, 17));
        count.setBackground(Color.BLACK);
        count.setForeground(Color.WHITE);
        count.addActionListener(this);  
        image.add(count);

        // To show the count words result
        result = new JLabel();
        result.setFont(new Font("Osward", Font.BOLD, 25));
        result.setBounds(360, 190, 180, 40);
        result.setBackground(Color.white);
        image.add(result);

        // Button to exit the application
        exit = new JButton("EXIT");
        exit.setBounds(317, 400, 100, 40);
        exit.setFont(new Font("Arial", Font.BOLD, 17));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);
      
        setSize(800, 500);       
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == count){
            String enteredText = area.getText();
            if(enteredText.isEmpty()){
                JOptionPane.showMessageDialog(null , "Please Enter a Text");
            }else{

                // Split the entered text using various punctuation and whitespace as delimiters
                String[] arr = enteredText.split("[\\s,\\.?!:;\"\\(\\)\\-']+");
                int countWords = arr.length;
                result.setText(countWords + "");  // Display the word count
            }     
        }
    }
    
    public static void main(String[] args) {
        new Launch();     // Launching the application
    }
}
