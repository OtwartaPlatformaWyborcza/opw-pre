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
package pl.otwartapw.opw.pre.inbound.ws.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO represents Protokol Komisji Obwodowej provided by client application.
 *
 * @author Adam Kowalewski
 * @version 2015.10.16
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProtokolDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Short uprawnionych;
    @NotNull
    private Short glosujacych;
    @NotNull
    private Short kartWaznych;
    @NotNull
    private Short glosowNieWaznych;
    @NotNull
    private Short glosowWaznych;

    private String timestampCreated;
    private int ratedPositiv;
    private int ratedNegativ;

    private Map<Integer, Integer> glosyKandydataMap;
    private List<LinkDto> linkList;

    public ProtokolDto() {
        this.linkList = new ArrayList<>();
        this.glosyKandydataMap = new HashMap<>();
    }

    public ProtokolDto(Short uprawnionych, Short glosujacych, Short kartWaznych, Short glosowNieWaznych, Short glosowWaznych, String timestampCreated, int ratedPositiv, int ratedNegativ, Map<Integer, Integer> glosyKandydataMap, List<LinkDto> linkList) {
        this.uprawnionych = uprawnionych;
        this.glosujacych = glosujacych;
        this.kartWaznych = kartWaznych;
        this.glosowNieWaznych = glosowNieWaznych;
        this.glosowWaznych = glosowWaznych;
        this.timestampCreated = timestampCreated;
        this.ratedPositiv = ratedPositiv;
        this.ratedNegativ = ratedNegativ;
        this.glosyKandydataMap = glosyKandydataMap;
        this.linkList = linkList;
    }

    public Short getUprawnionych() {
        return uprawnionych;
    }

    public void setUprawnionych(Short uprawnionych) {
        this.uprawnionych = uprawnionych;
    }

    public Short getGlosujacych() {
        return glosujacych;
    }

    public void setGlosujacych(Short glosujacych) {
        this.glosujacych = glosujacych;
    }

    public Short getKartWaznych() {
        return kartWaznych;
    }

    public void setKartWaznych(Short kartWaznych) {
        this.kartWaznych = kartWaznych;
    }

    public Short getGlosowNieWaznych() {
        return glosowNieWaznych;
    }

    public void setGlosowNieWaznych(Short glosowNieWaznych) {
        this.glosowNieWaznych = glosowNieWaznych;
    }

    public Short getGlosowWaznych() {
        return glosowWaznych;
    }

    public void setGlosowWaznych(Short glosowWaznych) {
        this.glosowWaznych = glosowWaznych;
    }

    public String getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(String timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public int getRatedPositiv() {
        return ratedPositiv;
    }

    public void setRatedPositiv(int ratedPositiv) {
        this.ratedPositiv = ratedPositiv;
    }

    public int getRatedNegativ() {
        return ratedNegativ;
    }

    public void setRatedNegativ(int ratedNegativ) {
        this.ratedNegativ = ratedNegativ;
    }

    public Map<Integer, Integer> getGlosyKandydataMap() {
        return glosyKandydataMap;
    }

    public void setGlosyKandydataMap(Map<Integer, Integer> glosyKandydataMap) {
        this.glosyKandydataMap = glosyKandydataMap;
    }

    public List<LinkDto> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<LinkDto> linkList) {
        this.linkList = linkList;
    }

    @Override
    public String toString() {
        return "ProtokolDto{"
                + "uprawnionych=" + uprawnionych
                + ", glosujacych=" + glosujacych
                + ", kartWaznych=" + kartWaznych
                + ", glosowNieWaznych=" + glosowNieWaznych
                + ", glosowWaznych=" + glosowWaznych
                + ", timestampCreated=" + timestampCreated
                + ", ratedPositiv=" + ratedPositiv
                + ", ratedNegativ=" + ratedNegativ
                + ", glosyKandydataMap=" + glosyKandydataMap.size()
                + ", linkList=" + linkList.size()
                + '}';
    }

}
