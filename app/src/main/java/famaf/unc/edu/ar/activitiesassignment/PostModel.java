package famaf.unc.edu.ar.activitiesassignment;

import android.media.Image;

import java.util.Date;

public class PostModel {
    private String mTitle;
    private String mPostDate;
    private String mSubreddit;
    private int mCommentsNumber;
    private int mThumbnail;

    public PostModel(String mTitle, String mPostDate, String mSubreddit, int mCommentsNumber, int mThumbnail) {
        this.mTitle = mTitle;
        this.mPostDate = mPostDate;
        this.mSubreddit = mSubreddit;
        this.mCommentsNumber = mCommentsNumber;
        this.mThumbnail = mThumbnail;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPostDate() {
        return mPostDate;
    }

    public void setmPostDate(String mPostDate) {
        this.mPostDate = mPostDate;
    }

    public String getmSubreddit() {
        return mSubreddit;
    }

    public void setmSubreddit(String mSubreddit) {
        this.mSubreddit = mSubreddit;
    }

    public int getmCommentsNumber() {
        return mCommentsNumber;
    }

    public void setmCommentsNumber(int mCommentsNumber) {
        this.mCommentsNumber = mCommentsNumber;
    }

    public int getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(int mThumbnail) {
        this.mThumbnail = mThumbnail;
    }
}
