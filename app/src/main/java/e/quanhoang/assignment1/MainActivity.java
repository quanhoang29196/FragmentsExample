package e.quanhoang.assignment1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import e.quanhoang.assignment1.Fragments.Frag1;
import e.quanhoang.assignment1.Fragments.Frag2;
import e.quanhoang.assignment1.Fragments.Frag3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFrag(new Frag1(), "1");
        adapter.addFrag(new Frag2(), "2");
        adapter.addFrag(new Frag3(), "3");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragment = new ArrayList<>();
        private final List<String> mString = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        public void addFrag(Fragment fragment, String string) {
            mFragment.add(fragment);
            mString.add(string);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mString.get(position);
        }
    }
}
