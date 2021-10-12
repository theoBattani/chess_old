package fr.theo.view.control.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class mouseHandler implements EventHandler<MouseEvent> {
  
  double mouseX, mouseY;
  boolean onSelection = false;

  @Override
  public void handle(MouseEvent event) {
    mouseX = event.getX();
    mouseY = event.getY();

  }

  private void select() {
    
  }

}
