package famaf.unc.edu.ar.activitiesassignment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsActivityFragment extends Fragment {

    public NewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        List<PostModel> list = Backend.getInstance().getTopPosts();
        ListView lv = (ListView) rootView.findViewById(R.id.post_list);
        PostAdapter adapter = new PostAdapter(getContext(), R.layout.post_model, list);

        lv.setAdapter(adapter);

        return rootView;
    }
}
