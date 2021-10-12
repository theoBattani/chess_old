package fr.theo.util.fxutil.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class MouseHandler implements EventHandler<MouseEvent> {
  
  protected double mouseX, mouseY;

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
