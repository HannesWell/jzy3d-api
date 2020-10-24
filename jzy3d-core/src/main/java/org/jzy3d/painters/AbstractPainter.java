package org.jzy3d.painters;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.axes.IAxe;
import org.jzy3d.plot3d.rendering.canvas.IScreenCanvas;
import org.jzy3d.plot3d.rendering.scene.Scene;
import org.jzy3d.plot3d.rendering.view.Camera;
import org.jzy3d.plot3d.rendering.view.View;
import org.jzy3d.plot3d.transform.space.SpaceTransformer;

import com.jogamp.opengl.GL;

public abstract class AbstractPainter implements Painter{

	protected Camera camera;
	protected View view;
	

	public AbstractPainter() {
		super();
	}

	@Override
	public View getView() {
	    return view;
	}

	@Override
	public Camera getCamera() {
	    return camera;
	}

	@Override
	public void setCamera(Camera camera) {
	    this.camera = camera;
	}

	@Override
	public IScreenCanvas getCanvas() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public Scene getScene() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public IAxe getAxe() {
	    // TODO Auto-generated method stub
	    return null;
	}
	

	@Override
    public void color(Color color) {
        glColor4f(color.r, color.g, color.b, color.a);
    }
	
	@Override
	public void colorAlphaOverride(Color color, float alpha) {
        glColor4f(color.r, color.g, color.b, alpha);
		
	}

	@Override
	public void colorAlphaFactor(Color color, float alpha) {
        glColor4f(color.r, color.g, color.b, color.a * alpha);
	}

	
	@Override
	public void vertex(Coord3d coord, SpaceTransformer transform) {
		if (transform == null) {
			vertex(coord);
		} else {
			glVertex3f(transform.getX().compute(coord.x), transform.getY().compute(coord.y), transform.getZ().compute(coord.z));
		}
	}

	@Override
	public void vertex(Coord3d coord) {
		glVertex3f(coord.x, coord.y, coord.z);
	}



}