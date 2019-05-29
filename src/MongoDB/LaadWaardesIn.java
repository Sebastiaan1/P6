package MongoDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

//Importeer de benodigdheden voor MongoDB.
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class LaadWaardesIn {
	
	public List<Document> laadReizigerEnAdresIn()
	{
		//Maak reiziger documenten aan met verschillende waardes.
		//Het adres is een 1 op veel relatie, hierdoor worden alle adressen als aparte documenten gemaakt en in een array gezet.
		Document reiziger1 = new Document("reizigerID", 1)
                .append("voorletters", "G")
                .append("tussenvoegsel", "van")
                .append("achternaam", "Rijn")
                .append("geboortedatum", "17-09-2002")
                .append("adres", Arrays.asList
                		(new Document("adresID", 1)
                		.append("postcode", "3511 LX")
                		.append("huisnummer", "37")
                		.append("straat", "Visschersplein")
                		.append("woonplaats", "Utrecht")
                		.append("reizigerID", 1)));
		
		Document reiziger2 = new Document("reizigerID", 2)
                .append("voorletters", "B")
                .append("tussenvoegsel", "van")
                .append("achternaam", "Rijn")
                .append("geboortedatum", "22-10-2002")
                .append("adres", Arrays.asList
                		(new Document("adresID", 1)
                		.append("postcode", "3511 LX")
                		.append("huisnummer", "37")
                		.append("straat", "Visschersplein")
                		.append("woonplaats", "Utrecht"), 
	                		new Document("adresID", 2)
	                        .append("postcode", "3521 AL")
	                        .append("huisnummer", "6A")
	                        .append("straat", "Jaarbeursplein")
	                        .append("woonplaats", "Utrecht")));
		
		Document reiziger3 = new Document("reizigerID", 3)
                .append("voorletters", "G")
                .append("tussenvoegsel", null)
                .append("achternaam", "Lubben")
                .append("geboortedatum", "11-08-1998")
        		.append("adres", Arrays.asList
                		(new Document("adresID", 4)
                        .append("postcode", "6707 AA")
                        .append("huisnummer", 375)
                        .append("straat", "Stadsbrink")
                        .append("woonplaats", "Wageningen")));
		
		Document reiziger4 = new Document("reizigerID", 4)
                .append("voorletters", "F")
                .append("tussenvoegsel", null)
                .append("achternaam", "Memari")
                .append("geboortedatum", "03-12-2002")
                .append("adres", Arrays.asList
                		(new Document("adresID", 5)
		                .append("postcode", "3817 CH")
		                .append("huisnummer", 4)
		                .append("straat", "Arnhemseweg")
		                .append("woonplaats", "Amersfoort")));
		
		Document reiziger5 = new Document("reizigerID", 5)
                .append("voorletters", "G")
                .append("tussenvoegsel", null)
                .append("achternaam", "Piccardo")
                .append("geboortedatum", "03-12-2002")
                .append("adres", Arrays.asList
                		(new Document("adresID", 6)
		                .append("postcode", "3572 WP")
		                .append("huisnummer", 22)
		                .append("straat", "Vermeulenstraat ")
		                .append("woonplaats", "Utrecht")));
		
		//Maak de array aan en voeg de documenten 1 voor 1 toe.
		List<Document> documents = new ArrayList<>();
		documents.add(reiziger1);
		documents.add(reiziger2);
		documents.add(reiziger3);
		documents.add(reiziger4);
		documents.add(reiziger5);
		
		//Return de array.
		return documents;
	}
	
	public List<Document> laadKaartenIn()
	{
		//Maak OV-chipkaart documenten aan met verschillende waardes.
		//Het product is een veel op veel relatie, hierdoor worden er aparte documenten gemaakt met het productnummer, status en lastupdate en in een array gezet.
		Document kaart1 = new Document("kaartnummer", 35283)
                .append("geldigTot", "31-05-18")
                .append("klasse", 2)
                .append("saldo", 25.5)
                .append("product", Arrays.asList
                		(new Document("productnummer", 3)
		                .append("reisproductstatus", "actief")
		                .append("lastupdate", "31-05-2017"),
	                		new Document("productnummer", 1)
			                .append("reisproductstatus", "gekocht")
			                .append("lastupdate", "05-04-2018"),
				                new Document("productnummer", 2)
				                .append("reisproductstatus", "gekocht")
				                .append("lastupdate", "05-04-2018")));
		
		Document kaart2 = new Document("kaartnummer", 46392)
                .append("geldigTot", "31-05-17")
                .append("klasse", 2)
                .append("saldo", 5.5)
                .append("product", Arrays.asList
                		(new Document("productnummer", 3)
		                .append("reisproductstatus", "verlopen")
		                .append("lastupdate", "31-05-2017")));
		
		Document kaart3 = new Document("kaartnummer", 57401)
                .append("geldigTot", "31-05-15")
                .append("klasse", 2)
                .append("saldo", 0)
                .append("product", Arrays.asList());
		
		Document kaart4 = new Document("kaartnummer", 68514)
                .append("geldigTot", "31-03-20")
                .append("klasse", 1)
                .append("saldo", 2.5)
                .append("product", Arrays.asList
                		(new Document("productnummer", 6)
		                .append("reisproductstatus", "actief")
		                .append("lastupdate", "01-04-18")));
		
		Document kaart5 = new Document("kaartnummer", 79625)
                .append("geldigTot", "31-01-20")
                .append("klasse", 1)
                .append("saldo", 25.5)
                .append("product", Arrays.asList
                		(new Document("productnummer", 6)
		                .append("reisproductstatus", "actief")
		                .append("lastupdate", "01-02-18")));
		
		Document kaart6 = new Document("kaartnummer", 90537)
                .append("geldigTot", "31-12-19")
                .append("klasse", 2)
                .append("saldo", 20)
                .append("product", Arrays.asList
                		(new Document("productnummer", 3)
		                .append("reisproductstatus", "actief")
		                .append("lastupdate", "01-02-2018"),
	                		new Document("productnummer", 2)
			                .append("reisproductstatus", "gekocht")
			                .append("lastupdate", "14-04-2018")));
		
		Document kaart7 = new Document("kaartnummer", 18326)
                .append("geldigTot", "31-05-18")
                .append("klasse", 2)
                .append("saldo", 25.5)
                .append("product", Arrays.asList());
		
		//Maak de array aan en voeg de documenten 1 voor 1 toe.
		List<Document> documents = new ArrayList<>();
		documents.add(kaart1);
		documents.add(kaart2);
		documents.add(kaart3);
		documents.add(kaart4);
		documents.add(kaart5);
		documents.add(kaart6);
		documents.add(kaart7);
		
		//Return de array.
		return documents;
	}
	
	public List<Document> laadProductenIn()
	{
		//Maak OV-chipkaart documenten aan met verschillende waardes.
		//De ov-kaart is een veel op veel relatie, hierdoor worden er aparte documenten gemaakt met het kaartnummer, status en lastupdate en in een array gezet.
		Document product1 = new Document("productnummer", 1)
                .append("productnaam", "Dagkaart 2e klas")
                .append("beschrijving", "Een hele dag onbeperkt reizen met de trein.")
                .append("prijs", 50.6)
                .append("ov-kaart", Arrays.asList
                		(new Document("kaartnummer", 35283)
		                .append("reisproductstatus", "gekocht")
		                .append("lastupdate", "05-04-2018")));
		
		Document product2 = new Document("productnummer", 2)
                .append("productnaam", "Dagkaart fiets")
                .append("beschrijving", "Uw fiets mee in de trein, 1 dag geldig in Nederland.Uw fiets mee in de trein, 1 dag geldig in Nederland.")
                .append("prijs", 6.2)
                .append("ov-kaart", Arrays.asList
                		(new Document("kaartnummer", 35283)
		                .append("reisproductstatus", "gekocht")
		                .append("lastupdate", "05-04-2018"),
			                new Document("kaartnummer", 90537)
			                .append("reisproductstatus", "gekocht")
			                .append("lastupdate", "14-04-2018")));
		
		Document product3 = new Document("productnummer", 3)
                .append("productnaam", "Dal Voordeel 40%")
                .append("beschrijving", "40% korting buiten de spits en in het weekeind.")
                .append("prijs", 50)
                .append("ov-kaart", Arrays.asList
                		(new Document("kaartnummer", 35283)
		                .append("reisproductstatus", "actief")
		                .append("lastupdate", "31-05-2017"),
			                new Document("kaartnummer", 46392)
			                .append("reisproductstatus", "verlopen")
			                .append("lastupdate", "31-05-2017"),
				                new Document("kaartnummer", 90537)
				                .append("reisproductstatus", "actief")
				                .append("lastupdate", "01-02-2018")));
		
		Document product4 = new Document("productnummer", 4)
                .append("productnaam", "Amsterdam Travel Ticket")
                .append("beschrijving", "Onbeperkt reizen door Amsterdam.")
                .append("prijs", 26)
                .append("ov-kaart", Arrays.asList());
		
		Document product5 = new Document("productnummer", 5)
                .append("productnaam", "Railrunner")
                .append("beschrijving", "Voordelig reizen voor kinderen.")
                .append("prijs", 2.5)
                .append("ov-kaart", Arrays.asList
                		());
		
		Document product6 = new Document("productnummer", 6)
                .append("productnaam", "Studentenreisproduct")
                .append("beschrijving", "Gratis of met korting reizen als je studeert")
                .append("prijs", 0)
                .append("ov-kaart", Arrays.asList
                		(new Document("kaartnummer", 68514)
		                .append("reisproductstatus", "actief")
		                .append("lastupdate", "01-04-2018"),
	                		new Document("kaartnummer", 79625)
			                .append("reisproductstatus", "actief")
			                .append("lastupdate", "14-02-2018")));
		
		//Maak de array aan en voeg de documenten 1 voor 1 toe.
		List<Document> documents = new ArrayList<>();
		documents.add(product1);
		documents.add(product2);
		documents.add(product3);
		documents.add(product4);
		documents.add(product5);
		documents.add(product6);
		
		//Return de array.
		return documents;
	}

	public void iterate(MongoCollection<Document> collection)
	{
		//Maak een cursor om te iteraten over de collection.
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
		try {
		    while (cursor.hasNext()) {
		        System.out.println(cursor.next().toJson());
		    }
		} finally {
		    cursor.close();
		}
	}
}



