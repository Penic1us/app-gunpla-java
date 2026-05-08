import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        String supabaseUrl = "https://zwyfjtskaboslpqofsxx.supabase.co/rest/v1/Gunplas?select=*";
        String supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inp3eWZqdHNrYWJvc2xwcW9mc3h4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzgyNzM3ODYsImV4cCI6MjA5Mzg0OTc4Nn0.1dlDtUJWu4xlwjIKn__WwgAtJGNYSo_XrusZmdoqx74";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(supabaseUrl))
                    .header("apikey", supabaseKey)
                    .header("Authorization", "Bearer " + supabaseKey)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            System.out.println("Datos de mi colección Gunpla:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Error al conectar con Supabase: " + e.getMessage());
        }
    }
}