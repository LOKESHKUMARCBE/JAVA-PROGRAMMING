class car 
{
	public String make;
	public String model;
	public int passengerCapacity ;
	public double onRoadPrice;
	
	car(String s1,String s2,int a,double b)
	{
		make=s1;
		model=s2;
		passengerCapacity=a;
		onRoadPrice=b;
	}
}

class Car2 extends car
{
	char x;
	int max;
	double maz;
	int i;
	
	public static void getBestCar(car[] c,char x)
	{
		if (x=='c') 
		{
			max=c[0].passengerCapacity;
			i=0;
			if(c[1].passengerCapacity>max)
				{
				max=c[1].passengerCapacity;
				i=1;
			}
			if(c[2].passengerCapacity>max) 
			{
				max=c[2].passengerCapacity;
				i=2;
			}
			if(c[3].passengerCapacity>max) 
			{
				max=c[3].passengerCapacity;
				i=3;
			}
		}
		if (x=='p') {
			maz=c[0].onRoadPrice;
			i=0;
			for (int j=1;j<3;j++) {
				if(c[j].onRoadPrice>maz) 
				{
					maz=c[j].onRoadPrice;
					i=j;
				}
			}
		}
		System.out.println(c[i].make+'-'+c[i].model);
	}
}
	class CarDemo
	{
	public static void main(String[] args) 
	{
		
		car2 c = new car[4];
		c[0]=new car("hyundai","santro",4,1200);
		c[1]=new car("hyundai","verna",5,1400);
		c[2]=new car("honda","amaze",5,1300);
		c[3]=new car("mahindra","scorpio",7,1100);
		c.getBestCar(c,'p');

	}

}
