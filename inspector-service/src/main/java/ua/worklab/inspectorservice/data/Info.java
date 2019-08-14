package ua.worklab.inspectorservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private UUID id;
    private Double lat;
    private Double lon;
    private String display_name;
    private String type;
    private Double osm_id;
    private String osm_type;

}
