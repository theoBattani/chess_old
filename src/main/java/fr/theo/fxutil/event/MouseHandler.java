package fr.theo.fxutil.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import javafx.scene.Scene;

public abstract class MouseHandler implements EventHandler<MouseEvent> {
  
  protected double mouseX, mouseY;

  public MouseHandler() {}
  public MouseHandler(Scene scene) {
    scene.setOnMousePressed(this);
    scene.setOnMouseReleased(this);
    scene.setOnMouseMoved(this);
    scene.setOnMouseDragged(this);
  }

  @Override
  public void handle(MouseEvent event) {
    mouseX = event.getX();
    mouseY = event.getY();
    if (event.getEventType() == MouseEvent.MOUSE_PRESSED ) mousePressed();
    if (event.getEventType() == MouseEvent.MOUSE_RELEASED) mouseReleased();
    if (event.getEventType() == MouseEvent.MOUSE_MOVED   ) mouseMoved();
    if (event.getEventType() == MouseEvent.MOUSE_DRAGGED ) mouseDragged();
  }

  protected abstract void mousePressed();
  protected abstract void mouseReleased();
  protected abstract void mouseMoved();
  protected abstract void mouseDragged();
}
