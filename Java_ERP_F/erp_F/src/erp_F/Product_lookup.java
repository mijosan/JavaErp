package erp_F;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Product_lookup extends JPanel implements ActionListener{

	JTable table;
	DefaultTableModel hrTable;
	Pay_Panel_Plus pay_Plus;
	MemberMgr mgr;
	JButton searchButton;
	TextField textField;
	public Product_lookup() {
		mgr = new MemberMgr();
		//setPreferredSize(new Dimension(980, 525));
		String[] row = {"제품번호","제품이름","제품수량","제품단가","제품창고","생산날짜"};
		String[][] col = new String[0][0];
		hrTable = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 10, 1283, 735);
		panel.setBackground(Color.WHITE);
		add(panel);
		table = new JTable();
		table.setModel(hrTable);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 1283, 714);
		panel.add(scrollPane);
		panel.setPreferredSize(new Dimension(1283, 700));
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1283, 35);
		panel.add(panel_1);
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.setBounds(245, 6, 69, 25);
		searchButton.setBackground(Color.WHITE);
		searchButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
	
		panel_1.setLayout(null);
		JPanel panelB = new JPanel();
		panelB.setBounds(969, 0, 314, 35);
		panelB.setLayout(null);
		
		textField = new TextField();
		textField.setBounds(99, 8, 140, 23);
		panelB.add(textField);
		panelB.add(searchButton);
		panel_1.add(panelB);
		
		JLabel lblNewLabel = new JLabel("\uC0DD\uC0B0\uAD00\uB9AC\r\n\r\n\uC870\uD68C");
		lblNewLabel.setBounds(0, 0, 121, 35);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		textField.addActionListener(this);
		
		searchButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		searchButton.addActionListener(this);
		
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchButton || e.getSource()==textField) {
			for(int i = 0; i<table.getRowCount();i++) {
				hrTable.removeRow(i);
			}
			for(int i = 0; i<table.getRowCount();i++) {
				hrTable.removeRow(i);
			}
			for(int i = 0; i<table.getRowCount();i++) {
				hrTable.removeRow(i);
			}
			for(int i = 0; i<table.getRowCount();i++) {
				hrTable.removeRow(i);
			}
			if(isInteger(textField.getText())) {
			mgr.searchNum(hrTable,Integer.parseInt(textField.getText()));
			}else {
				SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyyMMdd");
				try{
					dateFormatParser.parse(textField.getText());
					mgr.searchDate(hrTable,textField.getText());
				}catch(Exception Ex)
				{
					mgr.searchName(hrTable,textField.getText());
				}		
			}
			textField.setText("");
			textField.requestFocus();
			}
	}

}
