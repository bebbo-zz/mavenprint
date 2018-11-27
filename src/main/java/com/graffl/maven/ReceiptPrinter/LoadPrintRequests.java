package com.graffl.maven.ReceiptPrinter;

import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class LoadPrintRequests {

	public ReceiptToPrint[] allForPrint;
	
	public LoadPrintRequests() {
		// Use a service account
	    InputStream serviceAccount = App.class.getResourceAsStream("/ServiceAccountKey.json");
	    GoogleCredentials credentials = null;
		try {
			credentials = GoogleCredentials.fromStream(serviceAccount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    FirebaseOptions options = new FirebaseOptions.Builder()
	        .setCredentials(credentials)
	        .build();
	    FirebaseApp.initializeApp(options);

	    Firestore db = FirestoreClient.getFirestore();
	    
	 // asynchronously retrieve all users
	    ApiFuture<QuerySnapshot> query = db.collection("orders").get();
	    // ...
	    // query.get() blocks on response
	    QuerySnapshot querySnapshot = null;
		try {
			querySnapshot = query.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
	    for (QueryDocumentSnapshot document : documents) {
	      System.out.println("User: " + document.getId());
	      System.out.println("First: " + document.getString("created"));
	      if (document.contains("middle")) {
	        System.out.println("Middle: " + document.getString("middle"));
	      }
	      System.out.println("Last: " + document.getString("receiptId"));
	    }
	}	
}
