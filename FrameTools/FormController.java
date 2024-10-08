/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrameTools;

/**
 *
 * @author ndhlt
 * @param <Entity>
 */
public abstract class FormController<Entity> extends SubController {

    abstract public void setForm(Entity e);

    abstract public Entity getEntity();

    abstract protected boolean checkInput();
}
