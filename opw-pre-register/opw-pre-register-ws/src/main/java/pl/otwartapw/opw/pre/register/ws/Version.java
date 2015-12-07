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
package pl.otwartapw.opw.pre.register.ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides access to version information.
 *
 * @author Adam Kowalewski
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Version implements Serializable {

  private static final long serialVersionUID = 1L;
  private final static Logger logger = LoggerFactory.getLogger(Version.class);
  private final static String VERSION = "version";
  private final static String ID = "artifactId";

  private String artifactId;
  private String version;

  private Version() {

  }

  /**
   * Method used to build Version instances that contain all version data.
   *
   * @param uri complete URI to <code>pom.properties</code>.
   * @return complete instance with version data.
   *
   * @author Adam Kowalewski
   * @version 2015.12.07
   */
  public static Version VersionBuilder(String uri) {
    Version result = new Version();

    Properties properties = new Properties();
    try {
      InputStream resourceAsStream = Version.class.getResourceAsStream(uri);
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

  public String getArtifactId() {
    return artifactId;
  }

  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return artifactId + "-" + version;
  }

}
