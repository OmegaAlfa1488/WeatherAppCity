package com.example.photoearthobserver.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoearthobserver.R;
import com.example.photoearthobserver.model.EpicModel;
import com.example.photoearthobserver.model.EpicViewModel;
import com.example.photoearthobserver.model.EpicViewModelFactory;
import com.example.photoearthobserver.model.ListCallback;
import com.example.photoearthobserver.model.ModelAdapter;

import java.util.List;

public class EpicFragment extends Fragment implements View.OnClickListener, ListCallback{
    Button button;
    DatePicker datePicker;
    EpicViewModel viewModel;
    List<EpicModel> list;
    RecyclerView rv;
    ModelAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_epic,container,false);
        button = view.findViewById(R.id.btn);
        button.setOnClickListener(this);
        datePicker = view.findViewById(R.id.date_picker);
        rv = view.findViewById(R.id.rv_epic);
        adapter = new ModelAdapter(getActivity(),list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         viewModel = new ViewModelProvider(this,new EpicViewModelFactory(this)).get(EpicViewModel.class);
    }

    @Override
    public void onClick(View view) {
        checkDate();
       datePicker.setVisibility(View.GONE);}


    @Override
    public void getEpicModesList(List<EpicModel> epicModels) {
        list = epicModels;
        if (list.isEmpty()) {
            Toast.makeText(getActivity(),"Sorry no data!",Toast.LENGTH_SHORT).show();
            return;}
        adapter.setEpicModels(list);
        Log.d("one", list.size() + "LIST" + list.get(0).getImage() + list.get(0).getDate());
    }
    private void checkDate(){
        String strDate = "";
        String strMonth= "";
        String strYear = Integer.toString(datePicker.getYear());
        if (datePicker.getDayOfMonth()<10){
         strDate = "-0" + datePicker.getDayOfMonth();
        }else strDate = Integer.toString(datePicker.getDayOfMonth());
        if (datePicker.getMonth()+1<10){
            strMonth = "-0" + (datePicker.getMonth() + 1);
        }else strMonth = Integer.toString(datePicker.getDayOfMonth());
        String dateForApi = strYear + strMonth + strDate;
        viewModel.getEpicModels(dateForApi);
    }
}
