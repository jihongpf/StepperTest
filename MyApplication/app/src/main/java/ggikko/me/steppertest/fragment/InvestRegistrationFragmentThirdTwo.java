package ggikko.me.steppertest.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import ggikko.me.steppertest.R;
import ggikko.me.steppertest.stepper.SteppersItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestRegistrationFragmentThirdTwo extends Fragment {

    private static InvestRegistrationFragmentThirdTwo investRegistrationFragmentThirdTwo;
    private static SteppersItem steppersItem;

    @BindView(R.id.invest_third_edit_dictation_one) EditText invest_third_edit_dictation_one;
    @BindView(R.id.invest_third_edit_dictation_two) EditText invest_third_edit_dictation_two;
    @BindView(R.id.delete_focus) View delete_focus;

    public InvestRegistrationFragmentThirdTwo() {
    }

    public static InvestRegistrationFragmentThirdTwo getNewInstance(SteppersItem item){
        steppersItem = item;
        investRegistrationFragmentThirdTwo = new InvestRegistrationFragmentThirdTwo();
        return investRegistrationFragmentThirdTwo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invest_registration_fragment_third_second, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnTextChanged(R.id.invest_third_edit_dictation_one)
    void dicationOne (CharSequence text){
        Log.e("ggikko", "changed");
        if(text.toString().equals("받")){
            Log.e("ggikko", "ok");
//            hideKeyboard(getActivity(), invest_third_edit_dictation_one);
            invest_third_edit_dictation_two.requestFocus();
            invest_third_edit_dictation_two.setCursorVisible(true);
        }else{
            Log.e("ggikko", "no");
            steppersItem.setPositiveButtonEnable(false);
        }
    }

    @OnTextChanged(R.id.invest_third_edit_dictation_two)
    void dicationTwo (CharSequence text){
        Log.e("ggikko", "changed");
        if(text.toString().equals("투")){
            Log.e("ggikko", "ok");
//            hideKeyboard(getActivity(), invest_third_edit_dictation_one);
            disAppearKeyBoard();
            steppersItem.setPositiveButtonEnable(true);

        }else{
            Log.e("ggikko", "no");
            steppersItem.setPositiveButtonEnable(false);
        }
    }

    public void showKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void disAppearKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static void hideKeyboard(Activity activity, View viewToHide) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewToHide.getWindowToken(), 0);
    }

    public void stepStart() {
        invest_third_edit_dictation_one.requestFocus();
        invest_third_edit_dictation_one.setCursorVisible(true);
        showKeyBoard();
    }
}
