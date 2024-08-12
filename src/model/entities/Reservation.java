package model.entities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;

public class Reservation {
	private Integer roomNumber;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reservation(Integer roomNumber, LocalDateTime chekin, LocalDateTime chekout) {
		this.roomNumber = roomNumber;
		this.checkIn = chekin;
		this.checkOut = chekout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDateTime getChekin() {
		return checkIn;
	}

	public LocalDateTime getChekout() {
		return checkOut;
	}
	
	public long duration() {
		Duration diff = Duration.between(checkOut, checkIn);
		return diff.toDays();
	}
	
	public void updateDates(LocalDateTime checkIn, LocalDateTime checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room ");
		builder.append(roomNumber);
		builder.append(", checkIn: ");
		builder.append(sdf.format(checkIn));
		builder.append(", checkOut: ");
		builder.append(sdf.format(checkOut));
		builder.append(", ");
		builder.append(duration());
		builder.append(" nights");
		return builder.toString();
	}
		
}
