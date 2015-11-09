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
package pl.otwartapw.opw.pre.management.handler;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.entity.OpwConfig;
import pl.otwartapw.opw.pre.management.facade.ConfigFacade;

/**
 * CRUD-Handler for all {@link pl.otwartapw.opw.pre.entity.OpwConfig} related JSF sites.
 *
 * @author Adam Kowalewski
 * @Version 2015.11.07
 */
@Named
@SessionScoped
public class ConfigHandler extends AbstractCrudHandler<OpwConfig> implements Serializable {

  private static final long serialVersionUID = 1L;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @EJB
  ConfigFacade facade;

  public ConfigHandler() {
    VIEW_ID = "config";
    VIEW_ID_EDIT = "configEdit";
    VIEW_ID_CREATE = "configCreate";
  }

  @Override
  public List<OpwConfig> getInstanceList() {
    return instanceList;
  }

  @Override
  public OpwConfig getInstance() {
    return instance;
  }

  @Override
  public void prepareList() {
    instanceList = facade.findAll();
  }

  @Override
  public void prepareCreate() {
    instance = new OpwConfig();
  }

  @Override
  public String create() {
    facade.create(instance);
    return VIEW_ID;
  }

  @Override
  public String edit() {
    facade.edit(instance);
    return VIEW_ID;
  }

}
