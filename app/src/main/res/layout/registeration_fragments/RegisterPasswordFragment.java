package com.sws.ain.registeration_fragments;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sws.ain.R;
import com.sws.ain.databinding.FragmentRegisterPasswordBinding;
import com.sws.ain.models.RegisterModel;
import com.sws.ain.repository.RegisterRepository;
import com.sws.ain.viewmodel.RegisterViewModel;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterPasswordFragment extends Fragment {

    private com.sws.ain.registeration_fragments.RegisterPasswordFragment registerPasswordFragment;
    private RegisterModel mViewModel;
    private RegisterViewModel registerViewModel;


    public RegisterPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final FragmentRegisterPasswordBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_register_password, container, false);
        binding.setRegisterModel(new RegisterModel());


        binding.finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel = RegisterModel.getRegisterModel();
                mViewModel.setPassword(binding.password.getText().toString());
                mViewModel.setRe_password(binding.rePassword.getText().toString());
                binding.setRegisterModel(mViewModel);
                assert getActivity() != null;

                if (!mViewModel.getPassword().matches("") && !mViewModel.getRe_password().matches("") && mViewModel.getPassword().equals(mViewModel.getRe_password())) {
                    // registerViewModel = ViewModelProviders.of(getActivity()).get(RegisterViewModel.class);
                    //initialize the user input value to store in server
                    RegisterRepository.registerUser(getActivity(), mViewModel.getFirstname(), mViewModel.getLastname(), mViewModel.getEmail(), mViewModel.getPassword(), "investor", "UKAIN", "1", "1", getDeviceIPAddress(), "AIN_MOBILE");

                }


            }
        });

        return binding.getRoot();

    }

    private String getDeviceIPAddress() {
        assert getActivity() != null;
        WifiManager wifiMan = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        int ipAddress = wifiInf.getIpAddress();
        return String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));

    }

}
