package pl.akademiakodu.sharedpreferences;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class RedFragment extends Fragment {


    public RedFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.fragmentButton)
    public void onClickToast(){
        Toast.makeText(this.getActivity(), "Przycisk został kliknięty z fragmentu", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // zamieniamy return va widok i pozniej zwracamy za pomoca return ten widok
        View v = inflater.inflate(R.layout.fragment_red, container, false);
        // ustawiamy Butterknife'a na ten widok :D
        ButterKnife.bind(this, v);
        return v;
    }

}
