package com.example.abdulrahman.tabingifts.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.abdulrahman.tabingifts.ShowDialogInterface;
import com.example.abdulrahman.tabingifts.databinding.DialogChooseQuantityBinding;


/**
 * Created by User on 2/8/2018.
 */

public class ChooseQuantityDialog extends DialogFragment {

    private static final String TAG = "ChooseQuantityDialog";

    // data binding
    DialogChooseQuantityBinding binding ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogChooseQuantityBinding.inflate(inflater);
        // set binding ..
        binding.setShowDialog((ShowDialogInterface) getActivity());
        binding.listView.setOnItemClickListener(mOnItemClickListener);
        binding.closeDialog.setOnClickListener(mCloseDialogListener);
        return binding.getRoot();
    }

    public AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d(TAG, "onItemSelected: selected: " + adapterView.getItemAtPosition(i));
            binding.getShowDialog().setQuantity(Integer.parseInt((String)adapterView.getItemAtPosition(i)));
            getDialog().dismiss();
        }
    };

    public View.OnClickListener mCloseDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getDialog().dismiss();
        }
    };
}


























