package codeframe.com.onlinecodein;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import codeframe.com.onlinecodein.registeration_fragments.RegisterNameFragment;

public class RegistrationActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.all_container, new RegisterNameFragment());
        transaction.commit();


    }


}
