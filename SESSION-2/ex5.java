import java.util.Scanner;

public class ex5
{
     public static void main(String[] args)
	 {
        
        int acc_details[]=new int[20];
        int num_of_days,counter;
        float mean,total=0.0f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of days");
        num_of_days=sc.nextInt();
        for(counter=0;counter<num_of_days;counter++){
            System.out.println("Enter the accident Details");
            acc_details[counter]=sc.nextInt();
            total+=acc_details[counter];
        }
        mean=total/(float)num_of_days;
        System.out.println("The mean is "+mean);
        System.out.println("The differnce is ");
        for(counter=0;counter<num_of_days;counter++){
            System.out.println(Math.abs(mean-acc_details[counter]));
         
        }
   }
}
