package famaf.unc.edu.ar.activitiesassignment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GetTopPostsTask {

    private URL url;

    public GetTopPostsTask() throws MalformedURLException{
        url = new URL("https://www.reddit.com/top/.json");
    }

    public List<Listing> execute() throws IOException {
        HttpURLConnection connection;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream jsons = connection.getInputStream();

        return null;
    }
}
