/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * --------------------
 * PieChart3DDemo1.java
 * --------------------
 * (C) Copyright 2002-2004, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: PieChart3DDemo1.java,v 1.8 2004/04/26 19:12:00 taqua Exp $
 *
 * Changes
 * -------
 * 19-Jun-2002 : Version 1 (DG);
 * 31-Jul-2002 : Updated with changes to Pie3DPlot class (DG);
 * 11-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 23-Dec-2003 : Renamed Pie3DChartDemo1 --> PieChart3DDemo1 (DG);
 *
 */

package erp_F;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;

/**
 * A simple demonstration application showing how to create a pie chart using data from a
 * {@link DefaultPieDataset}.
 *
 */
public class EmployeepieChart extends JPanel {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public EmployeepieChart(final String title) {

       

        // create a dataset...
        final PieDataset dataset = createSampleDataset();
        
        // create the chart...
        final JFreeChart chart = createChart(dataset);
        
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 660));
        chartPanel.setBackground(Color.WHITE);
        add(chartPanel);
        
    }
    
    /**
     * Creates a sample dataset for the demo.
     * 
     * @return A sample dataset.
     */
    private PieDataset createSampleDataset() {
        MemberMgr mgr = new MemberMgr();
        Vector<ChartBean> elist;
        elist = mgr.getNCQ();
       
        final DefaultPieDataset result = new DefaultPieDataset();
        for (int i = 0; i < elist.size(); i++) {
			ChartBean bean = new ChartBean();
			bean = elist.get(i);			
			result.setValue(bean.getName(), new Integer(bean.getCount()));
        } 
        
        return result;        
    }
    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return A chart.
     */
    private JFreeChart createChart(final PieDataset dataset) {
        
        final JFreeChart chart = ChartFactory.createPieChart3D(
            "Á÷¿øº° ÆÇ¸Å ÇöÈ²",  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );
        chart.getTitle().setFont(new Font("µ¸¿ò",Font.BOLD,18));;
        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
       
        chart.getLegend().setItemFont(new Font("µ¸¿ò",Font.PLAIN,14));
       /* Border emptyBorder = BorderFactory.createEmptyBorder();
        chart.getLegend().setBorder(0, 0, 0, 0);*/
       
        plot.setLabelFont(new Font("µ¸¿ò",Font.PLAIN,13));
        plot.setStartAngle(290);
        plot.setBackgroundPaint(null);
        
       // plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("No data to display");
        return chart;
        
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.     */ 

}