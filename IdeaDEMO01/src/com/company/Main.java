package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        String percentForAYear = "0.1";//年利率
        String priceEachMonth = "4000";//每月投入
        String yearNum = "30";//年数

        String money = caculateHowMuchShouldYouHave(percentForAYear,priceEachMonth,yearNum);
        int pointIndex = money.indexOf(".");
        money = money.substring(0,pointIndex+2);
        float z = Float.valueOf(money)-Float.valueOf(priceEachMonth)*Float.valueOf(yearNum)*12;
        System.out.println(yearNum +"年来，你一共投入了"+Float.valueOf(priceEachMonth)*Float.valueOf(yearNum)*12+"元。");
        System.out.println(yearNum +"年后，你一共持有"+money+"元。");
        System.out.println(yearNum +"年后，你一共挣到"+z+"元。");
    }

    private static String caculateHowMuchShouldYouHave(String percentForAYear, String priceEachMonth, String yearNum) {

        BigDecimal perY = new BigDecimal(percentForAYear);
        BigDecimal perM = perY.divide(new BigDecimal("12"),20,BigDecimal.ROUND_UP);//月利率
        BigDecimal price = new BigDecimal(priceEachMonth);
        BigDecimal priceEachM = new BigDecimal(priceEachMonth);
        BigDecimal year = new BigDecimal(yearNum);
        BigDecimal month = year.multiply(new BigDecimal("12"));

        BigDecimal multiPer = perM.add(new BigDecimal("1"));
        for (int i = 0; i < Integer.valueOf(String.valueOf(month)); i++) {//每个月
            price = price.multiply(multiPer);
            price = price.add(priceEachM);
        }
        return price.toString();
    }
}
