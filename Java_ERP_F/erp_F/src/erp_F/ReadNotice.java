package erp_F;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class ReadNotice extends JDialog{
	JTextArea textArea;
	Base64 base64;
	JLabel lblNewLabel;
	Image img;
	MemberMgr mgr;
	public ReadNotice(String title,String name, String day1,int a){
		mgr = new MemberMgr();
		base64 = new Base64();
		setTitle(title);
		setBounds(400, 100, 500, 560);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		img = base64.readImg(mgr.getNoticeNum2(NoticeBoard.title));
		img = img.getScaledInstance(484, 245, Image.SCALE_SMOOTH);
	    lblNewLabel = new JLabel("");
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				textArea = new JTextArea();
				textArea.setBounds(0, 246, 484, 229);
				MemberMgr mgr = new MemberMgr();
				String text = mgr.getContent(a);
				panel.setLayout(null);
				lblNewLabel.setIcon(new ImageIcon(img));
				
				
				textArea.append(text);
				textArea.setEditable(false);
				panel.add(textArea);
			}
			lblNewLabel.setBounds(0, 0, 484, 245);
			panel.add(lblNewLabel);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 245, 684, 2);
			panel.add(separator);
		}
		{
			JLabel label = new JLabel(day1);
			label.setBackground(SystemColor.textHighlight);
			getContentPane().add(label, BorderLayout.SOUTH);
		}
		{
			JLabel label = new JLabel(name);
			label.setBackground(SystemColor.textHighlight);
			getContentPane().add(label, BorderLayout.NORTH);
		}
		setVisible(true);
	}
}
