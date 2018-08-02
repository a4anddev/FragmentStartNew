package c.verbswithexample.fragmentstartnew;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();
    private static final String TAG = COMMON_TAG;


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

/*
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        AFragment aFragment = new AFragment();
        transaction.add(R.id.fragA, aFragment);

        // close fragment from back button
        transaction.addToBackStack("fragmentStack");
        transaction.commit();*/


        /*
        * life cycle activity and fragment life cycle
        *  onCreate                     onAttach
        *                               onCreate
        *                               onCreateView
        *                               onActivityCreated
        *
        *
        *  onStart                      onStart
        *
        *  onResume                     onResume
        *
        *
        * onPause                       onPause
        *
        *
        *
        *  onStop                       onStop
        *
        *
        *
        * onDestory                     onDestoryView
        *                               onDestroy
        *                               onDetach
        *
        * */





    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, ACTIVITY_NAME+" onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, ACTIVITY_NAME+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, ACTIVITY_NAME+" onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, ACTIVITY_NAME+" onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, ACTIVITY_NAME+" onDestroy");
    }

    private void addFragment(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        AFragment aFragment = new AFragment();
        transaction.add(R.id.fragA, aFragment);

        // close fragment from back button
        transaction.addToBackStack("fragmentStack");
        transaction.commit();
    }

    public void AddFragmentButton(View view) {

        addFragment();
    }
}
