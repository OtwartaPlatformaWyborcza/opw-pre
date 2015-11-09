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
package pl.otwartapw.opw.pre.management.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.entity.OpwConfig;

/**
 * Facade for JPA operations on entity {@link pl.otwartapw.opw.pre.entity.OpwConfig}.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class ConfigFacade extends AbstractOpwFacade<OpwConfig> {

  private static final Logger logger = LoggerFactory.getLogger(ConfigFacade.class);

  @PersistenceContext(unitName = PU_OPW)
  private EntityManager em;

  public ConfigFacade() {
    super(OpwConfig.class);
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  /**
   * Returns configuration value for given key.
   *
   * @param cfgKey configuration key.
   * @return configuration value.
   * @author Adam Kowalewski
   * @version 2015.11.09
   */
  public String readConfigValue(String cfgKey) {
    Query q = em.createNamedQuery("OpwConfig.findByCfgKey");
    q.setParameter("cfgKey", cfgKey);
    OpwConfig cfg = (OpwConfig) q.getSingleResult();
    return cfg.getCfgValue();
  }

}
