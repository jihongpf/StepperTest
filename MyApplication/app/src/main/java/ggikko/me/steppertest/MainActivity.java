package ggikko.me.steppertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ggikko.me.steppertest.fragment.InvestRegistrationFragmentThirdOne;
import ggikko.me.steppertest.fragment.InvestRegistrationFragmentThirdFour;
import ggikko.me.steppertest.fragment.InvestRegistrationFragmentThirdTwo;
import ggikko.me.steppertest.fragment.InvestRegistrationFragmentThirdThree;
import ggikko.me.steppertest.stepper.OnFinishAction;
import ggikko.me.steppertest.stepper.SteppersItem;
import ggikko.me.steppertest.stepper.SteppersView;
import ggikko.me.steppertest.util.CalculatePixcel;

/**
 * stepper test
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.delete_focus) LinearLayout delete_focus;
    @BindView(R.id.steppersView) SteppersView steppersView;

    InvestRegistrationFragmentThirdOne oneStepInstance;
    InvestRegistrationFragmentThirdTwo twoStepInstance;
    InvestRegistrationFragmentThirdThree threeStepInstance;
    InvestRegistrationFragmentThirdFour fourStepInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        SteppersView.Config steppersViewConfig = new SteppersView.Config();

        steppersViewConfig.setOnFinishAction(new OnFinishAction() {
            @Override
            public void onFinish() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.class));
                MainActivity.this.finish();
            }
        });
        steppersViewConfig.setFragmentManager(getSupportFragmentManager());
        ArrayList<SteppersItem> steps = new ArrayList<>();

        //STEP 1
        final SteppersItem item = new SteppersItem();
        oneStepInstance = InvestRegistrationFragmentThirdOne.getNewInstance(item);
        item.setLabel("투자 위험 사항 동의");
        item.setSubLabel("투자 시 발생할 수 있는 위험에 대해 정리한 내용이니 꼼꼼히 읽어보시고 동의 부탁드려요. 이메일 (ggikko2@naver.com)로도 보내드렸습니다.");
        item.setFragment(oneStepInstance);
        item.setPositiveButtonEnable(true);
        steps.add(item);

        //STEP 2
        final SteppersItem item2 = new SteppersItem();

        twoStepInstance =InvestRegistrationFragmentThirdTwo.getNewInstance(item2);
        item2.setLabel("빈칸 입력");
        item2.setSubLabel("밑줄친 빈칸을 채워주세요.");
        item2.setFragment(twoStepInstance);
        item2.setPositiveButtonEnable(true);
        steps.add(item2);

        //STEP 3
        final SteppersItem item3 = new SteppersItem();
        threeStepInstance =InvestRegistrationFragmentThirdThree.getNewInstance(item3);

        item3.setLabel("신청 동의");
        item3.setSubLabel("피플펀드 투자 구조와 관련된 내용에 신청 동의 해주세요.");
        item3.setFragment(threeStepInstance);
        item3.setPositiveButtonEnable(true);
        steps.add(item3);

        //STEP 4
        final SteppersItem item4 = new SteppersItem();
        fourStepInstance =InvestRegistrationFragmentThirdFour.getNewInstance(item4);

        item4.setLabel("서명");
        item4.setSubLabel("피플펀드 투자의 약관 및 위험 사항에 동의하셨다는 의미로 아래에 서명해주세요.");
        item4.setFragment(fourStepInstance);
        steps.add(item4);

        //STEP SET
        steppersView.setConfig(steppersViewConfig);
        steppersView.setItems(steps);
        steppersView.build();
    }

    // TODO : focusing
    public void deleteAllFocus() {
        CalculatePixcel calculatePixcel = new CalculatePixcel();
        int value = calculatePixcel.dpToPixel(getApplicationContext(), 80);
//        steppersView.recyclerView.smoothScrollBy(0,value);
//        steppersView.recyclerView.getScrollY();
    }

    private void hideKeyboard(View view) {
    }
}
