package jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class jdom_prova2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		llegirXML();


		}


		public static void llegirXML(){
			
			// Es crea un SAXBuilder per poder parsejar l'arxiu
			

			SAXBuilder builder = new SAXBuilder();
			
			File xmlFile = new File ("prova2.xml");
			
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
					
					String nomTaula = tabla.getAttributeValue("nombre");
					
					System.out.println("Taula: "+ nomTaula);
					
					//com obtenim els fills del tag tabla? doncs un altre for
					
					List llista_camps = tabla.getChildren();
					
					System.out.println("\t Nom \t \t tipus \t \t Valor");
					
					//Es recorre la llista de camps
					
					for (int j=0; j< llista_camps.size(); j++){
					
						Element camp= (Element) llista_camps.get(j);

						//S'obtenen els valors que estan entre els tags <campo></campo>
						//S'obtenen el valor que esta entre els tags <nombre></nombre>
						
						String nom = camp.getChildText("nombre");
						
						
						String tipus = camp.getChildText("tipo");
						
						
						//S'obtenen el valor que esta entre els tags <valor></valor>
							
						String valor = camp.getChildText("valor");
						
						System.out.println("\t"+nom+ "\t \t"+tipus+"\t \t"+valor);
						
					}
						
					}
					
				
			
						
			} catch (IOException | JDOMException e) {
				
				System.out.println (e.getMessage());
			}
		
			System.out.println("XML Llegit");

		}

		
	}
		


	


