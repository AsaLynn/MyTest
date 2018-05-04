package com.zxn.mytest.factory;

import android.support.v4.app.Fragment;

import com.zxn.mytest.fragment.MapFragment;
import com.zxn.mytest.fragment.RetrofitFragment;
import com.zxn.mytest.fragment.ScreenFragment;
import com.zxn.mytest.fragment.WebFragment;
import com.zxn.mytest.fragment.XFragment;

import java.util.HashMap;

public class FragmentFactory {
    private static HashMap<Integer, Fragment> map = new HashMap<>();

    public static Fragment getFragment(int position) {
        if (null == map.get(position)) {
            switch (position) {
                case 0:
                    map.put(position, new MapFragment());
                    break;
                case 1:
                    map.put(position, new RetrofitFragment());
                    break;
                case 2:
                    map.put(position, new XFragment());
                    break;
                case 3:
                    map.put(position, new WebFragment());
                    break;
                case 4:
                    map.put(position, new ScreenFragment());
                    break;
            }

        }
        return map.get(position);
    }
}
