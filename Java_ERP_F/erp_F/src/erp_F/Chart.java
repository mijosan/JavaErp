package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;



public class Chart extends JPanel implements ActionListener{
	JButton shoes;
	JButton top;
	JButton bottom;
	MemberMgr mgr;
	 int[] count;
	 JFreeChart chart;
	 String type="����";
	 ChartPanel panel;
	 String[] typeName;
	public Chart() {
		mgr = new MemberMgr();
		
	    count = new int[10];
	    count = mgr.getTop();
	    typeName = new String[10];
	    typeName = mgr.getTopName();
	    
		chart = this.getChart();
	    panel = new ChartPanel(chart);
	    typeName = new String[10];
	    typeName = mgr.getTopName();
	    
		setLayout(new BorderLayout());
		panel.setSize(1000,1000);
		panel.setVisible(true);
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(3,1));
		shoes = new JButton("�Ź�");
		top = new JButton("����");
		bottom = new JButton("����");
		shoes.setBackground(Color.WHITE);
		shoes.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		top.setBackground(Color.WHITE);
		top.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		bottom.setBackground(Color.WHITE);
		bottom.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		
		shoes.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				shoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		top.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				top.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		bottom.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				bottom.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		btnPanel.add(top);
		btnPanel.add(bottom);
		btnPanel.add(shoes);
		shoes.addActionListener(this);
		top.addActionListener(this);
		bottom.addActionListener(this);
		add(btnPanel,BorderLayout.WEST);
		add(panel,BorderLayout.CENTER);
	}
	 

   

 public JFreeChart getChart() {

   

     // ������ ����

     DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1

     DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();         // bar chart 2

     DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();                // line chart 1

     //���� �� MGR
  

     
  
     // ������ �Է� ( ��, ����, ī�װ� )

     // �׷��� 1       
     
    	 
     dataset1.addValue(count[0], type, typeName[0]);

     dataset1.addValue(count[1], type, typeName[1]);

     dataset1.addValue(count[2], type, typeName[2]);

     dataset1.addValue(count[3], type, typeName[3]);

     dataset1.addValue(count[4], type, typeName[4]);

     dataset1.addValue(count[5], type, typeName[5]);

     dataset1.addValue(count[6], type, typeName[6]);

     dataset1.addValue(count[7], type, typeName[7]);

     dataset1.addValue(count[8], type, typeName[8]);

     dataset1.addValue(count[9], type, typeName[9]);



     // ������ ���� �� ����

     // ������ ����

     final BarRenderer renderer = new BarRenderer();

     final BarRenderer renderer12 = new BarRenderer();

     final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();

    

     // ���� �ɼ� ����

     final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

     final ItemLabelPosition p_center = new ItemLabelPosition(

             ItemLabelAnchor.CENTER, TextAnchor.CENTER

         );

     final ItemLabelPosition p_below = new ItemLabelPosition(

                  ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

                  );

     Font f = new Font("Gulim", Font.BOLD, 14);

     Font axisF = new Font("Gulim", Font.PLAIN, 14);

    

     // ������ ����

     // �׷��� 1

     renderer.setBaseItemLabelGenerator(generator);

     renderer.setBaseItemLabelsVisible(true);

     renderer.setBasePositiveItemLabelPosition(p_center);

     renderer.setBaseItemLabelFont(f);

//     renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//             GradientPaintTransformType.VERTICAL));

//     renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

     renderer.setSeriesPaint(0, new Color(51,153,255));



 /*    // �׷��� 2       

     renderer12.setSeriesPaint(0, new Color(232,168,255));

     renderer12.setBaseItemLabelFont(f);

     renderer12.setBasePositiveItemLabelPosition(p_center);

     renderer12.setBaseItemLabelGenerator(generator);

     renderer12.setBaseItemLabelsVisible(true);

    

     // �׷��� 3       

     renderer2.setBaseItemLabelGenerator(generator);

     renderer2.setBaseItemLabelsVisible(true);

     renderer2.setBaseShapesVisible(true);

     renderer2.setDrawOutlines(true);

     renderer2.setUseFillPaint(true);

     renderer2.setBaseFillPaint(Color.WHITE);

     renderer2.setBaseItemLabelFont(f);

     renderer2.setBasePositiveItemLabelPosition(p_below);

     renderer2.setSeriesPaint(0,new Color(219,121,22));

     renderer2.setSeriesStroke(0,new BasicStroke(

                                            2.0f,

                                            BasicStroke.CAP_ROUND,

                                            BasicStroke.JOIN_ROUND,

                                            3.0f)

     );*/

    

     // plot ����

     final CategoryPlot plot = new CategoryPlot();

    

     // plot �� ������ ����

     plot.setDataset(dataset1);

     plot.setRenderer(renderer);

     plot.setDataset(1,dataset12);

     plot.setRenderer(1,renderer12);

     plot.setDataset(2, dataset2);

     plot.setRenderer(2, renderer2);



     // plot �⺻ ����

     plot.setOrientation(PlotOrientation.VERTICAL);             // �׷��� ǥ�� ����

     plot.setRangeGridlinesVisible(true);                       // X�� ���̵� ���� ǥ�ÿ���

     plot.setDomainGridlinesVisible(true);                      // Y�� ���̵� ���� ǥ�ÿ���



     // ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )

     plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

    

     // X�� ����

     plot.setDomainAxis(new CategoryAxis());              // X�� ���� ����

     plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����

     plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // ī�װ� �� ��ġ ����



     // Y�� ����

     plot.setRangeAxis(new NumberAxis());                 // Y�� ���� ����

     plot.getRangeAxis().setTickLabelFont(axisF);  // Y�� ���ݶ� ��Ʈ ����

    

     // ���õ� plot�� �������� chart ����

     final JFreeChart chart = new JFreeChart(plot);

//     chart.setTitle("Overlaid Bar Chart"); // ��Ʈ Ÿ��Ʋ

//     TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//     copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//     chart.addSubtitle(copyright);  // ��Ʈ ���� Ÿ��Ʋ

     return chart;

 }




@Override
public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();
	if(obj==top) {
		type="����";
		count=mgr.getTop();
		typeName = mgr.getTopName();
		 chart = this.getChart();
		 
		 remove(panel);
		 panel = new ChartPanel(chart);
		 add(panel,BorderLayout.CENTER);
		 repaint();

	}else if(obj==bottom) {
		type="����";
		count=mgr.getBottom();
		typeName = mgr.getBottomName();
		chart = this.getChart();
		 
		remove(panel);
		 panel = new ChartPanel(chart);
		 add(panel,BorderLayout.CENTER);
		repaint();

	}else if(obj==shoes) {
		type="�Ź�";
		count=mgr.getShoes();
		typeName = mgr.getShoesName();
		chart = this.getChart();

		remove(panel);
	     panel = new ChartPanel(chart);
		 add(panel,BorderLayout.CENTER);
		repaint();

	}
}


}
