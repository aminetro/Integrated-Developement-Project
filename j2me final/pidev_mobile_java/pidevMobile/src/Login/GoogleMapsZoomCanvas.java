package Login;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

import com.jappit.midmaps.googlemaps.GoogleMaps;
import com.jappit.midmaps.googlemaps.GoogleMapsCoordinates;
import com.jappit.midmaps.googlemaps.GoogleMapsMarker;
import com.jappit.midmaps.googlemaps.GoogleStaticMap;
import com.jappit.midmaps.googlemaps.GoogleStaticMapHandler;

public class GoogleMapsZoomCanvas extends GoogleMapsTestCanvas implements GoogleStaticMapHandler
{
	GoogleMaps gMaps = null;
	GoogleStaticMap map = null;
	
	Command zoomInCommand, zoomOutCommand;
	
	public GoogleMapsZoomCanvas(MIDlet m, Displayable testListScreen,double x,double y)
	{
		super(m, testListScreen);
		
		addCommand(zoomInCommand = new Command("Zoom in", Command.OK, 1));
		addCommand(zoomOutCommand = new Command("Zoom out", Command.OK, 2));
		
		gMaps = new GoogleMaps();
		
		map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
		
		map.setHandler(this);
		
		map.setCenter(new GoogleMapsCoordinates(x, y));
                GoogleMapsMarker redMarker = new GoogleMapsMarker(new GoogleMapsCoordinates(x, y));
		redMarker.setColor(GoogleStaticMap.COLOR_RED);
		redMarker.setSize(GoogleMapsMarker.SIZE_MID);
		redMarker.setLabel('E');
		
		map.addMarker(redMarker);
		
		map.setZoom(15);
		
		map.update();
	}
	
	protected void paint(Graphics g)
	{
		map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
	}
	public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage)
	{
		showError("map error: " + errorCode + ", " + errorMessage);
	}
	public void GoogleStaticMapUpdated(GoogleStaticMap map)
	{
		repaint();
	}
	protected void keyPressed(int key)
	{
		int gameAction = getGameAction(key);
		
		if(gameAction == Canvas.UP || gameAction == Canvas.RIGHT || gameAction == Canvas.DOWN || gameAction == Canvas.LEFT)
		{
			map.move(gameAction);
		}
	}
         
       
	public void commandAction(Command c, Displayable d)
	{
		super.commandAction(c, d);
		
		if(c == zoomInCommand)
			map.zoomIn();
		else if(c == zoomOutCommand)
			map.zoomOut();
	}
}