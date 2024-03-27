package com.example.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Schedule {
	@Id
	private int scheduleId;
	private String dateTime;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", dateTime=" + dateTime + "]";
	}
	
	

}
