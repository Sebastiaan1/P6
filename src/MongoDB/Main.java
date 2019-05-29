//Voor het installeren van de MongoDB is er een JAR bestand nodig, namelijk "mongo-java-driver-3.2.2.jar".
//Deze is te vinden op: https://repo1.maven.org/maven2/org/mongodb/mongo-java-driver/3.2.2/

//Zodra je deze hebt gedownload voeg je het bestand toe aan je modulepath; dit doe je door met de rechtermuistoets op je project te klikken,
//Build Path -> Configure Build Path -> Modulepath -> Add External JARS -> selecteer het JAR bestand -> Apply and Close

//Als je dit hebt gedaan, moet je vervolgens de volgende dingen toevoegen aan module-info.java:
//requires java.desktop;
//requires mongo.java.driver;
//requires java.sql;

//Nu zou de driver het moeten doen.

package MongoDB;

//Importeer de benodigdheden voor MongoDB.
import com.mongodb.*;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

//Importeer de Java error die een onbekende host selecteert.
import java.net.UnknownHostException;
//Importeer de Document type om documenten aan te maken.
import org.bson.Document;
//Importeer de klasse met de zelfgemaakte functies om de casus in te laden.
import MongoDB.LaadWaardesIn;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		//Maak een verbinding met MongoDB.
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://testnaam:testwachtwoord1@ds261096.mlab.com:61096/ov-chipkaart"));
		//Selecteer de database die je gaat gebruiken.
		MongoDatabase database = mongoClient.getDatabase("ov-chipkaart");
		//Selecteer de collecties 1 voor 1.
		MongoCollection<Document> collection1 = database.getCollection("Reiziger");
		MongoCollection<Document> collection2 = database.getCollection("OV-chipkaart");
		MongoCollection<Document> collection3 = database.getCollection("Product");
		
		//Maak een leeg BasicDBObject aan om de collecties te legen.
		BasicDBObject document = new BasicDBObject();
		
		//Instantieer de klasse met de zelfgeschreven functies.
		LaadWaardesIn laadWaardesIn = new LaadWaardesIn();
		
		//Leeg de collecties 1 voor 1.
		collection1.deleteMany(document);
		collection2.deleteMany(document);
		collection3.deleteMany(document);
		
		//Laad de reizigers en hun adressen in.
		collection1.insertMany(laadWaardesIn.laadReizigerEnAdresIn());
		//Laad de OV-chipkaarten in.
		collection2.insertMany(laadWaardesIn.laadKaartenIn());
		//Laad de producten in.
		collection3.insertMany(laadWaardesIn.laadProductenIn());
		
		//Laad alle documenten zien in de reiziger collection.
		System.out.print("Laad alle documenten zien in de reiziger collection.");
		System.out.print("\n");
		laadWaardesIn.iterate(collection1);

		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Vind en print de reiziger waarvan het ID 3 is.
		System.out.print("Vind en print de reiziger waarvan het ID 3 is.");
		System.out.print("\n");
		Document myDoc = collection1.find(eq("reizigerID", 3)).first();
		System.out.println(myDoc.toJson());
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Vind en print de OV-chipkaart waarvan het kaartnummer 68514 is.
		System.out.print("Vind en print de OV-chipkaart waarvan het kaartnummer 68514 is.");
		System.out.print("\n");
		Document myDoc2 = collection2.find(eq("kaartnummer", 68514)).first();
		System.out.println(myDoc2.toJson());
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Vind en print het product waarvan het productnummer 2 is.
		System.out.print("Vind en print het product waarvan het productnummer 2 is.");
		System.out.print("\n");
		Document myDoc3 = collection3.find(eq("productnummer", 2)).first();
		System.out.println(myDoc3.toJson());
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Update het tussenvoegsel van de reiziger met ID 1 en print de collection opnieuw.
		System.out.print("Update het tussenvoegsel van de reiziger met ID 1 en print de collection opnieuw.");
		System.out.print("\n");
		collection1.updateOne(eq("reizigerID", 1), new Document("$set", new Document("tussenvoegsel", "van der")));
		laadWaardesIn.iterate(collection1);
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Update het saldo van de OV-chipkaart met kaartnummer 57401 en print de collection opnieuw.
		System.out.print("Update het saldo van de OV-chipkaart met kaartnummer 57401 en print de collection opnieuw.");
		System.out.print("\n");
		collection2.updateOne(eq("kaartnummer", 57401), new Document("$set", new Document("saldo", 10.56)));
		laadWaardesIn.iterate(collection2);
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Update de prijs van het product met productnummer 1 en print de collection opnieuw.
		System.out.print("Update de prijs van het product met productnummer 1 en print de collection opnieuw.");
		System.out.print("\n");
		collection3.updateOne(eq("productnummer", 1), new Document("$set", new Document("prijs", 10.43)));
		laadWaardesIn.iterate(collection3);	
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Verwijder de reiziger waarvan het ID 4 is en print de collection opnieuw.
		System.out.print("Verwijder de reiziger waarvan het ID 4 is en print de collection opnieuw.");
		System.out.print("\n");
		collection1.deleteOne(eq("reizigerID", 4));
		laadWaardesIn.iterate(collection1);
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Verwijder de OV-chipkaart waarvan het kaartnummer 68514 is en print de collection opnieuw.
		System.out.print("Verwijder de OV-chipkaart waarvan het kaartnummer 68514 is en print de collection opnieuw.");
		System.out.print("\n");
		collection2.deleteOne(eq("kaartnummer", 68514));
		laadWaardesIn.iterate(collection2);
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Verwijder het product waarvan het productnummer 4 is en print de collection opnieuw.
		System.out.print("Verwijder het product waarvan het productnummer 4 is en print de collection opnieuw.");
		System.out.print("\n");
		collection3.deleteOne(eq("productnummer", 4));
		laadWaardesIn.iterate(collection3);
		System.out.print("-------------------------------------------------------------------------------------------------------");
		System.out.print("\n");
		
		//Sluit de verbinding met MongoDB.
		mongoClient.close();
		System.out.print("Connectie gesloten.");
	}

}
