package famaf.unc.edu.ar.activitiesassignment;

import java.util.List;
import famaf.unc.edu.ar.activitiesassignment.PostModel;

public class Backend {
    private static Backend ourInstance = new Backend();

    public static Backend getInstance() {
        return ourInstance;
    }

    private Backend() {
    }

    public List<PostModel> getTopPosts() {
        List<PostModel> topPosts = null;

        PostModel pm1 = new PostModel("Durísimo golpe: China suspende la compra de soja al país",
                "nikolaibk", "7h", 114, R.drawable.pm1);
        PostModel pm2 = new PostModel("Miami, never change.", "ElComandante", "27m", 2,
                R.drawable.pm2);
        PostModel pm3 = new PostModel("Miami/Dade be like", "JuanDurán", "4d",543, R.drawable.pm3);
        PostModel pm4 = new PostModel
                ("Cáncer en Córdoba: las zonas intensamente agricólas tienen mortalidad más alta",
                "Monsanto", "1d", 444, R.drawable.pm4);
        PostModel pm5 = new PostModel("Este Domingo Campeonato de Asado en la 9 de Julio.",
                "BarraBrava", "1min", 22, R.drawable.pm5);

        topPosts.add(pm1);
        topPosts.add(pm2);
        topPosts.add(pm3);
        topPosts.add(pm4);
        topPosts.add(pm5);

        return topPosts;
    }
}
