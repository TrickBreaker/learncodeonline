package codeframe.com.onlinecodein.registeration_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import codeframe.com.onlinecodein.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterEmailFragment extends Fragment {

    private RegisterPasswordFragment registerPasswordFragment;
    private String first_name, last_name;


    public RegisterEmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View binding = inflater.inflate(R.layout.fragment_register_email, container, false);

        registerPasswordFragment = new RegisterPasswordFragment();
        MaterialButton btnEmailContinue = binding.findViewById(R.id.btn_email_continue);


        btnEmailContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.all_container, registerPasswordFragment).addToBackStack("EmailFragment").commit();


            }
        });
        return binding;

    }


}


