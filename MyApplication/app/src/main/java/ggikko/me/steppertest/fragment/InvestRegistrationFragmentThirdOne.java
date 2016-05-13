package ggikko.me.steppertest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.CheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.steppertest.R;
import ggikko.me.steppertest.stepper.SteppersItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestRegistrationFragmentThirdOne extends Fragment {

    @BindView(R.id.invest_checkbox_one) CheckBox invest_checkbox_one;

    private static InvestRegistrationFragmentThirdOne investRegistrationFragmentThirdFirst;
    private static SteppersItem steppersItem;

    public InvestRegistrationFragmentThirdOne(){
    }

    public static InvestRegistrationFragmentThirdOne getNewInstance(SteppersItem item){
        steppersItem = item;
        investRegistrationFragmentThirdFirst = new InvestRegistrationFragmentThirdOne();
        return investRegistrationFragmentThirdFirst;
    }

    @OnClick(R.id.invest_checkbox_one)
    void setAgreeClaus(){
        if(invest_checkbox_one.isChecked()){
            steppersItem.setPositiveButtonEnable(true);
        }else{
            steppersItem.setPositiveButtonEnable(false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invest_registration_fragment_third_first, container, false);
        ButterKnife.bind(this,view);
        
        return view;
    }
}
