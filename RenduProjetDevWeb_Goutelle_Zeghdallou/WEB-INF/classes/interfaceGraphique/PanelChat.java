package interfaceGraphique;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyEvent;

public class PanelChat extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public PanelChat() {
		setBackground(new Color(240, 240, 240));
		setPreferredSize(new Dimension(400,400));
		setMinimumSize(new Dimension(400, 400));
		setLayout(new MigLayout("", "[256.00][459.00px][102.00px]", "[63.00][400px][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setPreferredSize(new Dimension(600, 400));
		add(lblNewLabel, "cell 1 1 2 1,alignx left,aligny top");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setMnemonic(KeyEvent.VK_ENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(btnNewButton, "cell 2 2,grow");}
}
