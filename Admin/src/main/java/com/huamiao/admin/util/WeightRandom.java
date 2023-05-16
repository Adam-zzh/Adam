package com.huamiao.admin.util;

import com.google.common.base.Preconditions;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈权重随机数
 * 随机抽奖的模块 笔记本（10%），手机（20%），充值卡（30%），积分（40%）
 * 〉
 *
 * @author ZZH
 * @create 2021/5/5
 * @since 1.0.0
 */
public class WeightRandom<K, V extends Number> {


    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();

    public WeightRandom(List<Pair<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();//统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());//权重累加
        }

        System.out.println("------Tree init OK!--------");
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, true);
        return this.weightMap.get(tailMap.firstKey());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        List<Pair<String, Double>> list = new ArrayList<Pair<String, Double>>();
        list.add(new Pair<String, Double>("A", 0.20));
        list.add(new Pair<String, Double>("C", 0.50));
        list.add(new Pair<String, Double>("B", 0.30));

        WeightRandom weightRandom = new WeightRandom(list);
        Object random = weightRandom.random();
        System.out.println("----Key----" + random);

    }

}