package famaf.unc.edu.ar.activitiesassignment;

import java.util.ArrayList;
import java.util.List;

public class Backend {
    private static Backend mInstance = new Backend();
    private List<PostModel> topPosts;

    public static Backend getInstance() {
        return mInstance;
    }

    private Backend() {

        topPosts = new ArrayList<>();

        PostModel pm1 = new PostModel(
                "Venecia es para chetos, pegense una vuelta por mi barrio, no se arrepentirán :)",
                "7h", "/r/Argentina", 114,
                "https://b.thumbs.redditmedia.com/pxpYCHL7wwsTAFf0vtSxDhI7MdN3Z45cERS02oPgUII.jpg");
        PostModel pm2 = new PostModel(
                "Any Miami cyclists love riding to catch a good view? ",
                "27m", "/r/Miami", 2,
                "https://b.thumbs.redditmedia.com/l1Z9YW2kZ5wDV1A4ePlbTRnmivgpU79D0re9GQ-puLo.jpg");
        PostModel pm3 = new PostModel(
                "The greatest man of all time",
                "4d", "/r/Miami", 543,
                "https://b.thumbs.redditmedia.com/VRkYXcGRw2-5zLLU.jpg");
        PostModel pm4 = new PostModel
                ("El caso de Martina en el tribunal intetnacional contra Monsanto. ", "1d",
                        "/r/Argentina", 444,
                        "https://b.thumbs.redditmedia.com/PVSFRc_O9SmvfAJ-mSf5YM9P-9jelU5TROaHJyvBJHU.jpg");
        PostModel pm5 = new PostModel(
                "Visto en la villa 31",
                "1m", "/r/Argentina", 22,
                "https://b.thumbs.redditmedia.com/ojRFshQ7r-HhD25fD6bJENRIHStOOXx_vZtGQLyShZs.jpg");

        topPosts.add(pm1);
        topPosts.add(pm2);
        topPosts.add(pm3);
        topPosts.add(pm4);
        topPosts.add(pm5);
    }

    public List<PostModel> getTopPosts() {
        return topPosts;
    }


}
