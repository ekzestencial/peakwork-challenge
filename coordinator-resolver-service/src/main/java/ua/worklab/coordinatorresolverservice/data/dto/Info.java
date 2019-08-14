package ua.worklab.coordinatorresolverservice.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Info {
    @JsonIgnore
    private UUID id;
    private Double lat;
    private Double lon;
    private String display_name;
    private String type;
    private Double osm_id;
    private String osm_type;

}
