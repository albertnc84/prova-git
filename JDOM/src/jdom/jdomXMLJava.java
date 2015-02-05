package jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class jdomXMLJava {

	public static void main (String[] args ){
		
		writeXML();
		
		readXML();


		}

		
	public static void readXML(){

	try{
	SAXBuilder builder = new SAXBuilder();
		
		Document readDoc = builder.build(new File("prova.xml"));
		System.out.println("El root es" + readDoc.getRootElement());
		System.out.println("Show"+ readDoc.getRootElement().getChild("show").getChildText("name"));
		System.out.println("Show ID"+ 
				
				
		readDoc.getRootElement().getChild("show").getChild("name").getAttributeValue("show id"));
		
		
		Element root = readDoc.getRootElement();
		
		List list = root.getChildren("show");
		
		System.out.println("prova"+ list.size());
		
		for (int i=0; i < list.size(); i++){
			
			Element field = (Element)list.get(i);
			
		String name= field.getChildText("name");
		String network= field.getChildText("network");
		
		System.out.println( "\t"+name+"\t\t"+network);
			
		}

		
		} catch(JDOMException | IOException e){
				
			e.printStackTrace();
			
		}

		

	}
		

		
	public static void writeXML() {
		
		
		Document doc = new Document();
		Element theRoot = new Element("tvshows");
		doc.setRootElement(theRoot);
		
		Element show = new Element ("show");
		Element name = new Element ("name");
		
		name.setAttribute("show_id", "show_001");
		
		name.addContent (new Text ("Dragon Ball"));
		
		
		Element network = new Element ("network");
		network.setAttribute("country", "SPA");
		
		network.addContent(new Text("TV3"));
		
		show.addContent(name);
		show.addContent(network);
		
		
		theRoot.addContent(show);
		
		//segon tvshow
		
		
		Element show2 = new Element ("show");
		Element name2 = new Element ("name");
		
		name2.setAttribute("show_id", "show_001");
		
		name2.addContent (new Text ("Dragon Ball"));
		
		
		Element network2 = new Element ("network");
		
		network2.setAttribute("country", "EEUU");
		network2.addContent(new Text("CNN"));
		
		show2.addContent(name2);
		show2.addContent(network2);
		
		
		theRoot.addContent(show2);
		
		
		Element show3 = new Element ("show");
		Element name3 = new Element ("name");
		
		name3.setAttribute("show_id", "show_002");
		
		name3.addContent (new Text ("Dragon Ball"));
		
		
		Element network3 = new Element ("network");
		
		network3.setAttribute("country", "EEUU");
		network3.addContent(new Text("Antena3"));
		
		show3.addContent(name3);
		show3.addContent(network3);
		
		
		theRoot.addContent(show3);
		
		
		
		
		
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, new FileOutputStream ( new File ("prova.xml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fitxer fet!");
		
		}
		
		
	}