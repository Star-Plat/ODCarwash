package com.ODCarwash.BookingService.service;

import java.util.List;

import com.ODCarwash.BookingService.model.bookingDetails;

public interface bookingService {
	public String addorder(bookingDetails booking);
	public List<bookingDetails> orderdetails();
	public String updateorder(bookingDetails update);
	public String deleteById(int id);
	public Long getSequenceNumber(String sequenceName);

}
