package islam.somon.governmentjobcircularandaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements ImageView.OnClickListener  {

    private ImageView ivCiruclar, ivApply, ivService, ivContact, ivLogout;

    private RewardedAd rewardedAd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);






        ivCiruclar = findViewById(R.id.ivCircular);
        ivApply = findViewById(R.id.ivApply);
        ivService = findViewById(R.id.ivService);
        ivContact = findViewById(R.id.ivContact);
        ivLogout = findViewById(R.id.ivLogout);


        ivCiruclar.setOnClickListener(this);
        ivApply.setOnClickListener(this);
        ivService.setOnClickListener(this);
        ivContact.setOnClickListener(this);
        ivLogout.setOnClickListener(this);






    }



    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.ivCircular:
                Intent intent = new Intent(MainActivity.this, CircularActivity.class);
                startActivity(intent);

                break;

            case R.id.ivApply:
                Intent intent1 = new Intent(MainActivity.this, ApplyActivity.class);
                startActivity(intent1);
                break;

            case R.id.ivService:
                Intent intent2 = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent2);
                break;

            case R.id.ivContact:
                Intent intent3 = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent3);
                break;

            case R.id.ivLogout:
                seeAds();
                FirebaseAuth.getInstance().signOut();
                Intent intent4 = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent4);
                finish();
                break;






        }


    }

    public void seeAds()
    {
        if (rewardedAd.isLoaded())
        {
            Activity activityContext = MainActivity.this;
            RewardedAdCallback adCallback = new RewardedAdCallback() {
                @Override
                public void onRewardedAdOpened() {
                    // Ad opened.
                }

                @Override
                public void onRewardedAdClosed() {
                    // Ad closed.
                }

                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                }

                @Override
                public void onRewardedAdFailedToShow(int errorCode) {
                    // Ad failed to display.
                }
            };
            rewardedAd.show(activityContext, adCallback);
        }
        else
         {
            Log.d("TAG", "The rewarded ad wasn't loaded yet.");
         }

    }


}

