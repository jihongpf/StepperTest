package ggikko.me.steppertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import ggikko.me.steppertest.fragment.FragmentFirst;
import ggikko.me.steppertest.fragment.FragmentFourth;
import ggikko.me.steppertest.fragment.FragmentSecond;
import ggikko.me.steppertest.fragment.FragmentThird;
import ggikko.me.steppertest.stepper.OnFinishAction;
import ggikko.me.steppertest.stepper.SteppersItem;
import ggikko.me.steppertest.stepper.SteppersView;

/**
 * stepper test
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SteppersView.Config steppersViewConfig = new SteppersView.Config();

        steppersViewConfig.setOnFinishAction(new OnFinishAction() {
            @Override
            public void onFinish() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.class));
                MainActivity.this.finish();
            }
        });

        FragmentFirst first = new FragmentFirst();
        FragmentSecond second = new FragmentSecond();
        FragmentThird third = new FragmentThird();
        FragmentFourth fourth = new FragmentFourth();

        steppersViewConfig.setFragmentManager(getSupportFragmentManager());
        ArrayList<SteppersItem> steps = new ArrayList<>();

        final SteppersItem item = new SteppersItem();
        item.setLabel("first label");
        item.setSubLabel("first sublabel");
        item.setFragment(first);
        steps.add(item);

        final SteppersItem item2 = new SteppersItem();
        item2.setLabel("second label");
        item2.setSubLabel("second sublabel");
        item2.setFragment(second);
        steps.add(item2);

        final SteppersItem item3 = new SteppersItem();
        item3.setLabel("third label");
        item3.setSubLabel("third sublabel");
        item3.setFragment(third);
        steps.add(item3);

        final SteppersItem item4 = new SteppersItem();
        item4.setLabel("fourth label");
        item4.setSubLabel("fourth sublabel");
        item4.setFragment(fourth);
        steps.add(item4);

        SteppersView steppersView = (SteppersView) findViewById(R.id.steppersView);
        steppersView.setConfig(steppersViewConfig);
        steppersView.setItems(steps);
        steppersView.build();

    }
}
