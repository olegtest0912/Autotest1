package com.promo.finmaxfx;


public class Cesar {

    protected static char[] upper =
            {'А','Б','В','Г','Д','Е','Ж','З',
                    'И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};

    protected static char[] lower= {'а','б','в','г','д','е','ж','з',
            'и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

    public static final int n = 32;
    public static final int k = 13;


    public static void main(String[] args) {
        String input = "ашхшъшееуэашхшъше";
        StringBuilder output = new StringBuilder();


        for(int i=0; i<input.length(); ++i){
            char c = input.charAt(i);

            if(findIndLower(c) == -1){
                int y = (findIndUpper(c)+k)%n;
                output.append(upper[y]);
            }
            if(findIndUpper(c) == -1){
                int y = (findIndLower(c)+k)%n;
                output.append(lower[y]);
            }
        }

        System.out.println(output.toString());
    }

    public static int findIndUpper(char c){
        int rez = -1;

        for(int i=0; i<upper.length; ++i){
            if(c == upper[i]) rez = i;
        }
        return rez;
    }

    public static int findIndLower(char c){
        int rez = -1;

        for(int i=0; i<lower.length; ++i){
            if(c == lower[i]) rez = i;
        }
        return rez;
    }

}