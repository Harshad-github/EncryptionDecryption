import javax.swing.*;
import java.awt.*;
import java.io.*;
public class EncryptionDecryption
{
    public static void operate(int key)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

       try
        {
            FileInputStream fis = new FileInputStream(file);
            byte []data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for(byte b: data)
            {
                System.out.println(b);
                data[i] = (byte) (b^key);
                i++;
            }
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(data);
            fout.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
        } 
       catch (Exception e)
        {
           e.printStackTrace();
        }
        
    }


    public static void main(String args[])
    {
        
        JFrame jf = new JFrame();
        jf.setSize(500,500);
        jf.setTitle("Images Operation");
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto", Font.BOLD, 25);
        
        JButton button = new JButton(); 
        button.setText("Encrypt");
        button.setFont(font); 
       

        JTextField textField = new JTextField(10);
        textField.setFont(font); 
        
        button.addActionListener(e ->{ 
            System.out.println("butten clicked");
            String text =  textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
            
            button.setText("Decrypt");
            

        });

        jf.setLayout(new FlowLayout());

        jf.add(button);
        jf.add(textField);
        
        jf.setVisible(true);

    }
}