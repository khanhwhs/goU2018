package com.home.gou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class PTrip {
    private int id;
    private int tripId;
    private int userId;
}
