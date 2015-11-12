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

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.entity.OpwLink;
import pl.otwartapw.opw.pre.entity.OpwProtokol;

/**
 * Facade for JPA operations on entity {@link pl.otwartapw.opw.pre.entity.OpwLink}.
 *
 * @author Adam Kowalewski
 */
@Stateless
public class LinkFacade extends AbstractOpwFacade<OpwLink> {

  private static final Logger logger = LoggerFactory.getLogger(LinkFacade.class);

  @PersistenceContext(unitName = PU_OPW)
  private EntityManager em;

  public LinkFacade() {
    super(OpwLink.class);
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  @Override
  public void create(OpwLink entity) {
    entity.setDateCreated(new Date());
    super.create(entity);
  }

  /**
   * Returns all links to particular protokol.
   *
   * @param protokol protokol.
   * @param active flag.
   * @return list of all links.
   *
   */
  public List<OpwLink> findAll(OpwProtokol protokol, boolean active) {
    Query q = em.createQuery("SELECT o FROM OpwLink o WHERE o.opwProtokolId = :protokol AND o.active = :active");
    q.setParameter("wynik", protokol);
    q.setParameter("active", active);
    List<OpwLink> result = q.getResultList();
    return result;
  }

}
