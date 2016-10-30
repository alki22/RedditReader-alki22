package famaf.unc.edu.ar.activitiesassignment;

import java.util.ArrayList;
import java.util.List;

public class Listing {
    List<PostModel> mTopPosts;
    String mAfter;
    String mBefore;

    public Listing(ArrayList<PostModel> topPosts, String after, String before) {
        mTopPosts = topPosts;
        mAfter = after;
        mBefore = before;
    }

    public void addPost(PostModel post) {
        mTopPosts.add(post);
    }

    public List<PostModel> getPostsList() {
        return mTopPosts;
    }
}
