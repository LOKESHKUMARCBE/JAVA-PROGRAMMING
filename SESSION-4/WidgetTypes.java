abstract class Widget
{
	String color;
	abstract int getMass();
	public String toString()
	{
		return getClass().getName() + ";"+color +"," + getMass();
	}
}
class WidgetA extends Widget
{
	final static int MASS = 4;
	WidgetA(String color)
	{
		this.color = color;
	}
	int getMass()
		{
			return MASS;
		}
}
class WidgetB extends Widget
{
	final static int MASS = 1;
	WidgetB(String color)
	{
		this.color = color;
	}
	int getMass()
		{
			return MASS;
		}
}
class WidgetC extends Widget
{
	final static int MASS = 5;
	WidgetC(String color)
	{
		this.color = color;
	}
	int getMass()
		{
			return MASS;
		}
}
class WidgetD extends Widget
{
	final static int MASS = 17;
	WidgetD(String color)
	{
		this.color = color;
	}
	int getMass()
		{
			return MASS;
		}
}

class WidgetTypes
	{
		static int NUMWIDGETS = 6;
		public static void main(String args[])
		{
			Widget widgets[] = new Widget[NUMWIDGETS];
			widgets[0] = new WidgetC("RED");
			widgets[1] = new WidgetA("GREEN");
			widgets[2] = new WidgetD("YELLOW");
			widgets[3] = new WidgetB("MAGENTA");
			widgets[4] = new WidgetA("BLACK");
			widgets[5] = new WidgetC("WHITE");
		
		int totalMass = 0;
		int i;
		for(i=0;i<NUMWIDGETS;i++)
			{
			Widget w = widgets[i];
			System.out.println(w);
			totalMass += w.getMass();
			}
		System.out.println("Total Mass = "+totalMass);
		}
	}
		