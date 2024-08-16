package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
		if(checkOut.isBefore(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
		Duration duration = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return duration.toDays();
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate now = LocalDate.now();
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		else if(checkOut.isBefore(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
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
