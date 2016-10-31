package famaf.unc.edu.ar.activitiesassignment;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GetTopPostsTask extends AsyncTask<URL, Void, Listing> {

    @Override
    protected Listing doInBackground(URL... params) {
        InputStream jsons = null;

        try {
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) params[0].openConnection();
            connection.setRequestMethod("GET");
            jsons = connection.getInputStream();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Listing listing = null;

        try {
            listing = new JsonParser().readJsonStream(jsons);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return listing;
    }
}
