package c.verbswithexample.fragmentstartnew;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();
    private static final String TAG = COMMON_TAG;
     FragmentManager manager;
     FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
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

        // activity back stack is managed my ActivityManager
        // fragment back stack is managed by fragmentManager
        // fragment back stack has to be managed by developer
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


        manager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                // this method count every activity if you add automatic plus if you back button automatic minus this method help you
                // dynamic fragment call
                Toast.makeText(MainActivity.this, ""+manager.getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
            }
        });


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

        Fragment fragment;
// this method count every activity if you add automatic plus if you back button automatic minus this method help you
        // dynamic fragment call
        Toast.makeText(this, ""+manager.getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
        switch (manager.getBackStackEntryCount()){
            case 0: fragment = new AFragment(); break;
            case 1: fragment = new BFragment();break;
            case 2: fragment = new CFragment(); break;
            case 3: fragment = new DFragment(); break;
            default: fragment = new AFragment(); break;
        }



         transaction = manager.beginTransaction();
        AFragment aFragment = new AFragment();
        transaction.add(R.id.fragmentContainer, fragment, "demofragment");

        // close fragment from back button

        // this method count every activity if you add automatic plus if you back button automatic minus this method help you
        // dynamic fragment call [[[[[ addtobackstaack very important]]]]]
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void AddFragmentButton(View view) {

        addFragment();
    }
}
