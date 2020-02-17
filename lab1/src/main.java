import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.port.Port;
import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.TextLCD;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.SensorModes;
import lejos.hardware.ev3.EV3;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		TextLCD lcddisplay = ev3brick.getTextLCD();
		
		Port colorPort1 = LocalEV3.get().getPort("S1"); 
		SensorModes colorSensor1 = new EV3ColorSensor(colorPort1);
		SampleProvider colorProvider1 = colorSensor1.getMode("Ambient");
		float[] colorSample1 = new float[colorProvider1.sampleSize()];
		Port colorPort2 = LocalEV3.get().getPort("S4"); 
		SensorModes colorSensor2 = new EV3ColorSensor(colorPort2);
		SampleProvider colorProvider2 = colorSensor2.getMode("Ambient");
		float[] colorSample2 = new float[colorProvider2.sampleSize()];
		
		
		while(true) {
			colorProvider1.fetchSample(colorSample1, 0);
			String str = Float.toString(colorSample1[0]);
			colorProvider2.fetchSample(colorSample2, 0);
			String str2 = Float.toString(colorSample2[0]);
			lcddisplay.drawString(str, 2, 4);
			lcddisplay.drawString(str2, 2, 6);
		}
	}

}
