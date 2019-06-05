package erp_F;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReadNotice2 extends JDialog{

	
	public ReadNotice2(String title,String name, String day1,int a){
		setTitle(title);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				TextArea textArea = new TextArea();
				MemberMgr mgr = new MemberMgr();
				String text = mgr.getContent(a);
				textArea.setText(text);
				textArea.setEditable(false);
				panel.add(textArea);
			}
		}
		{
			Label label = new Label(day1);
			label.setBackground(SystemColor.textHighlight);
			getContentPane().add(label, BorderLayout.SOUTH);
		}
		{
			JLabel label = new JLabel(name);
			label.setBackground(SystemColor.textHighlight);
			getContentPane().add(label, BorderLayout.NORTH);
		}
	}

}
