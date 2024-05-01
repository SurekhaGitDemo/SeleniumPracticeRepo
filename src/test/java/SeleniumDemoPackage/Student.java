package SeleniumDemoPackage;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    int rollNo;
    String name;

    public Student(int rollno, String Name)
    {
        this.rollNo=rollno;
        this.name=Name;
    }

    public String toString() {
        return "rollnum : "+this.rollNo+" name : "+this.name;
    }
        public static void main(String[] args) {
        int flag=0;
        for(int i=40;i<=60;i++){
            flag=0;
            for(int j=i-1;j>1;j--){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }

            if (flag==0){
                System.out.println("prime no "+i);
            }
        }


    }

}
