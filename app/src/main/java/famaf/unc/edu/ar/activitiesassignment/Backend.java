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

        PostModel pm1 = new PostModel("Durísimo golpe: China suspende la compra de soja al país",
                "7h", "/r/Argentina", 114, R.drawable.pm1);
        PostModel pm2 = new PostModel("Miami, never change.", "27m", "/r/Miami", 2,
                R.drawable.pm2);
        PostModel pm3 = new PostModel("Miami/Dade be like", "4d", "/r/Miami", 543, R.drawable.pm3);
        PostModel pm4 = new PostModel
                ("Cáncer en Córdoba: las zonas intensamente agricólas tienen mortalidad más alta",
                        "1d", "/r/Argentina", 444, R.drawable.pm4);
        PostModel pm5 = new PostModel("Este Domingo Campeonato de Asado en la 9 de Julio.",
                "1m", "/r/Argentina", 22, R.drawable.pm5);

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
