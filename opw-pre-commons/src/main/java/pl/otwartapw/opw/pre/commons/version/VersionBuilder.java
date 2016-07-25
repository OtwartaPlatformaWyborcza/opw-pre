/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
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
package pl.otwartapw.opw.pre.commons.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides access to version information.
 *
 * @author Adam Kowalewski
 * @version 2015.12.18
 */
public class VersionBuilder {

  private static final Logger logger = LoggerFactory.getLogger(VersionBuilder.class);

  private static final String VERSION = "version";
  private static final String ID = "artifactId";

  public VersionBuilder() {
  }

  public VersionDto build(String uri) {
    logger.trace("build {}", uri);
    VersionDto result = new VersionDto();

    Properties properties = new Properties();
    try {
      InputStream resourceAsStream = VersionBuilder.class.getResourceAsStream(uri);
      properties.load(resourceAsStream);
      result.setArtifactId(properties.getProperty(ID));
      result.setVersion(properties.getProperty(VERSION));
    } catch (IOException e) {
      logger.error("Properties could not be read.", e);
    } catch (NullPointerException e) {
      logger.error("Resource could not be read. ", e);
    }
    return result;
  }

}
