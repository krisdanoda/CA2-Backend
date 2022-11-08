package dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ChampsDTO {
    String type;
    private Set<ChampionDTO> data = new LinkedHashSet<>();
    public ChampsDTO(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChampsDTO{" +
                "type='" + type + '\'' +
                ", data="  + data +
                '}';
    }
}
