package coding.array;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {
        int num = 0,i;
        for( i=s.length()-1;i>0;i--){
            char c = s.charAt(i);
            char d = s.charAt(i-1);
            i = i-1;
            if(d == 'I' && (c=='V' || c=='X' )){
                if(c=='V'){
                    num +=5;
                }else{
                    num+=10;
                }
                num = num-1;
            }
            else if( d=='X' && ( c=='L' || c =='C' )){
                if(c=='L'){
                    num +=50;
                }else{
                    num+=100;
                }
                num = num-10;
            }
            else if( d=='C' && ( c=='D' || c =='M' )){
                if(c=='D'){
                    num +=500;
                }else{
                    num+=1000;
                }
                num = num-100;
            }else{
                i++;
                num = getNumForRoman(c,num);
            }
        }
        if(i==0){
            num = getNumForRoman(s.charAt(0),num);
        }
        return num;
    }
    public static int getNumForRoman(char c,int num){
        switch (c) {
            case 'I':
                num += 1;
                break;
            case 'V':
                num += 5;
                break;
            case 'X':
                num += 10;
                break;
            case 'L':
                num += 50;
                break;
            case 'C':
                num += 100;
                break;
            case 'D':
                num += 500;
                break;
            case 'M':
                num += 1000;
                break;
        }
        return num;
    }
}
