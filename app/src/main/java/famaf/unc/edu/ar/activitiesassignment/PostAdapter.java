package famaf.unc.edu.ar.activitiesassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class PostAdapter extends ArrayAdapter<PostModel> {

    private List<PostModel> PMList;
    int resourceNo;

    static class ViewHolder {
        TextView title;
        TextView subreddit;
        TextView postDate;
        TextView commentsNumber;
        ImageView thumbnail;
        ProgressBar bar;
    }

    public PostAdapter(Context context, int resource, List<PostModel> list) {
        super(context, resource);
        PMList = list;
        resourceNo = resource;
    }

    @Override
    public int getCount() {
        return PMList.size();
    }

    @Override
    public boolean isEmpty() {
        return PMList.isEmpty();
    }

    @Override
    public PostModel getItem(int position) {
        return PMList.get(position);
    }

    @Override
    public int getPosition(PostModel post) {
        return PMList.indexOf(post);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resourceNo, parent, false);
        }

        final ViewHolder holder;
        if (convertView.getTag() == null) {
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.post_title);
            holder.commentsNumber = (TextView) convertView.findViewById(R.id.comments_number);
            holder.subreddit = (TextView) convertView.findViewById(R.id.subreddit);
            holder.postDate = (TextView) convertView.findViewById(R.id.post_date);
            holder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
            holder.bar = (ProgressBar) convertView.findViewById(R.id.progress_bar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        PostModel post = PMList.get(position);

        boolean gotURL = false;
        URL[] urlArray = null;

        String thumbnail = post.getmThumbnail();
        try {
            urlArray = new URL[1];
            urlArray[0] = new URL(thumbnail);
            gotURL = true;
        } catch (MalformedURLException exception) {
            gotURL = false;
        }

        final boolean gotURLFinal = gotURL;
        final URL[] urlArrayFinal = urlArray;

        new ImageDownloader() {
            @Override
            protected void onPostExecute(Bitmap result) {
                super.onPostExecute(result);
                holder.bar.setIndeterminate(true);
                holder.bar.setVisibility(View.GONE);
                if (gotURLFinal) {
                    holder.thumbnail.setImageBitmap(result);
                } else {
                    holder.thumbnail.setImageResource(R.mipmap.ic_launcher);
                }
            }
        }.execute(urlArrayFinal);
        holder.title.setText(post.getmTitle());
        holder.commentsNumber.setText(String.valueOf(post.getmPoints()));
        holder.subreddit.setText("/r/" + post.getmSubreddit());
        long now = System.currentTimeMillis();
        Date time = new Date(post.getmPostDate() * 1000);
        CharSequence date = DateUtils.getRelativeTimeSpanString(time.getTime(), now, DateUtils.DAY_IN_MILLIS);
        holder.postDate.setText(date);

        return convertView;
    }

    class ImageDownloader extends AsyncTask<URL, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... urls) {
            URL url = urls[0];
            Bitmap bitmap = null;

            if (url != null) {
                HttpURLConnection connection;
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    InputStream stream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(stream, null, null);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            return bitmap;
        }
    }
}