package application;

import java.sql.Time;
import java.util.Scanner;
import java.util.UUID;

import application.text.TextOperationStupid;
import application.text.TextReaderFile;
import application.text.TextReaderTerminal;
import domains.usecase.text.TextHashMapDataManager;

public class Program {
	public Program() {
		
	}

	public static void main(String[] args) {
		UUID id1 = UUID.randomUUID();
		UUID id2 = UUID.randomUUID();
		
		Scanner scanner = new Scanner(System.in);
		
		TextHashMapDataManager textManager = new TextHashMapDataManager(new TextOperationStupid(), new TextReaderTerminal());
		
		System.out.println("Motif : ");
		textManager.createText(id1.toString());
		System.out.println("Emplacement Fichier Texte : ");
		TextHashMapDataManager textManager2 = new TextHashMapDataManager(new TextOperationStupid(), new TextReaderFile(scanner.next()));
		textManager2.createText(id2.toString()).toString();
		
		System.out.println("fichier lu");	
		long start = System.nanoTime();
		System.out.println(textManager.getOperation().searchOccurence(textManager.detailText(id1.toString()), textManager2.detailText(id2.toString())));
		long end = System.nanoTime();
		System.out.println("Terminé en " + (end - start) + " nanosecondes");
	}
}
