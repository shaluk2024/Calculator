package com.calc;

import java.sql.Connection;
import java.util.Scanner;

public class Calculate {
 
public static void getSum()
{
Scanner sc=new Scanner(System.in);	
DatabseUtility db=new DatabseUtility();
Connection connection=null;

int num1;
int num2;
int sum;
System.out.println("Please enter first number...");
num1=sc.nextInt();
System.out.println("Please enter second number...");
num2=sc.nextInt();
sum=num1+num2;
System.out.println("Sum of numbers = "+sum);
sc.close();


try {
	 connection=db.getConnection();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if(connection != null)
db.InserIntoSum(connection, num1, num2, sum);

}
}
