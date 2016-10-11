package famaf.unc.edu.ar.activitiesassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        int position;
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

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resourceNo, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.post_title);
            holder.commentsNumber = (TextView) convertView.findViewById(R.id.comments_number);
            holder.subreddit = (TextView) convertView.findViewById(R.id.subreddit);
            holder.postDate = (TextView) convertView.findViewById(R.id.post_date);
            holder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        PostModel post = PMList.get(position);

        holder.title.setText(post.getmTitle());
        holder.commentsNumber.setText(String.valueOf(post.getmCommentsNumber()));
        holder.subreddit.setText(post.getmSubreddit());
        holder.postDate.setText(post.getmPostDate());
        holder.thumbnail.setImageResource(post.getmThumbnail());

        return convertView;
    }
}