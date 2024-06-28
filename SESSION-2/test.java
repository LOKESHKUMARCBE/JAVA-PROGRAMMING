class employee
{
int empid;
String na;
int salary;

void display(int eid,String name,int sal)
{
	empid = eid;
	na = name;
	salary = sal;
	System.out.println("EMP ID : " +empid);
	System.out.println("EMP NAME :" +na);
	System.out.println("EMP SALARY :"+ salary);
}
}

class test
{
	public static void main(String args[])
	{
		employee e1 = new employee();
		e1.display(1566,"MANI",15000);
		employee e2 = new employee();
		e2.display(1766,"KUMAR",12000);
	}
}

