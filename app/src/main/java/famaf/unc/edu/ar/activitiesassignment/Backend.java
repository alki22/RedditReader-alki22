package famaf.unc.edu.ar.activitiesassignment;

import java.util.ArrayList;
import java.util.List;

public class Backend {
    private static Backend mInstance = new Backend();
    private List<PostModel> topPosts;

    public static Backend getInstance() {
        return mInstance;
    }

    private Backend() {
    }

    public List<PostModel> getTopPosts() {
        return topPosts;
    }


}
