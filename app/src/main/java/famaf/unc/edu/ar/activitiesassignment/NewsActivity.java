package famaf.unc.edu.ar.activitiesassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    static final int EMAIL_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_news, menu);
        return true;
    }

    private void getEmail() {
        Intent getEmailIntent = new Intent(this, LoginActivity.class);
        startActivityForResult(getEmailIntent, EMAIL_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EMAIL_REQUEST) {
            TextView textView = (TextView) findViewById(R.id.loginStatusTextView);

            if (resultCode == RESULT_OK) {
                String email = (String) data.getExtras().getString("EMAIL");
                textView.setText("User " + email + " logged in");
            } else{
                textView.setText(R.string.login_error);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sign_in) {
            NewsActivityFragment newsfragment = (NewsActivityFragment)
                    getSupportFragmentManager().findFragmentById(R.id.news_activity_fragment_id);
            getEmail();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
