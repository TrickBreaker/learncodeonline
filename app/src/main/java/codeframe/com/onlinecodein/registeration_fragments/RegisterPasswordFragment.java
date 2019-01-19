package codeframe.com.onlinecodein.registeration_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import codeframe.com.onlinecodein.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterPasswordFragment extends Fragment {

    public RegisterPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_register_password, container, false);

        MaterialButton finishBtn = view.findViewById(R.id.finish_btn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Signup Completed", Toast.LENGTH_SHORT).show();


            }
        });

        return view;

    }


}
