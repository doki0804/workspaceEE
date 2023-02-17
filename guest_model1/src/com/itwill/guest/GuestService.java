package com.itwill.guest;

import java.util.List;

public class GuestService {
	GuestDao guestDao;
	public GuestService() throws Exception {
		guestDao = new GuestDao();
	}
	/*
	 * 방명록 리스트
	 */
	public List<Guest> guestList() throws Exception{
		return guestDao.findAll();
	}
	
	public int removeGuest(int no) throws Exception {
		return guestDao.delete(no);
	}
	
	public Guest guestDetail(int no) throws Exception {
		return guestDao.findByNo(no);
	}
	
	public int writeGuest(Guest guest) throws Exception {
		return guestDao.insert(guest);
	}
	
	public int updateGuest(Guest guest) throws Exception{
		return guestDao.update(guest);
	}
	
}
