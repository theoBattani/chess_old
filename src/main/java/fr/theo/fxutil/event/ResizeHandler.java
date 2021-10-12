
package fr.theo.fxutil.event;

import javafx.beans.Observable;
import javafx.beans.binding.DoubleExpression;
import javafx.scene.Scene;

public abstract class ResizeHandler {

  public ResizeHandler(Observable widthProperty, Observable heightProperty) {
    widthProperty.addListener(o -> resizeWidth(o));
    heightProperty.addListener(o -> resizeHeight(o));
  }

  public ResizeHandler(Scene scene) {
    scene.widthProperty().addListener(o -> resizeWidth(o));
    scene.heightProperty().addListener(o -> resizeHeight(o));
  }
  
  private void resizeWidth(Observable widthProperty) {
    double width = ((DoubleExpression) widthProperty).getValue();
    onWidth(width);

  }

  private void resizeHeight(Observable heightProperty) {
    double height = ((DoubleExpression) heightProperty).getValue();
    onHeight(height);
  }

  protected abstract void onWidth(double width);
  protected abstract void onHeight(double height);
}
