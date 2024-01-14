package com.example.helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Calculate {

    private static final List<String> EXPRESSION = Arrays.asList("+", "-", "*", "/", "(", ")");

    private static final int ADD = 1;
    private static final int SUBTRACT = 1;
    private static final int MULTIPLY = 2;
    private static final int DIVIDE = 2;
    private static final Map<String, Integer> PRIORITY = new HashMap<>();

    static {
        PRIORITY.put("+", ADD);
        PRIORITY.put("-", SUBTRACT);
        PRIORITY.put("*", MULTIPLY);
        PRIORITY.put("/", DIVIDE);
    }

    private static List<String> convertToSuffExper(String infixExpression){
        Stack<String> exprStack = new Stack<>();
        List<String> list = new ArrayList<>();
        List<String> experList = convertExpToList(infixExpression);
        for (int i =0; i < experList.size(); i ++){
            String expression = experList.get(i);
            if (isNumber(experList.get(i))){
                list.add(experList.get(i));
            }else {
                if (exprStack.isEmpty() || "(".equals(expression) || ("(".equals(exprStack.peek()) && !")".equals(expression))){
                    exprStack.push(expression);
                    continue;
                }
                if ("(".equals(expression)){
                    exprStack.push(expression);
                    continue;
                }
                if (")".equals(expression)){
                    while (!"(".equals(exprStack.peek())){
                        list.add(exprStack.pop());
                    }
                    exprStack.pop();
                    continue;
                }
                if (PRIORITY.get(expression) < PRIORITY.get(exprStack.peek())){
                    list.add(exprStack.pop());
                    exprStack.push(expression);
                }else {
                    exprStack.push(expression);
                }
            }
        }
        while (!exprStack.isEmpty()){
            list.add(exprStack.pop());
        }
        return list;
    }

    private static List<String> convertExpToList(String infixExpression){
        if (infixExpression == null || "".equals(infixExpression)){
        }
        infixExpression = infixExpression.replaceAll(" ", "");
        List<String> result = new ArrayList<>();
        for (int i =0; i < infixExpression.length(); i ++){
            if (!charIsNumber(infixExpression.charAt(i))){
                if (EXPRESSION.contains(infixExpression.charAt(i) + "")){
                    result.add(infixExpression.charAt(i) + "");
                }else {
                    throw new RuntimeException("表达式 " +infixExpression.charAt(i) + "" + "非法!");
                }
            }else {
                String str = "";
                while (charIsNumber(infixExpression.charAt(i))){
                    str += infixExpression.charAt(i);
                    if (i < infixExpression.length() -1 && charIsNumber(infixExpression.charAt(i +1))){
                        i ++;
                    }else {
                        break;
                    }
                }
                result.add(str);
            }
        }
        return result;
    }
    public static String calculateSuffix(List<String> suffixExpression){
        Stack<String> numStack = new Stack<String>();//用于保存数字
        for (String str : suffixExpression){
            if (isNumber(str)){
                numStack.push(str);
            }else {
                int num1 = Integer.parseInt(numStack.pop());
                int num2 = Integer.parseInt(numStack.pop());
                int result = caclulateRes(num1, num2, str);
                numStack.push(result + "");
            }
        }
        return numStack.pop();
    }

    private static int caclulateRes(int num1, int num2, String experssion){
        int result;
        switch (experssion){
            case "+" :
                result = num1 + num2;
                break;
            case "-" :
                result = num2 - num1;
                break;
            case "*" :
                result = num2 * num1;
                break;
            case "/" :
                result = num2 / num1;
                break;
            default:
                throw new RuntimeException("表达式" + experssion + "有误");
        }
        return result;
    }

    private static boolean isNumber(String s){
        return s.matches("^-?[1-9]\\d*$");//是否为整数数字
    }

    private static boolean charIsNumber(char s){
        return s >=48 && s <=57;//是否为整数数字
    }

    public static String c(String s){
        return calculateSuffix(convertToSuffExper(s));
    }


}

