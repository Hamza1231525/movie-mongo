package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String uri = "mongodb+srv://myuser:Hej1234567@cluster0.246ywix.mongodb.net/?appName=Cluster0";
        try (MongoClient client = MongoClients.create(uri)) {

            MongoDatabase database = client.getDatabase("project1");
            MovieDAO dao = new MovieDAOImpl(database);

            System.out.println("Startar programmet...");

            dao.insert("Inception", 2010);
            System.out.println("Insert klar!");

            List<Document> movies = dao.findAll();
            System.out.println("Antal filmer: " + movies.size());

            for (Document doc : movies) {
                System.out.println(doc.toJson());
            }
        }
    }
}