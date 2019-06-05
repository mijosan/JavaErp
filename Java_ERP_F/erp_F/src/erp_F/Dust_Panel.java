package erp_F;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;




public class Dust_Panel extends JFrame{
	
	ImageIcon image;
	
	public Dust_Panel() {
		setTitle("미세먼지 농도");
		setBounds(100, 100, 310, 284);

		try {
			int dust = this.sendGet();

			if(dust > 150) {
				image = new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\4.PNG");
			}else if(dust > 80) {
				image = new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\3.PNG");
			}else if(dust > 30) {
				image = new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\2.PNG");
			}else if(dust > 0) {
				image = new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\1.PNG");
			}else {
				image = new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\1.PNG");
			}
			setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			
			JLabel label = new JLabel(image);
			label.setBounds(0, 0, 300, 250);
			
			JLabel label_2;
			
			label_2 = new JLabel("오늘의 미세먼지 농도 : "+ dust +" ㎍/m³");
			label_2.setForeground(Color.WHITE);
			label_2.setBounds(57,0,211,30);
			getContentPane().add(label_2);
			getContentPane().add(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public int sendGet() throws Exception{
		String url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?sidoName=%EB%B6%80%EC%82%B0&pageNo=1&numOfRows=10&ServiceKey=o3SDdqX70VKND9ehYU7%2Fg4wn8cz%2By%2BD5jmbMqoWanmwd%2FZtF8TzMw5qTADoKCOq8Doq%2FdnA1qvwaD2PFOIaUxw%3D%3D&ver=1.3";
		Node busan = null;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		int dust;
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "USER_AGENT");
		con.getResponseCode();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer result = new StringBuffer();
		String line;
		
		while((line = br.readLine()) != null) {
			result.append(line);
		}
		
//		System.out.println(result);
		
		br.close();
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
			
			FileOutputStream output = new FileOutputStream("C:/Java/myJava/erp_F/test.xml");
			output.write(result.toString().getBytes());
			output.close();
			
			Document doc = dbuilder.parse("C:/Java/myJava/erp_F/test.xml");
			doc.getDocumentElement().normalize();
			
			Element response = (Element) doc.getElementsByTagName("response").item(0);
			Element body = (Element) response.getElementsByTagName("body").item(0);
			Element items = (Element) body.getElementsByTagName("items").item(0);
			Element item = (Element) items.getElementsByTagName("item").item(3);
			busan = item.getElementsByTagName("pm10Value").item(0);
			return dust = Integer.parseInt(busan.getChildNodes().item(0).getNodeValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
}
