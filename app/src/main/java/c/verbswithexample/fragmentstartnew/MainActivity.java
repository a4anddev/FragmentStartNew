package c.verbswithexample.fragmentstartnew;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * right click to package select fragment-> blank fragement no need change anything
        *   which activity you want to show in which you have to add xml <fragemnt> tag with name and id both are important
        *
        * */


        /*
        * dyanamic way to add fragment you have to follow same static way only you have to change activity xml file which file
        * you wanna show xml file change framelayout with id after mainactivity java you have to change
        * fragmentmanger way use
        *
        * */

        /*
        * android.support.v4.app -> fragmentactivity = getFragmentManager
        * android.support.v7.app -> appCompatActivity = getSupportFragmentManager this is support both v4 and v7
        * */


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        AFragment aFragment = new AFragment();
        transaction.add(R.id.fragA, aFragment);
        transaction.commit();

    }
}
