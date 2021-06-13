package com.aegon.aegondemoproject.entity;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {


	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator (name="system-uuid", strategy = "uuid")
	private String id;
}
