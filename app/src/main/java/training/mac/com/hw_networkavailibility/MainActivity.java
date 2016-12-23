package training.mac.com.hw_networkavailibility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            Toast.makeText(this, "You are connected to the network", Toast.LENGTH_SHORT).show();

            boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
            boolean isMobile = activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;

            if (isWiFi) {
                Toast.makeText(this, "You are on WIFI.", Toast.LENGTH_SHORT).show();
            }
            else if (isMobile) {
                Toast.makeText(this, "You are using data.", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "You are not connected", Toast.LENGTH_SHORT).show();
        }
    }
}
