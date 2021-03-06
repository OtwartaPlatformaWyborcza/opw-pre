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
package pl.otwartapw.opw.pre.management.handler.crud;

/**
 * Represent common CRUD logic for an entity.
 *
 * @author Adam Kowalewski
 * @version 2015.03.22
 */
public interface CrudHandler {
    
    /**
     * Prepare current entity to be edited.
     */
    void prepareEdit();

    /**
     * Retrieves list of entities from database.
     */
    void prepareList();

    /**
     * Creates a new empty instance to work with.
     */
    void prepareCreate();

    /**
     * Persists a new entity in the database.
     *
     * @return JSF name of list page.
     */
    String create();

    /**
     * Edits an entity in the database.
     *
     * @return JSF name of list page.
     */
    String edit();

    /**
     * Handles 'Cancel' button within editing form.
     *
     * @return name of list view.
     */
    String cancel();

}
