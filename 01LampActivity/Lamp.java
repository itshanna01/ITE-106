class Lamp
{
	boolean ison;
	
	void turnOn(){
		ison = true;
		System.out.println("Light On? " + ison);
	}


	void turnOff(){
		ison = false;
		System.out.println("Light Off? " + ison);
	}
}
