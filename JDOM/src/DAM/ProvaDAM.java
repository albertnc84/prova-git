package DAM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ProvaDAM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	writeXML();
	readXML();
		
	}
		public static void writeXML() {
			
			Document doc = new Document();
			
			Element pare = new Element("Institud");
			doc.setRootElement(pare);
			
			Element curs = new Element("Curs");			
			Element alumne = new Element("Alumne");
			Element nom = new Element ("Nom");
			Element any = new Element ("Any");
			
			
			curs.setAttribute("Nom", "DAM1");
			nom.addContent(new Text("Albert"));
			any.addContent(new Text("1984"));
			alumne.setAttribute("DNI","78092024D");
			
			pare.addContent(curs);
			curs.addContent(alumne);			
			alumne.addContent(nom);
			
			alumne.addContent(any);
			
			//Nou alumne
			
			Element alumne2 = new Element("Alumne");		
			Element nom2 = new Element ("Nom");		
			Element any2 = new Element ("Any");		
			Element dni2 = new Element ("DNI");
			
			nom2.addContent(new Text("Joel"));
			any2.addContent(new Text("1994"));
			alumne2.setAttribute("DNI","78092024D");
			
			
			
			curs.addContent(alumne2);
			alumne2.addContent(nom2);
			alumne2.addContent(any2);
			
			
			//Nou Curs
			
			Element curs2 = new Element("Curs");
			Element alumne3 = new Element("Alumne");		
			Element nom3 = new Element ("Nom");		
			Element any3 = new Element ("Any");		
			Element dni3 = new Element ("DNI");
			
			curs2.setAttribute("Nom", "ASIX");
			
			nom3.addContent(new Text("Paquito"));
			any3.addContent(new Text("1974"));
			alumne3.setAttribute("DNI","78092024D");
			
			pare.addContent(curs2);
			curs2.addContent(alumne3);			
			alumne3.addContent(nom3);
			alumne3.addContent(any3);
			
			
					
			XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
			try {
				xmlOutput.output(doc, new FileOutputStream ( new File ("alumne.xml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Fitxer fet!");
		}


				
		public static void readXML(){

			
				SAXBuilder builder = new SAXBuilder();
				
				File xmlFile = new File ("alumne.xml");
				
				try{
					
					//Es crea un documet a traves del arxiu xmlFile
					
					Document document = builder.build(xmlFile);
					
					//obtenim l'arrel, és un elemet
					
					Element rootNode = document.getRootElement();
					
					//s'obté la llista dels fills del root
					
					List list = rootNode.getChildren();
					
					//Recorrem els fills
					
					for (int i=0; i< list.size(); i++){
						
				
						//s'obté els elements taula
						
						Element tabla = (Element) list.get(i);
						
						String nomCurs = tabla.getAttributeValue("Nom");		
						
						
						System.out.println("Curs: "+ nomCurs);
						
						//com obtenim els fills del tag tabla? doncs un altre for
						
						
						List llista_camps = tabla.getChildren();
						
												
						//Es recorre la llista de camps
						
						for (int j=0; j< llista_camps.size(); j++){
							
													
							Element camp= (Element) llista_camps.get(j);
							
							String dniAlumne = camp.getAttributeValue("DNI");
							System.out.println("DNI Alumne: "+ dniAlumne);

							//S'obtenen els valors que estan entre els tags <campo></campo>
							//S'obtenen el valor que esta entre els tags <nombre></nombre>
							
							
							
							String nom = camp.getChildText("Nom");
							
							
							String any = camp.getChildText("Any");
							
							
							//S'obtenen el valor que esta entre els tags <valor></valor>
								
							
							System.out.println("Nom de l'alumne "+nom+ "\t Any de naixement "+any);
													
					} 
					}
				}catch (IOException | JDOMException e) {
						
						System.out.println (e.getMessage());
					}
				
					System.out.println("XML Llegit");


					}
				
				
		}
			



