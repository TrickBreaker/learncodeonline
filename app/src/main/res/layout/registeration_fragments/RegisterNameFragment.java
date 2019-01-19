package com.sws.ain.registeration_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sws.ain.R;
import com.sws.ain.databinding.FragmentRegisterNameBinding;
import com.sws.ain.interfaces.ContinueButtonInterface;
import com.sws.ain.models.RegisterModel;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RegisterNameFragment extends Fragment {

    private ContinueButtonInterface continueButtonInterface;
    private RegisterModel mViewModel;
    private RegisterEmailFragment registerEmailFragment;


    public RegisterNameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        final FragmentRegisterNameBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_register_name, container, false);
        binding.setRegisterModel(new RegisterModel());
        registerEmailFragment = new RegisterEmailFragment();

        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel = RegisterModel.getRegisterModel();
                mViewModel.setFirstname(binding.firstName.getText().toString());
                mViewModel.setLastname(binding.lastName.getText().toString());
                binding.setRegisterModel(mViewModel);
                if (mViewModel.getFirstname() != null) {
                    binding.firstName.setText(mViewModel.getFirstname());
                }
                Bundle args = new Bundle();

                Toast.makeText(getActivity(), mViewModel.getFirstname(), Toast.LENGTH_LONG).show();
                if (!mViewModel.getFirstname().matches("") && !mViewModel.getLastname().matches("")) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.all_container, registerEmailFragment).addToBackStack("EmailFragment").commit();
                }


            }
        });
        return binding.getRoot();
        /*Button button =view.findViewById(R.id.btn_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    continueButtonInterface.goToEmailFragment();
                }catch(Throwable e){
                    //may be null
                }
            }
        });*/
    }

    /*@Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            continueButtonInterface =(ContinueButtonInterface)context;
        }catch(Throwable e){
            //not implemented
        }
    }*/


}

