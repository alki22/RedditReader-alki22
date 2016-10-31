package famaf.unc.edu.ar.activitiesassignment;

import java.util.ArrayList;
import java.util.List;

public class Listing {
    private List<PostModel> mPostList;
    private String mAfter;
    private String mBefore;

    public Listing(ArrayList<PostModel> posts, String after, String before) {
        mPostList = posts;
        mAfter = after;
        mBefore = before;
    }

    public List<PostModel> getmPostList() {
        return mPostList;
    }

    public String getmAfter() {
        return mAfter;
    }

    public String getmBefore() {
        return mBefore;
    }

    public void setmPostList(List<PostModel> mPostList) {
        this.mPostList = mPostList;
    }

    public void setmAfter(String mAfter) {
        this.mAfter = mAfter;
    }

    public void setmBefore(String mBefore) {
        this.mBefore = mBefore;
    }
}
