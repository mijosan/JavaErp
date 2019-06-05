package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class WriteNotice extends JDialog  implements ActionListener{
	JTextField textField;
	JButton okButton;
	JButton cancelButton;
	JTextArea textArea;
	JButton btnNewButton;
	FileDialog fileDialog;
	Base64 base64;
	String imageName;
	MemberMgr mgr;
	public WriteNotice() {
		mgr = new MemberMgr();
		base64 = new Base64();
		fileDialog = new FileDialog(this, "파일 열기",  FileDialog.LOAD);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("공지사항 작성");
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.textHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("\uC791\uC131");
				okButton.setActionCommand("작성");
				okButton.setBackground(Color.WHITE);
				okButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
				okButton.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
				cancelButton.setActionCommand("취소");
				cancelButton.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.textHighlight);
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				textField = new JTextField();
				panel.add(textField, BorderLayout.CENTER);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("          \uC81C\uBAA9          ");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel, BorderLayout.WEST);
			}
			{
				btnNewButton = new JButton();
				btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
				btnNewButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton.setIcon(new ImageIcon("C:\\Java\\myJava\\erp_F_images\\save.png"));
				btnNewButton.setMargin(new Insets(0, 0, 0, 0));
				Border emptyBorder = BorderFactory.createEmptyBorder();
				btnNewButton.setBorder(emptyBorder);
				btnNewButton.addActionListener(this);
				
				btnNewButton.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						btnNewButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				panel.add(btnNewButton, BorderLayout.EAST);
			}
		}
		{
			textArea = new JTextArea();
			textArea.setRows(20);
			getContentPane().add(textArea, BorderLayout.CENTER);
		}
		//액션 등록
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setBounds(400, 100, 400, 260);
		JScrollPane scroll = new JScrollPane(textArea);
		getContentPane().add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==okButton) {
			MemberMgr mgr = new MemberMgr();
			if(imageName!=null) {
				base64.writeImg(mgr.getNoticeNum()+1,imageName);
			}
			mgr.setNotice(textField.getText(), textArea.getText());
			Date d = new Date();
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			NoticeBoard.extable.addRow(new Object[] {mgr.getTitle(),First_Frame.name,sdf.format(d)});
			DefaultTableModel dm = (DefaultTableModel)NoticeBoard.table.getModel();
			while(dm.getRowCount() > 0)
			{
			    dm.removeRow(0);
			}
			mgr.getTitleList();
	
			this.setVisible(false);
		}else if(obj==cancelButton) {
			this.setVisible(false);
		}else if(obj==btnNewButton) {
			fileDialog.setVisible(true);
			imageName = fileDialog.getDirectory()+fileDialog.getFile();
		}
	}

}
