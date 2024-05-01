package SeleniumDemoPackage;

public class TimeConversionProgram {
    public static void main(String[] args) {

        String str= "12:05:45PM";
        //String str2="";
        String[] strarr= str.split(":");

        if(strarr[2].substring(2).equals("PM")){

            int time=Integer.parseInt(strarr[0])+12;
            if(time==24)
            {
                strarr[0]= "00";
            }
            else strarr[0]= String.valueOf(time);

        }

        String str1=strarr[0]+":"+strarr[1]+":"+strarr[2].substring(0,2);

        System.out.println(str1);

    }
}
