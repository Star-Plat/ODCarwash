package com.ODCarwash.PaymentBlock.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class databaseSequence {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private String id;
	private long seq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	public databaseSequence(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}
	public databaseSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "databaseSequence [id=" + id + ", seq=" + seq + "]";
	} 
	
	
}
	

