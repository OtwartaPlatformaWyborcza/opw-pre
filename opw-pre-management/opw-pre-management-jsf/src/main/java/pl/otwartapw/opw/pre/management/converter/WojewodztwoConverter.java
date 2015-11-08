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
package pl.otwartapw.opw.pre.management.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.otwartapw.opw.pre.entity.OpwWojewodztwo;
import pl.otwartapw.opw.pre.management.facade.WojewodztwoFacade;

/**
 *
 * @author Adam Kowalewski
 */
@FacesConverter(forClass = OpwWojewodztwo.class)
public class WojewodztwoConverter extends AbstractOpwConverter implements Converter {
  
  @EJB
  WojewodztwoFacade facade;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null || value.length() == 0) {
      return null;
    }
//    WojewodztwoFacade facade = (WojewodztwoFacade) facesContext.getApplication().getELResolver().
//            getValue(facesContext.getELContext(), null, "wojewodztwoFacade");
    return facade.find(getKey(value));
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object object) {
    if (object == null) {
      return null;
    }
    if (object instanceof OpwWojewodztwo) {
      OpwWojewodztwo o = (OpwWojewodztwo) object;
      return getStringKey(o.getId());
    } else {
      throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + OpwWojewodztwo.class.getName());
    }
  }

}