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
package pl.otwartapw.opw.pre.ws.register;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides access to version information.
 *
 * @author Adam Kowalewski
 */
public class Version {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String URI = "/META-INF/maven/pl.otwartapw.opw/opw-pre-ws-register/pom.properties";
    private final String VERSION = "version";
    private final String ID = "artifactId";

    private Properties properties;

    public Version() {
        properties = new Properties();
        InputStream resourceAsStream = this.getClass().getResourceAsStream(URI);
        try {
            properties.load(resourceAsStream);
        } catch (IOException ex) {
            logger.error("Artifact version could not be read.", ex);
        }
    }

    /**
     * Returns version number as specified in <code>pom.properties</code>.
     *
     * @return current version number.
     * @author Adam Kowalewski
     * @version 2015.09.28
     */
    public String getVersion() {
        return properties.getProperty(VERSION);
    }

    /**
     * Returns ID of the artefact as specified in <code>pom.properties</code>.
     *
     * @return artefactId.
     * @author Adam Kowalewski
     * @version 2015.09.28
     */
    public String getName() {
        return properties.getProperty(ID);
    }

    /**
     * Returns version number in format ID-VERSION.
     *
     * @return full version.
     * @author Adam Kowalewski
     * @version 2015.09.28
     */
    public String getVersionFull() {
        return getName() + "-" + getVersion();
    }
}
