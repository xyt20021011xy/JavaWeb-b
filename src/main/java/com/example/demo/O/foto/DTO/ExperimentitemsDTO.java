package com.example.demo.O.foto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperimentitemsDTO {
    private String itemno;
    private String itemname;
    private String courseno;
    private Integer itemhour;
    private String itemcontent;
    private Integer itemtype;
    private Integer iscompulsory;





    @Override
    public String toString() {
        return "ExperimentItem{" +
                "itemno='" + itemno + '\'' +
                ", itemname='" + itemname + '\'' +
                ", courseno='" + courseno + '\'' +
                ", itemhour=" + itemhour +
                ", itemcontent='" + itemcontent + '\'' +
                ", itemtype=" + itemtype +
                ", iscompulsory=" + iscompulsory +
                '}';
    }
}

