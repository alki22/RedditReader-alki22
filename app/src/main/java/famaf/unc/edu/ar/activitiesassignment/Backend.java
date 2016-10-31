package famaf.unc.edu.ar.activitiesassignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Backend {
    private static Backend mInstance = new Backend();
    private List<PostModel> mTopPosts;

    public static Backend getInstance() {
        return mInstance;
    }

    private Backend() {
    }

    public void getTopPosts (final Listener listener) {
        URL[] urls = new URL[1];
        try {
            urls[0] = new URL("https://www.reddit.com/top/.json?limit=50");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new GetTopPostsTask(){
            @Override
            protected void onPostExecute(Listing result) {
                listener.getNextPost(result);
            }
        }.execute(urls);
    }
}
