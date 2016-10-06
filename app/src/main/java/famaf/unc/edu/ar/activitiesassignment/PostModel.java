package famaf.unc.edu.ar.activitiesassignment;

import android.media.Image;

import java.util.Date;

public class PostModel {
    private String mTitle;
    private String mAuthor;
    private String mPostDate;
    private int mCommentsNumber;
    private int mThumbnail;

    public PostModel(String mTitle, String mAuthor, String mPostDate, int mCommentsNumber, int mThumbnail) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mPostDate = mPostDate;
        this.mCommentsNumber = mCommentsNumber;
        this.mThumbnail = mThumbnail;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmPostDate() {
        return mPostDate;
    }

    public void setmPostDate(String mPostDate) {
        this.mPostDate = mPostDate;
    }

    public Integer getmCommentsNumber() {
        return mCommentsNumber;
    }

    public void setmCommentsNumber(int mCommentsNumber) {
        this.mCommentsNumber = mCommentsNumber;
    }

    public int getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(Integer mThumbnail) {
        this.mThumbnail = mThumbnail;
    }
}
