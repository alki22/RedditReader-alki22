package famaf.unc.edu.ar.activitiesassignment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

public class NewsActivityFragment extends Fragment implements Listener {

    View rootView;

    public NewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_news, container, false);

        if(Online()) {
            Backend.getInstance().getTopPosts(this);
        } else {
            new AlertDialog.Builder(getContext())
                    .setMessage(R.string.connection_error)
                    .setPositiveButton(R.string.connection_error_button,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dint, int id) {
                                ((Activity) getContext()).finish();
                            }
                        })
                    .show();
        }
        return rootView;
    }


    private boolean Online() {
        ConnectivityManager manager = (ConnectivityManager) getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return (info. isConnectedOrConnecting() && (info != null));
    }

    @Override
    public void getNextPost(Listing listing) {
        List<PostModel> listings = listing.getmPostList();
        ListView listView = (ListView) rootView.findViewById(R.id.post_list);
        PostAdapter adapter = new PostAdapter(getContext(), R.layout.post_model, listings);
        listView.setAdapter(adapter);
    }

}
