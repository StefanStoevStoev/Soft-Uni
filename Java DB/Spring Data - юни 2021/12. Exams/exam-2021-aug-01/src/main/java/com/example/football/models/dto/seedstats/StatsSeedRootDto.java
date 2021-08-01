package com.example.football.models.dto.seedstats;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsSeedRootDto {

    @XmlElement(name = "stat")
    private List<StatsSeedDto> stats;

    public List<StatsSeedDto> getStats() {
        return stats;
    }

    public void setStats(List<StatsSeedDto> stats) {
        this.stats = stats;
    }
}
