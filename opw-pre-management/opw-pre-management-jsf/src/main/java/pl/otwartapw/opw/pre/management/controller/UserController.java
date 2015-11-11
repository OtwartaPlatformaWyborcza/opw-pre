/*
 * The MIT License
 *
 * Copyright 2015 Otwarta Platforma Wyborcza.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pl.otwartapw.opw.pre.management.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import pl.otwartapw.opw.pre.entity.OpwUser;
import pl.otwartapw.opw.pre.management.facade.UserFacade;

/**
 *
 * @author Adam Kowalewski
 */
@Named
@RequestScoped
public class UserController implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  UserFacade facade;

  public UserController() {
  }

  public OpwUser find(int id) {
    return facade.find(id);
  }

  /**
   * Default FacesConverter for {@link pl.otwartapw.opw.pre.entity.OpwUser}.
   *
   * @author Adam Kowalewski
   * @version 2015.11.08
   */
  @FacesConverter(forClass = OpwUser.class)
  public static class WojewodztwoConverter extends AbstractOpwConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      if (value == null || value.length() == 0) {
        return null;
      }
      UserController controller = (UserController) context.getApplication().getELResolver().
              getValue(context.getELContext(), null, "userController");
      return controller.find(getKey(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
      if (object == null) {
        return null;
      }
      if (object instanceof OpwUser) {
        OpwUser o = (OpwUser) object;
        return getStringKey(o.getId());
      } else {
        throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + OpwUser.class.getName());
      }
    }
  }
}
