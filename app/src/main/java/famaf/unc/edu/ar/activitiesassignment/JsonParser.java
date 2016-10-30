package famaf.unc.edu.ar.activitiesassignment;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {

    public List<Listing> readJsons(InputStream jsons) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(jsons, "utf-8"));

        try {
            return readJsonArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Listing> readJsonArray(JsonReader reader) throws IOException {
        reader.beginObject();

        List<Listing> listings = new ArrayList<Listing>();
        Listing listing = null;

        while(reader.hasNext()) {
            String name = reader.nextName();
            if (name == "data") {
                listing = readListing(reader);
                listings.add(listing);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listings;
    }

    public Listing readListing(JsonReader reader) throws IOException {
        String after, before;
        after = before = null;

        ArrayList<PostModel> posts = null;

        reader.beginObject();

        while(reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case ("children"):
                    posts = readChildren(reader);
                case("after"):
                    after = reader.nextString();
                case("before"):
                    before = reader.nextString();
                default:
                    reader.skipValue();
            }
        }

        reader.endObject();

        return new Listing(posts, after, before);
    }

    public ArrayList<PostModel> readChildren(JsonReader reader) throws IOException {
        ArrayList<PostModel> posts = new ArrayList<PostModel>();

        reader.beginArray();

        while(reader.hasNext()) {
            posts.add(readPost(reader));
        }

        reader.endArray();
        return posts;
    }

    public PostModel readPost(JsonReader reader) throws IOException {
        PostModel post = new PostModel();

        reader.beginObject();

        while(reader.hasNext()) {
            String name1 = reader.nextString();
            if(name1 == "data") {
                reader.beginObject();
                while(reader.hasNext()) {
                    String name2 = reader.nextString();
                    switch (name2) {
                        case ("subreddit"):
                            post.setmSubreddit(reader.nextString());
                        case ("score"):
                            post.setmPoints(reader.nextInt());
                        case ("title"):
                            post.setmTitle(reader.nextString());
                        case ("author"):
                            post.setmAuthor(reader.nextString());
                        case ("num_comments"):
                            post.setmCommentsNumber(reader.nextInt());
                        case ("preview"):
                            post.setmThumbnail(readThumbnail(reader));
                        default:
                            reader.skipValue();
                    }
                }
                reader.endObject();
            } else {
                reader.skipValue();
            }
        }
        return post;
    }

    public String readThumbnail(JsonReader reader) throws IOException {
        String thumbnail = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name1 = reader.nextName();
            if (name1 == "images") {
                reader.beginArray();
                while (reader.hasNext()) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        String name2 = reader.nextName();
                        if (name2 == "source") {
                            reader.beginObject();
                            while (reader.hasNext()) {
                                String name3 = reader.nextName();
                                if (name3 == "url") {
                                    thumbnail = reader.nextString();
                                } else {
                                    reader.skipValue();
                                }
                            }
                            reader.endObject();
                        } else {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return thumbnail;
    }
}
