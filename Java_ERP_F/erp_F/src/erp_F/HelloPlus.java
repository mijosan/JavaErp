package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class HelloPlus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable plus;
	static DefaultTableModel table;
	MemberMgr mgr;
	//TblemployeeBean bean;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HelloPlus dialog = new HelloPlus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HelloPlus() {
		mgr = new MemberMgr();
		setTitle("인사 추가");
		setBounds(100, 100, 600, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
			
		String[] row = {"사번","성명","생년월일","주민번호","부서","직급","입사일자","E-mail","계좌"};
		String[][] col = new String[1][0];
		
		table = new DefaultTableModel(col, row);
		
		setPreferredSize(new Dimension(980, 525));
		
		plus = new JTable();
		plus.setModel(table);
		add(new JScrollPane(plus), BorderLayout.CENTER);
	
	
		JPanel buttonPane = new JPanel();
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			final JButton okButton = new JButton("확인");
			okButton.setBackground(Color.WHITE);
			okButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
			//okButton.setActionCommand("OK");
			
			okButton.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
				}
			});
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						mgr.setHRTable(mgr.HelloPlus());	//bean에 넣고 테이블에 뿌림
						mgr.setHRList(mgr.HelloPlus()); 	//bean을 DB에 저장
						setVisible(false);
						dispose();
										
				}
			});
			
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			final JButton cancelButton = new JButton("취소");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
			//cancelButton.setActionCommand("Cancel");
			cancelButton.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
				}
			});
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			buttonPane.add(cancelButton);
		}
		
	}

}
