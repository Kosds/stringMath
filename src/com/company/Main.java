package com.company;

public class Main {
    static void addZeros(StringBuffer firstNumber, StringBuffer secondNumber){
        if(firstNumber.length() < secondNumber.length()){
            while(firstNumber.length() != secondNumber.length()){
                firstNumber.insert(0,'0');
            }
        } else{
            while(firstNumber.length() != secondNumber.length()){
                secondNumber.insert(0,'0');
            }
        }
    }

    static String sum(String firstNumber,String secondNumber){
        String result = "";
        if(firstNumber.length() != secondNumber.length()) {
            StringBuffer firstBuffer = new StringBuffer(firstNumber),
                    secondBuffer = new StringBuffer(secondNumber);
            addZeros(firstBuffer, secondBuffer);
            firstNumber = firstBuffer.toString();
            secondNumber = secondBuffer.toString();
        }
        int tens = 0;
        for(int i = firstNumber.length() -1; i >= 0; i--){
            String tempResult = Integer.toString(Character.getNumericValue(firstNumber.charAt(i)) + Character.getNumericValue(secondNumber.charAt(i)) + tens);
            if(tempResult.length() == 2){
                tens = Character.getNumericValue(tempResult.charAt(0));
                tempResult = Character.toString(tempResult.charAt(1));
            } else {
                tens = 0;
            }
            result = tempResult + result;
        }
        if(tens != 0){
            result = tens + result;
        }
        return result;
    }
    static String multiplication(String firstNumber, String secondNumber){
        String result = "0";
        int tens = 0;
        for(int i = secondNumber.length() - 1; i >= 0; i--){
            String tempResult = "";
            tens = 0;
            for(int j = firstNumber.length() - 1; j >= 0; j--){
                String miniResult = Integer.toString(Character.getNumericValue(firstNumber.charAt(j)) * Character.getNumericValue(secondNumber.charAt(i)) + tens);
                if(miniResult.length() == 2){
                    tens = Character.getNumericValue(miniResult.charAt(0));
                    miniResult = Character.toString(miniResult.charAt(1));
                } else{
                    tens = 0;
                }
                tempResult = miniResult + tempResult;
            }
            for(int k = 0; k < secondNumber.length() - 1 - i; k++){
                tempResult += '0';
            }
            if(tens != 0){
                tempResult = tens + tempResult;
            }
            result = sum(tempResult,result);
        }
        return result;
    }
    static String pow(String number, int grade){
        if(grade == 0){
            return "1";
        } else {
            return multiplication(number, pow(number,grade - 1));
        }
    }
    public static void main(String[] args) {
        System.out.println(pow("2",2016));
    }
}
