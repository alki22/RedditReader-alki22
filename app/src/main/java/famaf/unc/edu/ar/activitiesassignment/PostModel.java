package famaf.unc.edu.ar.activitiesassignment;

import android.media.Image;

import java.util.Date;

public class PostModel {
    private String mTitle;
    private String mSubreddit;
    private String mAuthor;
    private String mThumbnail;
    private long mPostDate;
    private int mPoints;
    private int mCommentsNumber;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSubreddit() {
        return mSubreddit;
    }

    public void setmSubreddit(String mSubreddit) {
        this.mSubreddit = mSubreddit;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(String mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public long getmPostDate() {
        return mPostDate;
    }

    public void setmPostDate(long mPostDate) {
        this.mPostDate = mPostDate;
    }

    public int getmCommentsNumber() {
        return mCommentsNumber;
    }

    public void setmCommentsNumber(int mCommentsNumber) {
        this.mCommentsNumber = mCommentsNumber;
    }

    public int getmPoints() {
        return mPoints;
    }

    public void setmPoints(int mPoints) {
        this.mPoints = mPoints;
    }
}
