package famaf.unc.edu.ar.activitiesassignment;

import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {

    public Listing readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readJSON(reader);
        } finally {
            reader.close();
        }
    }

    public Listing readJSON(JsonReader reader) throws IOException {
        Listing listing = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "data":
                    listing = readData(reader);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        reader.close();
        return listing;
    }

    public Listing readData(JsonReader reader) throws  IOException {
        String after = null;
        String before = null;
        ArrayList<PostModel> postList = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "children":
                    postList = readChildren(reader);
                    break;
                case "after":
                    after = reader.nextString();
                    break;
                case "before":
                    if (reader.peek() != JsonToken.NULL)
                        before = reader.nextString();
                    try {
                        before = reader.nextString();
                    } catch (IllegalStateException e) {
                        before = null;
                        reader.nextNull();
                    }

                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();

        return new Listing(postList, after, before);
    }

    public ArrayList<PostModel> readChildren(JsonReader reader) throws IOException {
        ArrayList<PostModel> postList = new ArrayList<PostModel>();

        reader.beginArray();
        while(reader.hasNext()) {
            postList.add(readPost(reader));
        }
        reader.endArray();
        return postList;
    }

    public PostModel readPost(JsonReader reader) throws IOException {
        PostModel post = new PostModel();

        reader.beginObject();
        while(reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("data")) {
                reader.beginObject();
                while(reader.hasNext()) {
                    String name1 = reader.nextName();
                    switch (name1) {
                        case "subreddit":
                            post.setmSubreddit(reader.nextString());
                            break;
                        case "score":
                            post.setmPoints(reader.nextInt());
                            break;
                        case "title":
                            post.setmTitle(reader.nextString());
                            break;
                        case "author":
                            post.setmAuthor(reader.nextString());
                            break;
                        case "num_comments":
                            post.setmCommentsNumber(reader.nextInt());
                            break;
                        case "thumbnail":
                            post.setmThumbnail(reader.nextString());
                            break;
                        case "created_utc":
                            post.setmPostDate(reader.nextLong());
                            break;
                        default:
                            reader.skipValue();
                            break;
                    }
                }
                reader.endObject();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return post;
    }

}