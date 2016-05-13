package ggikko.me.steppertest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ggikko.me.steppertest.R;
import ggikko.me.steppertest.stepper.SteppersItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestRegistrationFragmentThirdFour extends Fragment {


    private static InvestRegistrationFragmentThirdFour investRegistrationFragmentThirdFour;
    private static SteppersItem steppersItem;

    public InvestRegistrationFragmentThirdFour() {
    }

    public static InvestRegistrationFragmentThirdFour getNewInstance(SteppersItem item){
        steppersItem = item;
        investRegistrationFragmentThirdFour = new InvestRegistrationFragmentThirdFour();
        return investRegistrationFragmentThirdFour;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invest_registration_fragment_third_four, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void stepStart() {
    }
}
