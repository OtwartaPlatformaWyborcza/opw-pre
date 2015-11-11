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

import java.util.ArrayList;
import java.util.List;

/**
 * Provide common methods and attributes for all CRUD handlers.
 *
 * @param <T> DTO class to be used.
 * @author Adam Kowalewski
 * @version 2015.11.08
 */
public abstract class AbstractCrudHandler<T> implements CrudHandler {

  final String PATTERN_DATE = "yyyy.MM.dd";
  final String PATTERN_DATETIME = "yyyy.MM.dd HH:mm";

  boolean viewMode = true;
  T instance;
  List<T> instanceList;
  List<T> instanceListFiltered;

  String VIEW_ID;
  String VIEW_ID_EDIT;
  String VIEW_ID_CREATE;

  public AbstractCrudHandler() {
    instanceList = new ArrayList<>();
  }

  /**
   * Configures default set of destinations for JSF navigation e.g. <code>user</code>,
   * <code>userEdit</code> and <code>userCreate</code>.
   *
   *
   * @param name entity name e.g. <code>user</code>.
   * @author Adam Kowalewski
   * @version 2015.11.11
   */
  public void initViews(String name) {
    VIEW_ID = name;
    VIEW_ID_EDIT = VIEW_ID + "Edit";
    VIEW_ID_CREATE = VIEW_ID + "Create";
  }

  /**
   * TODO
   *
   * @param r instance of an entity to view.
   * @return TODO
   * @author Adam Kowalewski
   * @version 2015.03.19
   */
  public String prepareView(T r) {
    instance = r;
    viewMode = true;
    return VIEW_ID_EDIT + "?faces-redirect=true";
  }

  public String prepareEdit(T r) {
    instance = r;
    viewMode = false;
    return VIEW_ID_EDIT;
  }

  @Override
  public void prepareEdit() {
    viewMode = false;
  }

  @Override
  public String cancel() {
    viewMode = true;
    return VIEW_ID + "?faces-redirect=true";
  }

  public boolean isViewMode() {
    return viewMode;
  }

  public void setViewMode(boolean viewMode) {
    this.viewMode = viewMode;
  }

  public T getInstance() {
    return instance;
  }

  public void setInstance(T instance) {
    this.instance = instance;
  }

  public List<T> getInstanceList() {
    return instanceList;
  }

  public void setInstanceList(List<T> instanceList) {
    this.instanceList = instanceList;
  }

  public List<T> getInstanceListFiltered() {
    return instanceListFiltered;
  }

  public void setInstanceListFiltered(List<T> instanceListFiltered) {
    this.instanceListFiltered = instanceListFiltered;
  }

  public String getCreateLink() {
    return VIEW_ID_CREATE;
  }

  public String getPATTERN_DATE() {
    return PATTERN_DATE;
  }

  public String getPATTERN_DATETIME() {
    return PATTERN_DATETIME;
  }

}
