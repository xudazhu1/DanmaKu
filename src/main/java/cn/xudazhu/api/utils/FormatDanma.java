package cn.xudazhu.api.utils;

import cn.xudazhu.api.bean.Danma;

import java.util.ArrayList;
import java.util.List;

public class FormatDanma {

    /**
     * 格式化弹幕集合 用于传给前台播放器
     * @param list 弹幕集合
     * @return  List<Object[]>
     */
    public static List<Object[]> format_danma ( List<Danma> list ) {
        List<Object[]> list2 = new ArrayList<>();
        for (Danma danmaBean : list) {
            Object [] objects = new Object[5];
            objects[0] = danmaBean.getTime();
            objects[1] = danmaBean.getType();
            objects[2] = danmaBean.getColor();
            objects[3] = danmaBean.getAuthor();
            objects[4] = danmaBean.getText();
            list2.add(objects);
        }
        return list2;
    }

}
