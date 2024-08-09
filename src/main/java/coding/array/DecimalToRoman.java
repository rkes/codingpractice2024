package coding.array;

public class DecimalToRoman {

    public static void main(String[] args) {
        int num=1000;
        String roman = "";
        for(int i=1;i<=100;i++){
            System.out.printf("%d %s \n",i,getRomanString(i));
        }
    }
    public static String getRomanString(int num){
        int temp = num;
        String []thousands = {"","M","MM","MMM"};
        String []hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String []tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String []units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String str= thousands[num/1000]+hundreds[(num%1000)/100]+ tens[(num%100)/10]+units[(num%10)];
        return str;
      }


}
