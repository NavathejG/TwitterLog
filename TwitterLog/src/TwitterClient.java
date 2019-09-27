import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TwitterClient {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextArea textArea;

	public static void main(String[] args) {
        setSystemLookFeel();
        JFrame frame = new JFrame("Tweet Reader");
        frame.setBounds(0, 0, 1280, 600);

        JPanel jpan = new JPanel();
        frame.getContentPane().add(jpan, BorderLayout.CENTER);
        GridBagLayout gbl_jpan = new GridBagLayout();
        gbl_jpan.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_jpan.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_jpan.columnWeights = new double[]{0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_jpan.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        jpan.setLayout(gbl_jpan);
        
        JLabel lblNewLabel = new JLabel("Search Criteria");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 14;
        gbc_lblNewLabel.gridheight = 6;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 4;
        gbc_lblNewLabel.gridy = 2;
        jpan.add(lblNewLabel, gbc_lblNewLabel);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.gridx = 18;
        gbc_textField.gridy = 3;
        jpan.add(textField, gbc_textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.gridx = 18;
        gbc_textField_1.gridy = 4;
        jpan.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.gridx = 18;
        gbc_textField_2.gridy = 5;
        jpan.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3.gridx = 18;
        gbc_textField_3.gridy = 6;
        jpan.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 0);
        gbc_textField_4.gridx = 18;
        gbc_textField_4.gridy = 7;
        jpan.add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);
        
        JButton btnNewButton = new JButton("Fetch Tweets");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		btnNewButton.setEnabled(false);
        		String textFieldValue1 = textField.getText();
        		String textFieldValue2 = textField_1.getText();
        		String textFieldValue3 = textField_2.getText();
        		String textFieldValue4 = textField_3.getText();
        		String textFieldValue5 = textField_4.getText();
        		
        		FetchData fetchData = new FetchData();
        		if(!textFieldValue1.isEmpty()) {
        			textArea.append(fetchData.getDataFromTwitter(textFieldValue1));
        			textArea.repaint();
        		}if(!textFieldValue2.isEmpty()) {
        			textArea.append(fetchData.getDataFromTwitter(textFieldValue2));
        			textArea.repaint();
        		}if(!textFieldValue3.isEmpty()) {
        			textArea.append(fetchData.getDataFromTwitter(textFieldValue3));
        			textArea.repaint();
        		}if(!textFieldValue4.isEmpty()) {
        			textArea.append(fetchData.getDataFromTwitter(textFieldValue4));
        			textArea.repaint();
        		}if(!textFieldValue5.isEmpty()) {
        			textArea.append(fetchData.getDataFromTwitter(textFieldValue5));
        			textArea.repaint();
        		}
        		btnNewButton.setEnabled(true);
        	}
        });
        
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.gridx = 16;
        gbc_btnNewButton.gridy = 9;
        jpan.add(btnNewButton, gbc_btnNewButton);
        
        textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setEditable(false);
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.gridwidth = 19;
        gbc_textArea.insets = new Insets(0, 0, 5, 0);
        gbc_textArea.fill = GridBagConstraints.BOTH;
        gbc_textArea.gridx = 0;
        gbc_textArea.gridy = 11;
        jpan.add(textArea, gbc_textArea);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

    private static void setSystemLookFeel()
    {
        String laf = UIManager.getSystemLookAndFeelClassName();
        try
        {
            UIManager.setLookAndFeel(laf);
        }
        catch (UnsupportedLookAndFeelException exc )
        {
            System.err.println("Unsupported: " + laf);
        }
        catch (Exception exc)
        {
            System.err.println("Error loading " + laf);
        }
    }
}

