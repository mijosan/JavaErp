package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Function_1 extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	@Override
	public void run() {
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Function_1 frame = new Function_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Function_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("LOGO");
		panel_4.add(btnNewButton, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("                                                                               TIME");
		panel_4.add(lblNewLabel, BorderLayout.EAST);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                                       ");
		panel_4.add(lblNewLabel_1, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.textHighlight);
		panel.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("\uC778\uC0AC/\uAE09\uC5EC \uAD00\uB9AC");
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0DD\uC0B0/\uC7AC\uACE0 \uAD00\uB9AC");
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uC601\uC5C5/\uAD6C\uB9E4 \uAD00\uB9AC");
		panel_5.add(btnNewButton_3);
		
		JLabel label = new JLabel("                             \uBD80\uC11C : ");
		panel_5.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("\uC778\uC0AC\uBD80");
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("       \uC774\uB984 : ");
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uCD5C\uD0DC\uC0B0 \uB2D8     ");
		panel_5.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		panel_5.add(btnNewButton_4);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("ERP_F") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("인사/급여 관리");
						node_1.add(new DefaultMutableTreeNode("인사기초"));
						node_1.add(new DefaultMutableTreeNode("급여계산"));
						node_1.add(new DefaultMutableTreeNode("상여지급"));
						node_1.add(new DefaultMutableTreeNode("퇴직정산"));
						node_1.add(new DefaultMutableTreeNode("증명관리"));
					add(node_1);
				}
			}
		));
		contentPane.add(tree, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("\uC778\uC0AC\uAE30\uCD08");
		panel_1.add(label_1, BorderLayout.NORTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "003", "\uD64D\uAE38\uC21C", "999999", "\uC601\uC5C5\uD300", "\uACFC\uC7A5", "2015/08/23", "wdwqdqwd", "1111111"},
				{null, "005", "\uC774\uD604\uAD6C", "1111111", "\uC601\uC5C5\uD300", "\uC0AC\uC6D0", "2010/09/23", "awdwdwd", "111122"},
				{null, "006", "\uD64D\uAE38\uB3D9", "222222", "\uC778\uC0AC\uD300", "\uB300\uB9AC", "2011/11/26", "wdwdwd", null},
			},
			new String[] {
				" .", "\uC0AC\uBC88", "\uC131\uBA85", "\uC0DD\uB144\uC6D4\uC77C", "\uBD80\uC11C", "\uC9C1\uAE09", "\uC785\uC0AC\uC77C\uC790", "E-MAIL", "\uACC4\uC88C"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, Object.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panel_1.add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
