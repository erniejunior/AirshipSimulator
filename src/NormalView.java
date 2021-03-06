import processing.core.PVector;


public class NormalView extends AirshipViewer
{

    @Override
    protected void initAirshipViewer()
    {
	setCenterOffset(new PVector(0, 30, 0));
	setHeight(800);
	setWidth(1200);
    }

    @Override
    protected void drawGridsAndRulers()
    {
	textAlign(LEFT);
	//drawRuler(15, 5, 20, new PVector(0, 1, 0));
	Painter.drawRuler(this.g, 15, 5, 20, new PVector(0, 0, 1));
	Painter.drawRuler(this.g, 15, 5, 20, new PVector(1, 0, 0));
	Painter.drawRuler(this.g, 15, 5, 20, new PVector(-1, 0, 0));
	Painter.drawGrid(this.g, new PVector(-20, 0, -20), new PVector(40, 0, 0), new PVector(0, 0, 40), 40, 40);
    }

    @Override
    protected void drawLabels()
    {
	text("Central View", 30, 30);
	
	pushMatrix();
	translate(getWidth() - 200, 0);
	textAlign(RIGHT);
	
	double volume = Math.round(airship.calcVolume() * 10) / 10.0;
	double liftH2 = Math.round(volume * 0.9 * 10) / 10.0;
	double liftM4 = Math.round(volume * 0.4 * 10) / 10.0;
	double l = Math.round(airship.getLength() * 10) / 10.0;
	double maxR = Math.round(airship.getMaxRadius() * 10) / 10.0;

	
	text("Drag the mouse, play with the arrow keys!", 30, 30);
	text("Length:\n" + "Keel Length: \n" + "Maximum Radius:\n" + "Volume:\n" + "Lift with hydrogen:\n"
		+ "Lift with methane:", 30, 50);
	textAlign(RIGHT);
	text(l + "m\n" + airship.getKeelLength() + "m\n" + maxR + "m\n" + volume + "m3\n~" + liftH2 + "kg\n~" + liftM4 + "kg",
		150, 50);
	popMatrix();
    }

    @Override
    void mouseDraggedActions()
    {
	mouseXdragsRotationY();
	mouseYdragsCenterOffsetY();
    }

}
