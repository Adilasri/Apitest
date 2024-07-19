package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

import java.io.Closeable;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
//        register("23");
//        addTask("23" , "toy");
//        addTask("23" , "adi");
        getTaskas("23");
       setTaskDone("23", "toy");
//        setTaskDone("23", "adi");
       getTaskas("23");






    }

    public static void getTaskas(String id){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            URI uri = new URIBuilder("https://app.seker.live/fm1/get-tasks")
                    .setParameter("id", id)
                    .build();
            HttpGet request = new HttpGet(uri);
            CloseableHttpResponse response = client.execute(request);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e){
            throw new RuntimeException(e);

        } catch (IOException e){
            throw new RuntimeException(e);
        }



    }



    public static void register(String id){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            URI uri = new URIBuilder("https://app.seker.live/fm1/register")
                    .setParameter("id", id)
                    .build();
            HttpPost request = new HttpPost(uri);
            CloseableHttpResponse response = client.execute(request);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e){
            throw new RuntimeException(e);

        } catch (IOException e){
            throw new RuntimeException(e);
        }


    }

    public static void addTask(String id, String tesk){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            URI uri = new URIBuilder("https://app.seker.live/fm1/add-task")
                    .setParameter("id", id)
                    .setParameter("text", tesk)
                    .build();
            HttpPost request = new HttpPost(uri);
            CloseableHttpResponse response = client.execute(request);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e){
            throw new RuntimeException(e);

        } catch (IOException e){
            throw new RuntimeException(e);
        }


    }

    public static void setTaskDone(String id, String tesk){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            URI uri = new URIBuilder("https://app.seker.live/fm1/set-task-done")
                    .setParameter("id", id)
                    .setParameter("text", tesk)
                    .setParameter("done", "true")
                    .build();
            HttpPost request = new HttpPost(uri);
            CloseableHttpResponse response = client.execute(request);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e){
            throw new RuntimeException(e);

        } catch (IOException e){
            throw new RuntimeException(e);
        }


    }

}