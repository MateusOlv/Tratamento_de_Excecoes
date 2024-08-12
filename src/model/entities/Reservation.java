package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate chekin, LocalDate chekout) {
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

	public LocalDate getChekin() {
		return checkIn;
	}

	public LocalDate getChekout() {
		return checkOut;
	}
	
	public long duration() {
		Duration diff = Duration.between(checkOut, checkIn);
		return diff.toDays();
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room ");
		builder.append(roomNumber);
		builder.append(", checkIn: ");
		builder.append(fmt.format(checkIn));
		builder.append(", checkOut: ");
		builder.append(fmt.format(checkOut));
		builder.append(", ");
		builder.append(duration());
		builder.append(" nights");
		return builder.toString();
	}
		
}
