package DAM;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class modificarProvaDam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner llegir = new Scanner (System.in);

		 try {
			 
				SAXBuilder builder = new SAXBuilder();
				File xmlFile = new File("alumne.xml");
		 
				Document doc = (Document) builder.build(xmlFile);
				Element rootNode = doc.getRootElement();
		 
				// update staff id attribute
				Element pare = rootNode;
				
				Element curs = new Element("Curs");			
				Element alumne = new Element("Alumne");
				Element nom = new Element ("Nom");
				Element any = new Element ("Any");
				
				
				Element alumne2 = new Element("Alumne");
				Element nom2 = new Element ("Nom");
				Element any2 = new Element ("Any");
				
				curs.setAttribute("Nom", "SMX");
				nom.addContent(new Text("Anton"));
				any.addContent(new Text("1991"));
				alumne.setAttribute("DNI","12092029t");
				
				pare.addContent(curs);
				
				curs.addContent(alumne);			
				alumne.addContent(nom);
				alumne.addContent(any);
				
				nom2.addContent(new Text("Pepa"));
				any2.addContent(new Text("1979"));
				alumne2.setAttribute("DNI","65325029v");
				
				curs.addContent(alumne2);			
				alumne2.addContent(nom2);
				alumne2.addContent(any2);
				
				
				
				
				List list = rootNode.getChildren();
				
				for (int i=0; i< list.size(); i++){		
					
					Element cursos = (Element) list.get(i);
					List llista_curs = cursos.getChildren();
					System.out.println(cursos.getAttributeValue("Nom"));
					
					if (cursos.getAttributeValue("Nom").equals("ASIX")){
						
						Element alumne3 = new Element("Alumne");
						Element nom3 = new Element ("Nom");
						Element any3 = new Element ("Any");
						
						System.out.println("posa el nom:");
						nom3.addContent(llegir.next());
						any3.addContent(new Text("1995"));
						alumne3.setAttribute("DNI","11325029R");
						
												
						cursos.addContent(alumne3);		
						alumne3.addContent(nom3);
						alumne3.addContent(any3);
						
					}
					
					for (int j=0; j< llista_curs.size(); j++){	
						
					Element alum = (Element) llista_curs.get(j);
					
					
					Element email = new Element("Email");
					email.addContent(new Text("elseucorreu@gmail.com"));
					alum.addContent(email);
					
					if (alum.getChildText("Nom").equals("Albert")){
					alum.getChild("Email").setText("albertnc84@gmail.com");
					
					}
					}
				
				}
				
			
		 
				XMLOutputter xmlOutput = new XMLOutputter();
		 
				// display nice nice
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter("alumne.xml"));
		 
				// xmlOutput.output(doc, System.out);
		 
				System.out.println("Fitxer actualitzat!");
			  } catch (IOException io) {
				io.printStackTrace();
			  } catch (JDOMException e) {
				e.printStackTrace();
			  }
			}
		}
		
	


