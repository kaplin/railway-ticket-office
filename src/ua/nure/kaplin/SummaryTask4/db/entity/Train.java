package ua.nure.kaplin.SummaryTask4.db.entity;

public class Train {
	private int trainNunber;
	private int coupe;
	private int reservedSeat;
	private int common;
	private int coupe_price;
	private int reserved_seat_price;
	private int common_price;
	public int getTrainNunber() {
		return trainNunber;
	}
	public void setTrainNunber(int trainNunber) {
		this.trainNunber = trainNunber;
	}
	public int getCoupe() {
		return coupe;
	}
	public void setCoupe(int coupe) {
		this.coupe = coupe;
	}
	public int getReservedSeat() {
		return reservedSeat;
	}
	public void setReservedSeat(int reservedSeat) {
		this.reservedSeat = reservedSeat;
	}
	public int getCommon() {
		return common;
	}
	public void setCommon(int common) {
		this.common = common;
	}
	public int getCoupe_price() {
		return coupe_price;
	}
	public void setCoupe_price(int coupe_price) {
		this.coupe_price = coupe_price;
	}
	public int getReserved_seat_price() {
		return reserved_seat_price;
	}
	public void setReserved_seat_price(int reserved_seat_price) {
		this.reserved_seat_price = reserved_seat_price;
	}
	public int getCommon_price() {
		return common_price;
	}
	public void setCommon_price(int common_price) {
		this.common_price = common_price;
	}
	
}
