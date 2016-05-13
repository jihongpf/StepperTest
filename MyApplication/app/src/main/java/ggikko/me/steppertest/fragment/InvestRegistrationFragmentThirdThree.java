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

public class InvestRegistrationFragmentThirdThree extends Fragment {

    private static InvestRegistrationFragmentThirdThree investRegistrationFragmentThirdthree;
    private static SteppersItem steppersItem;


    @BindView(R.id.invest_checkbox_three_one) CheckBox invest_checkbox_three_one;

    @OnClick(R.id.invest_checkbox_three_one)
    void setAgreeClaus(){
        if(invest_checkbox_three_one.isChecked()){
            steppersItem.setPositiveButtonEnable(true);
        }else{
            steppersItem.setPositiveButtonEnable(false);
        }
    }


    public InvestRegistrationFragmentThirdThree() {
    }

    public static InvestRegistrationFragmentThirdThree getNewInstance(SteppersItem item){
        steppersItem = item;
        investRegistrationFragmentThirdthree = new InvestRegistrationFragmentThirdThree();
        return investRegistrationFragmentThirdthree;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invest_registration_fragment_third_three, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void stepStart() {
    }
}
