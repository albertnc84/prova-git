package examen_m6;

import java.io.File;
import java.io.FileOutputStream;
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

public class Employees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner llegir = new Scanner (System.in);
		
		writeXML();
		
		System.out.println("Tria una opció: ");
		System.out.println("1. Llegir Fitxer ");
		System.out.println("2. Modificar Camps ");
		System.out.println("3. Afegir Treballador a Guissona");
		System.out.println("4. Afegir Treballador a Mainada");
		System.out.println("5. Guardar info dels treballadors");
		
		int opcio = llegir.nextInt();
		
		switch (opcio)
		{
		case 1:
		
		
		readXML();	
		
		break;
		
		case 2:
			modificarXML();
			
		break;
		
		
		case 3:
			
			modificarGuissonaXML();
		
		break;
			
		case 4:
			
			modificarMainadaXML();
			
		break;
		
		}
	}
	
	public static void writeXML() {
		
		Document doc = new Document();
		
		Element pare = new Element("Employees");
		doc.setRootElement(pare);
		
		Element company = new Element("Company");
		Element company2 = new Element("Company");
		
		pare.addContent(company);
		pare.addContent(company2);
		
		company.setAttribute("id", "Guissona");
		company2.setAttribute("id", "Mainada");
		
		
		Element employee1 = new Element("Employee");
		Element employee2 = new Element("Employee");
		Element employee3 = new Element("Employee");
		Element employee4 = new Element("Employee");
		
		company.addContent(employee1);
		company.addContent(employee2);
		company.addContent(employee3);
		
		company2.addContent(employee4);
		
		employee1.setAttribute("id", "1");
		employee2.setAttribute("id", "2");
		employee3.setAttribute("id", "3");
		
		employee4.setAttribute("id", "1");
		
		Element age1 = new Element("age");
		Element name1 = new Element("name");
		Element lastname1 = new Element("lastname");
		Element gender1 = new Element("gender");
		Element role1 = new Element("role");
		
		employee1.addContent(age1);
		employee1.addContent(name1);
		employee1.addContent(lastname1);
		employee1.addContent(gender1);
		employee1.addContent(role1);
		
		age1.addContent(new Text("28"));
		name1.addContent(new Text("Xavier"));
		lastname1.addContent(new Text("Timoneda"));
		gender1.addContent(new Text("Male"));
		role1.addContent(new Text("Java Script Developer"));
		
		
		
		Element age2 = new Element("age");
		Element name2 = new Element("name");
		Element lastname2 = new Element("lastname");
		Element gender2 = new Element("gender");
		Element role2 = new Element("role");
		
		employee2.addContent(age2);
		employee2.addContent(name2);
		employee2.addContent(lastname2);
		employee2.addContent(gender2);
		employee2.addContent(role2);
		
		age2.addContent(new Text("28"));
		name2.addContent(new Text("Josep"));
		lastname2.addContent(new Text("Sala"));
		gender2.addContent(new Text("Male"));
		role2.addContent(new Text("DBA"));
		
		
		
		Element age3 = new Element("age");
		Element name3 = new Element("name");
		Element lastname3 = new Element("lastname");
		Element gender3 = new Element("gender");
		Element role3 = new Element("role");
				
		employee3.addContent(age3);
		employee3.addContent(name3);
		employee3.addContent(lastname3);
		employee3.addContent(gender3);
		employee3.addContent(role3);
		
		age3.addContent(new Text("21"));
		name3.addContent(new Text("Adrià"));
		lastname3.addContent(new Text("Orellana"));
		gender3.addContent(new Text("Male"));
		role3.addContent(new Text("Java Developer"));
		
		
		
		Element age4 = new Element("age");
		Element name4 = new Element("name");
		Element lastname4 = new Element("lastname");
		Element gender4 = new Element("gender");
		Element role4 = new Element("role");
		
		employee4.addContent(age4);
		employee4.addContent(name4);
		employee4.addContent(lastname4);
		employee4.addContent(gender4);
		employee4.addContent(role4);
		
		age4.addContent(new Text("21"));
		name4.addContent(new Text("David"));
		lastname4.addContent(new Text("Llordés"));
		gender4.addContent(new Text("Male"));
		role4.addContent(new Text("PHP developer"));
		
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		try {
			
			xmlOutput.output(doc, new FileOutputStream ( new File ("examen.xml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fitxer fet!");
	}

		
	public static void readXML(){

		
		SAXBuilder builder = new SAXBuilder();
		
		File xmlFile = new File ("examen.xml");
		
		try{
			
				
			Document document = builder.build(xmlFile);
			
			Element rootNode = document.getRootElement();
			
			List list = rootNode.getChildren();
			
			for (int i=0; i< list.size(); i++){
				
						
				Element tabla = (Element) list.get(i);
				
				String nomCurs = tabla.getAttributeValue("id");		
				
				
				System.out.println("Empresa: "+ nomCurs);
				
							
				List llista_camps = tabla.getChildren();
				
								
				for (int j=0; j< llista_camps.size(); j++){
					
											
					Element camp= (Element) llista_camps.get(j);
					
					String idEmployee = camp.getAttributeValue("id");
					System.out.println("id:  "+ idEmployee);

						
					String age = camp.getChildText("age");
										
					String name = camp.getChildText("name");
					String lastname = camp.getChildText("lastname");
					String gender = camp.getChildText("gender");
					String role = camp.getChildText("role");
								
					
					System.out.println("Nom: "+name+ " Cognom: "+lastname +" Edat: " +age+ " Sexe: "+gender+" Rol: "+role);
											
			} 
			}
		}catch (IOException | JDOMException e) {
				
				System.out.println (e.getMessage());
			}
		
			System.out.println("XML Llegit");


			}

		
	public static void modificarGuissonaXML(){
		
		Scanner llegir = new Scanner (System.in);
		try {
			
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("examen.xml");
 
		Document doc = (Document) builder.build(xmlFile);
		Element rootNode = doc.getRootElement();
 
		Element pare = rootNode;
		
		List list = rootNode.getChildren();
		
		
	
	for (int i=0; i< list.size(); i++){	
		
		
		Element company = (Element) list.get(i);
	
		if (company.getAttributeValue("id").equals("Guissona")){
			
						
			Element employee = new Element("Employee");
			Element age = new Element("age");
			Element name = new Element("name");
			Element lastname = new Element("lastname");
			Element gender = new Element("gender");
			Element role = new Element("role");
			employee.setAttribute("id", "2");
			
			company.addContent(employee);
			employee.addContent(age);
			employee.addContent(name);
			employee.addContent(lastname);
			employee.addContent(gender);
			employee.addContent(role);
			
			System.out.println("Afegeix un nou empleat");
			System.out.println("Introdueix l'edat:");
			age.addContent(llegir.next());
			System.out.println("Introdueix el nom:");
			name.addContent(llegir.next());		
			System.out.println("Introdueix el cognom");
			lastname.addContent(llegir.next());
			System.out.println("Introdueix el Sexe:");
			gender.addContent(llegir.next());
			System.out.println("Introdueix el rol:");
			role.addContent(llegir.next());
			
		}
	}
		
		XMLOutputter xmlOutput = new XMLOutputter();		
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("examen.xml"));
 
		System.out.println("Fitxer actualitzat!");
	  } catch (IOException io) {
		io.printStackTrace();
	  } catch (JDOMException e) {
		e.printStackTrace();
	  }
	}
	
	public static void modificarMainadaXML(){
		
		Scanner llegir = new Scanner (System.in);
		
		try {
			
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("examen.xml");
 
		Document doc = (Document) builder.build(xmlFile);
		Element rootNode = doc.getRootElement();
 
		Element pare = rootNode;
		
		List list = pare.getChildren();
		
		
	
	for (int i=0; i< list.size(); i++){	
		
		
		Element company = (Element) list.get(i);
	
		if (company.getAttributeValue("id").equals("Mainada")){
			
			Element employee = new Element("Employee");
			Element age = new Element("age");
			Element name = new Element("name");
			Element lastname = new Element("lastname");
			Element gender = new Element("gender");
			Element role = new Element("role");
			employee.setAttribute("id", "4");
			
			company.addContent(employee);
			employee.addContent(age);
			employee.addContent(name);
			employee.addContent(lastname);
			employee.addContent(gender);
			employee.addContent(role);
			
			System.out.println("Afegeix un nou empleat");
			System.out.println("Introdueix l'edat: ");
			age.addContent(llegir.next());
			System.out.println("Introdueix el nom: ");
			name.addContent(llegir.next());		
			System.out.println("Introdueix el cognom: ");
			lastname.addContent(llegir.next());
			System.out.println("Introdueix el Sexe: ");
			gender.addContent(llegir.next());
			System.out.println("Introdueix el rol: ");
			role.addContent(llegir.next());
		}
	}
		
		XMLOutputter xmlOutput = new XMLOutputter();		
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("examen.xml"));
 
		System.out.println("Fitxer actualitzat!");
	  } catch (IOException io) {
		io.printStackTrace();
	  } catch (JDOMException e) {
		e.printStackTrace();
	  }
	}


	
	
	public static void modificarXML(){
		
		Scanner llegir = new Scanner (System.in);
		try {
			
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("examen.xml");
 
		Document doc = (Document) builder.build(xmlFile);
		Element rootNode = doc.getRootElement();
 
		Element pare = rootNode;
		
		List list = rootNode.getChildren();
		
		
	
	for (int i=0; i< list.size(); i++){			
		
		Element company = (Element) list.get(i);
		List llista_curs = company.getChildren();
		
		for (int j=0; j< llista_curs.size(); j++){	
			
			Element alum = (Element) llista_curs.get(j);
			
			
			alum.getChildText("name").toUpperCase();
		
			if (alum.getChildText("gender").equals("Male")){
				
				alum.getChild("gender").setText("M");
			}
			if (alum.getChildText("gender").equals("Female")){
				
				alum.getChild("gender").setText("F");
			}
		Element salari = new Element("Salari");
		alum.addContent(salari);
		salari.addContent(new Text("1800"));
			
	}
	
	}
	
	XMLOutputter xmlOutput = new XMLOutputter();		
	xmlOutput.setFormat(Format.getPrettyFormat());
	xmlOutput.output(doc, new FileWriter("examen.xml"));

	System.out.println("Fitxer actualitzat!");
  } catch (IOException io) {
	io.printStackTrace();
  } catch (JDOMException e) {
	e.printStackTrace();
  }
}
}
	
	
		
	

	
