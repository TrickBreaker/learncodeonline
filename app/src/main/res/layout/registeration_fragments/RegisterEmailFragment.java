package com.sws.ain.registeration_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sws.ain.R;
import com.sws.ain.databinding.FragmentRegisterEmailBinding;
import com.sws.ain.models.RegisterModel;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterEmailFragment extends Fragment {

    private com.sws.ain.registeration_fragments.RegisterPasswordFragment registerPasswordFragment;
    private RegisterModel registerModel;
    private String first_name, last_name;


    public RegisterEmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final FragmentRegisterEmailBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_register_email, container, false);
        binding.setRegisterModel(new RegisterModel());
        registerPasswordFragment = new com.sws.ain.registeration_fragments.RegisterPasswordFragment();


        binding.btnEmailContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerModel = RegisterModel.getRegisterModel();
                registerModel.setEmail(binding.inputEmail.getText().toString());
                binding.setRegisterModel(registerModel);
                Toast.makeText(getActivity(), registerModel.getFirstname()+registerModel.getEmail(), Toast.LENGTH_LONG).show();

                if (!registerModel.getEmail().matches("")) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.all_container, registerPasswordFragment).addToBackStack("EmailFragment").commit();
                }


            }
        });
        return binding.getRoot();


    }

    /*private void dataCarrier() {

        Bundle args = new Bundle();
        args.putString("email", registerModel.getEmail());
        args.putString("first_name", first_name);
        args.putString("last_name", last_name);
        registerPasswordFragment.setArguments(args);
        Toast.makeText(getActivity(), registerModel.getFirstname(), Toast.LENGTH_SHORT).show();

    }*/



    }


