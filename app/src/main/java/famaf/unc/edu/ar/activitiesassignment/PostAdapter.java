package famaf.unc.edu.ar.activitiesassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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
import java.util.List;

public class PostAdapter extends ArrayAdapter<PostModel> {

    private List<PostModel> PMList;
    int resourceNo;

    class ImageDownloader extends AsyncTask<URL, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(URL ... urls) {
            URL url = urls[0];
            Bitmap bitmap = null;
            HttpURLConnection connection = null;

            try{
                connection = (HttpURLConnection)url.openConnection();
                InputStream stream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(stream, null, null);
            } catch(IOException exception) {
                exception.printStackTrace();
            }

            return bitmap;
        }
    }

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
    public int getCount(){
        return PMList.size();
    }

    @Override
    public boolean isEmpty() {
        return PMList.isEmpty();
    }

    @Override
    public PostModel getItem(int position){
        return PMList.get(position);
    }

    @Override
    public int getPosition(PostModel post){
        return PMList.indexOf(post);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resourceNo, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.post_title);
            holder.commentsNumber = (TextView) convertView.findViewById(R.id.comments_number);
            holder.subreddit = (TextView) convertView.findViewById(R.id.subreddit);
            holder.postDate = (TextView) convertView.findViewById(R.id.post_date);
            holder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
            holder.bar = (ProgressBar) convertView.findViewById(R.id.progress_bar);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        PostModel post = PMList.get(position);

        URL[] urls = urlArrayCreate(post);
        new ImageDownloader(){
            @Override
            protected void onPostExecute(Bitmap result) {
                super.onPostExecute(result);
                holder.bar.setIndeterminate(true);
                holder.bar.setVisibility(View.GONE);
                holder.thumbnail.setImageBitmap(result);
                holder.thumbnail.setVisibility(View.VISIBLE);
            }
        }.execute(urls);
        holder.title.setText(post.getmTitle());
        holder.commentsNumber.setText(String.valueOf(post.getmPoints()));
        holder.subreddit.setText(post.getmSubreddit());
        holder.postDate.setText(post.getmPostDate());

        return convertView;
    }

    private URL[] urlArrayCreate(PostModel post) {
        URL[] urls = new URL[1];
        try {
            urls[0] = new URL(post.getmThumbnail());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return urls;
    }
}