package com.parenting.coach.ParentingCoach.data;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class WorkShopImagesId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long workShopId;
    private Long imageId;

    // Default constructor, Getters, Setters, equals(), and hashCode() methods
}
