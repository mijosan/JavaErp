package erp_F;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Inquiry_Dialog extends JDialog implements ActionListener{
	JTextArea textArea;
	JButton okButton;
	JButton cancelButton;
	ButtonGroup  group;
	private final JPanel contentPanel = new JPanel();

	public Inquiry_Dialog() {
		setTitle("¹®ÀÇ ¿äÃ»");
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(600, 100, 450, 550);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 511);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u25B6\uBB38\uC758\uC720\uD615");
			label.setForeground(Color.WHITE);
			label.setBackground(SystemColor.textHighlight);
			label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			label.setBounds(12, 10, 385, 15);
			contentPanel.add(label);
		}
		
		JLabel label = new JLabel("\uCD08\uAE09");
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label.setBounds(12, 70, 57, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\uD14C\uB9C8");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label_1.setBounds(12, 140, 57, 15);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\uC911\uAE09");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label_2.setBounds(12, 210, 57, 15);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\uAE30\uD0C0");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label_3.setBounds(12, 280, 57, 15);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u25B6\uC0C1\uB2F4\uC694\uCCAD\uB0B4\uC6A9");
		label_4.setForeground(Color.WHITE);
		label_4.setBackground(SystemColor.textHighlight);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label_4.setBounds(12, 353, 385, 15);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\uB0B4\uC6A9");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label_5.setBounds(12, 419, 57, 15);
		contentPanel.add(label_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uAC01\uC885 \uAE30\uCD08\uCF54\uB4DC \uB4F1\uB85D");
		rdbtnNewRadioButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(75, 50, 138, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ERP \uC0AC\uC6A9\uC790 ID\uB4F1\uB85D");
		rdbtnNewRadioButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(75, 86, 138, 23);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton radioButton = new JRadioButton("\uC6F9, \uC5D1\uC140-\uC790\uB8CC\uC62C\uB9AC\uAE30");
		radioButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton.setBounds(245, 86, 166, 23);
		contentPanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\uCD08\uAE30 \uC0AC\uC6A9\uC790\uC758 \uAE30\uD0C0 \uBB38\uC758");
		radioButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_1.setBounds(245, 50, 166, 23);
		contentPanel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\uC778\uC0AC-\uAE30\uB2A5 \uD65C\uC6A9\uBC95");
		radioButton_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_2.setBounds(75, 121, 121, 23);
		contentPanel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\uC7AC\uACE0-\uAE30\uB2A5 \uD65C\uC6A9\uBC95");
		radioButton_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_3.setBounds(245, 121, 121, 23);
		contentPanel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("\uC7AC\uACE0-\uC6D0\uAC00,\uC218\uB7C9 \uBB38\uC81C");
		radioButton_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_4.setBounds(245, 157, 152, 23);
		contentPanel.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("\uC778\uC0AC-\uAE30\uB2A5 \uC624\uB958");
		radioButton_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_5.setBounds(75, 157, 121, 23);
		contentPanel.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("\uAE09\uC5EC \uB300\uC7A5 \uBB38\uC758");
		radioButton_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_6.setBounds(75, 188, 121, 23);
		contentPanel.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("\uAE30\uCD08\uC794\uC561 \uC785\uB825");
		radioButton_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_7.setBounds(245, 188, 121, 23);
		contentPanel.add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("\uADF8\uB8F9\uC6E8\uC5B4");
		radioButton_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_8.setBounds(245, 224, 121, 23);
		contentPanel.add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("\uC7AC\uACE0\uC870\uC815");
		radioButton_9.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_9.setBounds(75, 224, 121, 23);
		contentPanel.add(radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("\uC0AC\uC6A9\uB8CC (\uD658\uBD88,\uD0C8\uD1F4 \uB4F1)");
		radioButton_10.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_10.setBounds(75, 263, 152, 23);
		contentPanel.add(radioButton_10);
		
		JRadioButton rdbtnErp = new JRadioButton("ERP \uC791\uB3D9 \uBD88\uB7C9");
		rdbtnErp.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rdbtnErp.setBounds(245, 263, 121, 23);
		contentPanel.add(rdbtnErp);
		
		JRadioButton radioButton_12 = new JRadioButton("\uC601\uC5C5 \uBC0F \uAD50\uC721 (\uC2E0\uCCAD)");
		radioButton_12.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_12.setBounds(245, 299, 138, 23);
		contentPanel.add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("\uBD80\uAC00\uC11C\uBE44\uC2A4 (\uC2E0\uCCAD,\uD574\uC9C0)");
		radioButton_13.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		radioButton_13.setBounds(75, 299, 166, 23);
		contentPanel.add(radioButton_13);
		
		textArea = new JTextArea();
		textArea.setRows(4);
		textArea.setBounds(75, 379, 336, 97);
		contentPanel.add(textArea);
		
		cancelButton = new JButton("\uCDE8\uC18C");
		cancelButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cancelButton.setBounds(314, 486, 97, 23);
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.BOLD, 12));
		cancelButton.addActionListener(this);
		
		okButton = new JButton("\uB4F1\uB85D");
		okButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		okButton.setBounds(214, 486, 97, 23);
		okButton.setBackground(Color.WHITE);
		okButton.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.BOLD, 12));
		okButton.addActionListener(this);
		group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		group.add(radioButton_2);
		group.add(radioButton_3);
		group.add(radioButton_4);
		group.add(radioButton_5);
		group.add(radioButton_6);
		group.add(radioButton_7);
		group.add(radioButton_8);
		group.add(radioButton_9);
		group.add(radioButton_10);
		group.add(radioButton_12);
		group.add(radioButton_13);
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnErp);
		contentPanel.add(okButton);
		contentPanel.add(cancelButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(12, 10, 410, 15);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(12, 353, 410, 15);
		contentPanel.add(panel_1);
	}
	
	String radiobtn() {
	Enumeration<AbstractButton> enums = group.getElements();

	while(enums.hasMoreElements()) {            // hasMoreElements() Enum¿¡ ´õ ²¨³¾ °³Ã¼°¡ ÀÖ´ÂÁö Ã¼Å©ÇÑ´Ù. ¾øÀ¸¸ç false ¹ÝÈ¯
	    AbstractButton ab = enums.nextElement();    // Á¦³×¸¯½º°¡ AbstractButton ÀÌ´Ï±î ´ç¿¬È÷ AbstractButtonÀ¸·Î ¹Þ¾Æ¾ßÇÔ
	    JRadioButton jb = (JRadioButton)ab;         // Çüº¯È¯. ¹°·Ð À­ÁÙ°ú ÀÌÁÙÀ» ÇÕÃÄ¼­ ¹Ù·Î Çüº¯È¯ ÇØ¼­ ¹Þ¾Æµµ µÈ´Ù.
	 
	    if(jb.isSelected())                         // ¹Þ¾Æ³½ ¶óµð¿À¹öÆ°ÀÇ Ã¼Å© »óÅÂ¸¦ È®ÀÎÇÑ´Ù. Ã¼Å©µÇ¾úÀ»°æ¿ì true ¹ÝÈ¯.
	        return jb.getText(); //getText() ¸Þ¼Òµå·Î ¹®ÀÚ¿­ ¹Þ¾Æ³½´Ù.
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == okButton) {//String title, String content, String toEmail, String fromEmail
			GmailSend.send("ERP_F ¹®ÀÇ »çÇ×ÀÌ Àü´Þ µÇ¾ú½À´Ï´Ù.", "Àü¼ÛÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù. ",First_Frame.email, "erptaesanChoi@gmail.com");
			GmailSend.send("ERP_F ¹®ÀÇ »çÇ× ÀÔ´Ï´Ù", First_Frame.name +"("+First_Frame.email+") : "+radiobtn()+" ¢º "+textArea.getText(),"erptaesanchoi@gmail.com", "erptaesanchoi@gmail.com");
			
			setVisible(false);
			dispose();
		}else if(obj == cancelButton) {
			setVisible(false);
			dispose();
		}
	}
}
