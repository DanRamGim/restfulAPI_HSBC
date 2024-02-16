package com.HSBC.restfulAPI.Booking;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * We are using the GUID as ID because it is healthier for the database to manage it, 
 * and to not walk into errors if we need to delete manually some records.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue 
    private java.util.UUID GUID;
    @Basic
    private String CustomerName;
    private Integer TableSize;
    private java.util.Calendar BookedDate;

}
